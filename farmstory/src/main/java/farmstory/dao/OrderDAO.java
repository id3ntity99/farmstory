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
import farmstory.dto.UserDTO;
import farmstory.util.ConnectionHelper;

public class OrderDAO implements CountableDAO<OrderDTO> {
  private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class.getName());
  private final ConnectionHelper helper;
  private Connection conn;
  
  public OrderDAO(ConnectionHelper helper, Connection conn) {
    this.helper = helper;
    this.conn = conn;
  }


  @Override
  public void insert(OrderDTO dto) {
    
  }

  @Override
  public OrderDTO select(OrderDTO dto) {
    
    return null;
  }

  
@Override
  public List<OrderDTO> selectAll() {
	  
	  
	  try {
		  
		
	}catch (Exception e) {
		logger.error(e.getMessage());
	} 
    return null;
  }

  @Override
  public void update(OrderDTO dto) {
    

  }

  @Override
  public void delete(OrderDTO dto) {
   

  }

  @Override
  public int count() {
    
    return 0;
  }
}
