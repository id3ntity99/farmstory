package farmstory.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.ProductDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;

public class ProductDAO implements CountableDAO<ProductDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class.getName());
  private final ConnectionHelper helper;

  public ProductDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(ProductDTO dto) {
    // TODO Auto-generated method stub
  }

  @Override
  public ProductDTO select(ProductDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ProductDTO> selectAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(ProductDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(ProductDTO dto) {
    // TODO Auto-generated method stub

  }


  @Override
  public int count(String colName, String condition) throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }

}
