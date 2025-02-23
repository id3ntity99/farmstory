package farmstory.service;

import java.util.List;
import farmstory.DefaultService;
import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;

public class UserService extends DefaultService<UserDTO> {
  public UserService(UserDAO dao) {
    super(dao);
  }

  public List<UserDTO> join() {
    // FIXME 예제코드
    return null;
  }
}
