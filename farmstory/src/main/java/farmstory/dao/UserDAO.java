package farmstory.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.DefaultDAO;
import farmstory.dto.UserDTO;
import farmstory.util.ConnectionHelper;

public class UserDAO extends DefaultDAO<UserDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class.getName());

  public UserDAO(ConnectionHelper helper) {
    super(helper);
  }

  public List<UserDTO> join() {
    // FIXME SQL의 JOIN 처럼 DefaultDAO에는 없는 특수한 쿼리에 관한 메서드는 new UserDAO().join() 메서드처럼 명시해서 사용한다. 예제
    // 코드.
    return null;
  }

}
