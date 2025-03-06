package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.ProductDTO;
import farmstory.dto.ProductImageDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;

public class ProductDAO implements CountableDAO<ProductDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class.getName());
  private final ConnectionHelper helper;

  public ProductDAO(ConnectionHelper helper) {
    this.helper = helper;
  }

  @Override
  public void insert(ProductDTO dto) throws DataAccessException {
    String sql =
        "INSERT INTO product (id, company_id, name, category, price, point, discount_rate, delivery_fee, stock, image_id, register_date) "
            + "VALUES (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      psmt.setInt(1, dto.getId());
      psmt.setString(2, dto.getName());
      psmt.setString(3, dto.getCategory());
      psmt.setInt(4, dto.getPrice());
      psmt.setInt(5, dto.getPoint());
      psmt.setInt(6, dto.getDiscountRate());
      psmt.setInt(7, dto.getDeliveryFee());
      psmt.setInt(8, dto.getStock());
      psmt.setInt(9, dto.getImageId());

      int rowsAffected = psmt.executeUpdate();

      if (rowsAffected > 0) {
        // 상품이 정상적으로 추가되면, 자동 생성된 product_id를 반환받는다.
        ResultSet rs = psmt.getGeneratedKeys();
        if (rs.next()) {
          int generatedId = rs.getInt(1);
          dto.setId(generatedId); // 반환된 product_id를 dto에 세팅
        }
        rs.close();

        // 이미지 등록 후, product_image 테이블의 id를 받아서 productDTO에 설정
        ProductImageDTO imageDTO = new ProductImageDTO();
        imageDTO.setProductid(dto.getId());
        imageDTO.setThumbnailLocation(dto.getThumbnailLocation());
        imageDTO.setInfoLocation(dto.getInfoLocation());
        imageDTO.setDetailLocation(dto.getDetailLocation());
        // 상품 이미지 등록
        int imageId = 0;

        // 이미지 경로가 null이 아닌 경우에만 상품 이미지를 등록
        if (imageDTO.getThumbnailLocation() != null || imageDTO.getInfoLocation() != null
            || imageDTO.getDetailLocation() != null) {
          imageId = insertProductImage(imageDTO);
        }

        // 만약 이미지 ID가 유효하다면, 해당 ID를 상품에 설정하고 상품 테이블에서 이미지 ID를 업데이트
        if (imageId > 0) {
          dto.setImageId(imageId); // 등록된 이미지 ID를 상품에 설정
          updateProductImageId(dto); // 상품 테이블에서 이미지 ID 업데이트
        } else {
          // 이미지 등록이 실패한 경우, 로그를 남기거나 예외를 던질 수 있음
          LOGGER.warn("상품 이미지 등록 실패: 이미지 ID가 0으로 반환됨");
        }
      } else {
        throw new DataAccessException("상품 등록에 실패했습니다.", null);
      }
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e);
      throw new DataAccessException("상품을 등록하는 도중 예외가 발생했습니다.", e);
    } catch (NamingException e1) {
      e1.printStackTrace();
    }
  }

  public void updateProductImageId(ProductDTO dto) throws DataAccessException {
    String sql = "UPDATE product SET image_id = ? WHERE id = ?";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)) {
      psmt.setInt(1, dto.getImageId()); // 새로 저장된 이미지의 id
      psmt.setInt(2, dto.getId()); // 상품의 id

      int rowsAffected = psmt.executeUpdate();
      if (rowsAffected == 0) {
        throw new DataAccessException("상품 이미지 ID 업데이트에 실패했습니다.", null);
      }
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e);
      throw new DataAccessException("상품 이미지 ID를 업데이트하는 도중 예외가 발생했습니다.", e);
    } catch (NamingException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public ProductDTO select(ProductDTO dto) throws DataAccessException {
    String sql = "SELECT * FROM product WHERE id = ?";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)) {
      psmt.setInt(1, dto.getId());
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        ProductDTO product = new ProductDTO();
        product.setId(rs.getInt("id"));
        product.setCompany_id(rs.getInt("company_id"));
        product.setName(rs.getString("name"));
        product.setCategory(rs.getString("category"));
        product.setPrice(rs.getInt("price"));
        product.setPoint(rs.getInt("point"));
        product.setDiscountRate(rs.getInt("discount_rate"));
        product.setDeliveryFee(rs.getInt("delivery_fee"));
        product.setStock(rs.getInt("stock"));
        product.setImageId(rs.getInt("image_id"));
        product.setRegisterDate(rs.getString("register_date"));
        return product;
      }
      return null;
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e);
      throw new DataAccessException("상품을 조회하는 도중 예외가 발생했습니다.", e);
    } catch (NamingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return dto;
  }

  @Override
  public List<ProductDTO> selectAll() throws DataAccessException {
    List<ProductDTO> productList = new ArrayList<>();
    String sql =
        "SELECT * FROM product JOIN product_image ON product.id = product_image.product_id";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery()) {
      while (rs.next()) {
        ProductDTO product = new ProductDTO();
        product.setId(rs.getInt("id"));
        product.setCompany_id(rs.getInt("company_id"));
        product.setName(rs.getString("name"));
        product.setCategory(rs.getString("category"));
        product.setPrice(rs.getInt("price"));
        product.setPoint(rs.getInt("point"));
        product.setDiscountRate(rs.getInt("discount_rate"));
        product.setDeliveryFee(rs.getInt("delivery_fee"));
        product.setStock(rs.getInt("stock"));
        product.setImageId(rs.getInt("image_id"));
        product.setRegisterDate(rs.getString("register_date"));
        product.setThumbnailLocation(rs.getString("thumbnail_location"));
        product.setInfoLocation(rs.getString("info_location"));
        product.setDetailLocation(rs.getString("detail_location"));
        productList.add(product);
      }
      return productList;
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e);
      throw new DataAccessException("상품 목록을 조회하는 도중 예외가 발생했습니다.", e);
    } catch (NamingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return productList;

  }

  @Override
  public void update(ProductDTO dto) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(ProductDTO dto) {
    String sql = "DELETE FROM `product` WHERE id = ?";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)) {
      psmt.setInt(1, dto.getId());
      int rowsAffected = psmt.executeUpdate();

      if (rowsAffected > 0) {
        LOGGER.info("상품 번호 " + dto.getId() + " 삭제 완료");
      } else {
        LOGGER.warn("상품 번호 " + dto.getId() + " 삭제 실패");
      }

    } catch (SQLException e) {
      LOGGER.error("상품 삭제 오류: " + e.getMessage());
    } catch (NamingException e1) {
      e1.printStackTrace();
    }

  }

  @Override
  public int count() throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }

  public int insertProductImage(ProductImageDTO imageDTO) throws DataAccessException {
    // 이미지 경로가 모두 null인 경우 등록하지 않도록 처리
    if (imageDTO.getThumbnailLocation() == null && imageDTO.getInfoLocation() == null
        && imageDTO.getDetailLocation() == null) {
      return 0; // 유효한 이미지 경로가 없으므로 0을 반환
    }

    String sql =
        "INSERT INTO product_image (product_id, thumbnail_location, info_location, detail_location) "
            + "VALUES (?, ?, ?, ?)";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      psmt.setInt(1, imageDTO.getProductid());
      psmt.setString(2, imageDTO.getThumbnailLocation());
      psmt.setString(3, imageDTO.getInfoLocation());
      psmt.setString(4, imageDTO.getDetailLocation());

      int rowsAffected = psmt.executeUpdate();

      if (rowsAffected > 0) {
        ResultSet rs = psmt.getGeneratedKeys();
        if (rs.next()) {
          int generatedImageId = rs.getInt(1); // 삽입된 이미지의 id를 반환
          LOGGER.info("생성된 이미지 ID: {}", generatedImageId); // 로그로 확인
          return generatedImageId;
        }
      }

      throw new DataAccessException("상품 이미지 등록에 실패했습니다.", null);
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e);
      throw new DataAccessException("상품 이미지를 등록하는 도중 예외가 발생했습니다.", e);
    } catch (NamingException e1) {
      e1.printStackTrace();
    }

    return 0; // 실패한 경우 0 반환
  }
}
