package farmstory;

/**
 * MySQL의 COUNT() 함수를 사용해야 하는 DAO는 본 인터페이스를 구현한다. 예를 들어, UserDAO는 특정 아이디를 사용하는 사용자가 몇명인지 확인하기 위해
 * {@link #count()} 메서드를 가져야 하므로, 아래와 같이 UserDAO를 선언한다. <br>
 * 
 * <pre>
 * {@code 
 * CountableDAO<UserDTO> dao = new UserDAO(new {@link ConnectionHelper};
 * int count = dao.count();
 * List<UserDTO> users = dao.selectAll();
 * }
 * </pre>
 * 
 * @param <T> {@link #insert}, {@link #select(DataTransferObject)}, {@link #selectAll()}
 *        {@link #update(DataTransferObject)}, {@link #delete(DataTransferObject)} 메서드의 반환 타입 또는
 *        파라미터 타입.
 * 
 */
public interface CountableDAO<T extends DataTransferObject> extends DataAccessObject<T> {
  /**
   * MySQL의 COUNT() 함수
   * 
   * 예를 들어 아래의 쿼리의 실행값이 1이라면 본 메서드는 1을 반환한다. <br>
   * <code>
   * SELECT COUNT(`id`) FROM `user` WHERE `id`="abc123";
   * </code>
   * 
   * @return MySQL의 COUNT() 함수의 결과값
   */
  int count();
}
