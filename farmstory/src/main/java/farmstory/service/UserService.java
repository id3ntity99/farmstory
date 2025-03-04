package farmstory.service;

import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;

public class UserService extends DefaultService<UserDTO> {
  private UserDAO dao;

  public UserService(UserDAO dao) {
    super(dao);
  }

  public int count(String colName, String condition) throws DataAccessException {
    return dao.count(colName, condition);
  }
}
