package farmstory.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.OrderDTO;
import farmstory.dto.UserDTO;
import farmstory.util.ConnectionHelper;

public class UserDAO implements CountableDAO<UserDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class.getName());
  private final ConnectionHelper helper;

  public UserDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(UserDTO dto) {
  }

  @Override
  public UserDTO select(UserDTO dto) {
    return null;
  }

  @Override
  public List<UserDTO> selectAll() {
    return null;
  }

  @Override
  public void update(UserDTO dto) {

  }

  @Override
  public void delete(UserDTO dto) {

  }

  @Override
  public int count() {
    return 0;
  }



}
