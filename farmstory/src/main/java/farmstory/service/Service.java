package farmstory;

import java.util.List;

/**
 * 추상 클래스. 싱글톤 패턴을 사용하지 않고, 내부적으로 사용되는 DAO를 생성자를 통해 인자로 전달 받는다. 구체적인 클래스 또는 인터페이스의 구현체를 type으로서 사용하는
 * 것보다 추상클래스 또는 인터페이스를 type으로 사용하는 것이 좋다. <br>
 * 그 이유는, 구현체의 코드가 변경되어도 인터페이스나 추상 클래스에 명시되어 있는 메서드를 그대로 써도 되기 때문이다.
 * 
 * @param <T> {@link DataTransferObject}를 상속하는 DTO.
 */
public interface Service<T extends DataTransferObject> {
  void create(T dto) throws DataAccessException;

  T get(T dto) throws DataAccessException;

  List<T> getAll() throws DataAccessException;

  void update(T dto) throws DataAccessException;

  void delete(T dto) throws DataAccessException;
}
