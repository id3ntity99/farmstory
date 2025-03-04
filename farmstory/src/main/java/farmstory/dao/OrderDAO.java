package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.OrderDTO;
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
    // TODO Auto-generated method stub
	  
	  
	  
  }

  @Override
  public OrderDTO select(OrderDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<OrderDTO> selectAll() {
	  
	  List<OrderDTO> orders = new ArrayList<OrderDTO>();
	  String sql = "select * from `order`";
	  
	  try {
		  Connection conn = helper.getConnection();
		  PreparedStatement psmt = conn.prepareStatement(sql);
		  ResultSet rs = psmt.executeQuery();
		  
		  while(rs.next()) {
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
   String sql = "delete from `order` where `id`=?";
   
   try {
	   Connection conn = helper.getConnection();
	   PreparedStatement psmt = conn.prepareStatement(sql);
	   psmt.setInt(1, dto.getId());
	   psmt.executeUpdate();
	   conn.close();
	   psmt.close();
	
   	} catch (Exception e) {
		LOGGER.error(e.getMessage());
	}

  }
  
@Override
public int count() {
	// TODO Auto-generated method stub
	return 0;
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
