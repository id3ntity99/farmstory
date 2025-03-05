package farmstory.service;


import java.util.List;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.exception.DataAccessException;

public class UserService extends DefaultService<UserDTO> {
  private UserDAO userDAO;

  public UserService(UserDAO dao) {
    super(dao);
    this.userDAO = dao;
  }

  public UserDTO findUser(String name, String email) throws DataAccessException {
    return userDAO.findUser(name, email);
  }

  public List<UserDTO> findResult() throws DataAccessException {
    return userDAO.selectResult();
  }

  public int count(String colName, String condition) throws DataAccessException {
    return userDAO.count(colName, condition);
  }

}
