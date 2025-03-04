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
import farmstory.dto.OrderDTO;
import farmstory.dto.ProductDTO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;

public class OrderDAO implements CountableDAO<OrderDTO> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class.getName());
	private final ConnectionHelper helper;

	public OrderDAO(ConnectionHelper helper) {
		this.helper = helper;
	}

	@Override
	public void insert(OrderDTO dto) {

	}

	@Override
	public OrderDTO select(OrderDTO dto) {
		String sql = "select * from `order` where `id`=?";
		OrderDTO orderDTO = null;

		try {
			Connection conn = helper.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getId());
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				orderDTO = new OrderDTO();
				orderDTO.setId(rs.getInt("id"));
				orderDTO.setUserId(rs.getString("user_id"));
				orderDTO.setProductId(rs.getInt("product_id"));
				orderDTO.setAmount(rs.getInt("amount"));
				orderDTO.setPlacedDate(rs.getString("placed_date"));
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return orderDTO;
	}

	public List<OrderDTO> selectAll() {
		String sql = "SELECT o.id, o.user_id, o.product_id, o.amount, o.placed_date, "
				+ "p.name AS product_name, p.price AS product_price, p.delivery_fee AS delivery_fee, "
				+ "u.name AS user_name " + "FROM `order` o " + "JOIN product p ON o.product_id = p.id "
				+ "JOIN user u ON o.user_id = u.id";

		List<OrderDTO> orders = new ArrayList<>();

		try (Connection conn = helper.getConnection(); 
				PreparedStatement psmt = conn.prepareStatement(sql)) {

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getString("user_id"));
				order.setProductId(rs.getInt("product_id"));
				order.setAmount(rs.getInt("amount"));
				order.setPlacedDate(rs.getString("placed_date"));
				order.setProductName(rs.getString("product_name"));
				order.setProductPrice(rs.getInt("product_price"));
				order.setDeliveryFee(rs.getInt("delivery_fee"));
				order.setUserName(rs.getString("user_name"));

				// 합계 계산: 가격 * 수량 + 배송비
				int totalPrice = order.getProductPrice() * order.getAmount() + order.getDeliveryFee();
				order.setTotalPrice(totalPrice);

				orders.add(order);
			}
		} catch (SQLException e) {
			LOGGER.error("SQL Error: " + e.getMessage(), e); // 로깅
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return orders;
	}

  @Override
  public void insert(OrderDTO dto) {

  }

  @Override
  public OrderDTO select(OrderDTO dto) {
    String sql = "select * from `order` where `id`=?";
    OrderDTO orderDTO = null;

    try {
      Connection conn = helper.getConnection();
      PreparedStatement psmt = conn.prepareStatement(sql);

      psmt.setInt(1, dto.getId());
      ResultSet rs = psmt.executeQuery();

      if (rs.next()) {
        orderDTO = new OrderDTO();
        orderDTO.setId(rs.getInt("id"));
        orderDTO.setUserId(rs.getString("user_id"));
        orderDTO.setProductId(rs.getInt("product_id"));
        orderDTO.setAmount(rs.getInt("amount"));
        orderDTO.setPlacedDate(rs.getString("placed_date"));
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }

    return orderDTO;
  }

  @Override
  public List<OrderDTO> selectAll() throws DataAccessException {
    // TODO Auto-generated method stub
    List<OrderDTO> orders = new ArrayList<OrderDTO>();
    String sql = "select * from `order`";

    try {
      Connection conn = helper.getConnection();
      PreparedStatement psmt = conn.prepareStatement(sql);
      ResultSet rs = psmt.executeQuery();

      while (rs.next()) {
        OrderDTO dtos = new OrderDTO();
        dtos.setId(rs.getInt(1));
        dtos.setUserId(rs.getString(2));
        dtos.setProductId(rs.getInt(3));
        dtos.setAmount(rs.getInt(4));
        dtos.setPlacedDate(rs.getString(5));
        orders.add(dtos);
      }
      conn.close();
      psmt.close();
      rs.close();
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return orders;
  }


  @Override
  public void update(OrderDTO dto) {

    String sql = "update `order` set `amount` = ? where `id` = ?";

    try {
      Connection conn = helper.getConnection();
      PreparedStatement psmt = conn.prepareStatement(sql);
      psmt.setInt(1, dto.getAmount());
      psmt.setInt(2, dto.getId());
      psmt.executeUpdate();
      conn.close();
      psmt.close();

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }

  }

  @Override
  public void delete(OrderDTO dto) {
    String sql = "DELETE FROM `order` WHERE id = ?;";

    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)) {
      psmt.setInt(1, dto.getId());
      int rowsAffected = psmt.executeUpdate();

      if (rowsAffected > 0) {
        LOGGER.info("주문 번호 " + dto.getId() + " 삭제 완료");
      } else {
        LOGGER.warn("주문 번호 " + dto.getId() + " 삭제 실패");
      }

    } catch (SQLException e) {
      LOGGER.error("주문 삭제 오류: " + e.getMessage());
    } catch (NamingException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public int count() {
    String sql = "SELECT COUNT(*) FROM `order`";
    int count = 0;
    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery()) {

      if (rs.next()) {
        count = rs.getInt(1);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return count;
  }

  public List<OrderDTO> selectAll(int offset, int limit) {
    List<OrderDTO> orders = new ArrayList<>();
    String sql = "SELECT o.id, o.user_id, o.product_id, o.amount, o.placed_date, "
        + "p.name AS product_name, p.price AS product_price, p.delivery_fee AS delivery_fee, "
        + "u.name AS user_name " + "FROM `order` o " + "JOIN product p ON o.product_id = p.id "
        + "JOIN user u ON o.user_id = u.id " + "LIMIT ?, ?";
    try (Connection conn = helper.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)) {

      psmt.setInt(1, offset); // offset 설정
      psmt.setInt(2, limit); // limit 설정

      ResultSet rs = psmt.executeQuery();

      while (rs.next()) {
        OrderDTO order = new OrderDTO();
        order.setId(rs.getInt("id"));
        order.setUserId(rs.getString("user_id"));
        order.setProductId(rs.getInt("product_id"));
        order.setAmount(rs.getInt("amount"));
        order.setPlacedDate(rs.getString("placed_date"));
        String prodName = rs.getString("product_name");
        String prodPrice = rs.getString("product_price");
        String deliveryFee = rs.getString("delivery_fee");
        String userName = rs.getString("user_name");


        ProductDTO product = new ProductDTO();
        product.setName(prodName);
        product.setPrice(Integer.parseInt(prodPrice));
        product.setDeliveryFee(Integer.parseInt(deliveryFee));

        UserDTO user = new UserDTO();
        user.setName(userName);
        // 합계 계산: 가격 * 수량 + 배송비
        int totalPrice =
            order.getProduct().getPrice() * order.getAmount() + order.getProduct().getDeliveryFee();
        order.setTotalPrice(totalPrice);

        orders.add(order);
      }
    } catch (SQLException e) {
      LOGGER.error("SQL Error: " + e.getMessage(), e); // 로깅
    } catch (NamingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    return orders;
  }


  public void placeOrder(String userId) {
    String sql = "delete from `order` where `userId`=?";

    try {
      Connection conn = helper.getConnection();
      PreparedStatement psmt = conn.prepareStatement(sql);
      psmt.setString(1, userId);
      psmt.executeUpdate();
      conn.close();
      psmt.close();
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }
}
