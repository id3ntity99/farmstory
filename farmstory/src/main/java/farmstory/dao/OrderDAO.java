package farmstory.dao;

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(OrderDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(OrderDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public int count(String colName, String condition) throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }
}
