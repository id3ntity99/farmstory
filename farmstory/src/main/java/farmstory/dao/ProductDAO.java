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
		String sql = "INSERT INTO product (id, company_id, name, category, price, point, discount_rate, delivery_fee, stock, image_id, register_date) "
				+ "VALUES (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		try (Connection conn = helper.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
			psmt.setInt(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getCategory());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getPoint());
			psmt.setInt(6, dto.getDiscountRate());
			psmt.setInt(7, dto.getDeliveryFee());
			psmt.setInt(8, dto.getStock());

			int rowsAffected = psmt.executeUpdate();

			if (rowsAffected > 0) {
				// 상품이 정상적으로 추가되면, 자동 생성된 product_id를 반환받는다.
				ResultSet rs = psmt.getGeneratedKeys();
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					dto.setId(generatedId); // 반환된 product_id를 dto에 세팅
				}
				rs.close();
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

	@Override
	public ProductDTO select(ProductDTO dto) throws DataAccessException {
		String sql = "SELECT * FROM product WHERE id = ?";

		try (Connection conn = helper.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
			psmt.setInt(1, dto.getId());
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setId(rs.getInt("id"));
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
		String sql = "SELECT * FROM product";

		try (Connection conn = helper.getConnection();
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery()) {
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setPoint(rs.getInt("point"));
				product.setDiscountRate(rs.getInt("discount_rate"));
				product.setDeliveryFee(rs.getInt("delivery_fee"));
				product.setStock(rs.getInt("stock"));
				product.setImageId(rs.getInt("image_id"));
				product.setRegisterDate(rs.getString("register_date"));
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
		// TODO Auto-generated method stub

	}

	@Override
	public int count() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void insertProductImage(ProductImageDTO imageDTO) throws DataAccessException {
        String sql = "INSERT INTO product_image (product_id, thumbnail_location, info_location, detail_location) "
                   + "VALUES (?, ?, ?, ?)";

	public void insertProductImage(ProductImageDTO imageDTO) throws DataAccessException {
		String sql = "INSERT INTO product_image (product_id, thumbnail_location, info_location, detail_location) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection conn = helper.getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
			psmt.setInt(1, imageDTO.getProductid());
			psmt.setString(2, imageDTO.getThumbnailLocation());
			psmt.setString(3, imageDTO.getInfoLocation());
			psmt.setString(4, imageDTO.getDetailLocation());

			int rowsAffected = psmt.executeUpdate();
			if (rowsAffected == 0) {
				throw new DataAccessException("상품 이미지 등록에 실패했습니다.", null);
			}
		} catch (SQLException e) {
			LOGGER.error("SQL Error: " + e.getMessage(), e);
			throw new DataAccessException("상품 이미지를 등록하는 도중 예외가 발생했습니다.", e);
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
}
