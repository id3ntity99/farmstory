package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.ArticleDTO;
import farmstory.exception.DataAccessException;
import farmstory.util.ConnectionHelper;

public class ArticleDAO implements CountableDAO<ArticleDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDAO.class.getName());
  private final ConnectionHelper helper;

  public ArticleDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(ArticleDTO dto) {
    String sql = "insert into `articles (title, content, writer) values (?,?,?)`";
    
    try {
    	Connection conn = helper.getConnection();
    	PreparedStatement psmt = conn.prepareStatement(sql);
    	
    	psmt.setString(1, dto.getTitle());
    	psmt.setString(2, dto.getContent());
    	psmt.setString(3, dto.getAuthor());
    	
    	psmt.executeUpdate();
    	

    }catch (Exception e) {
		LOGGER.error(e.getMessage());
	}
  }

  @Override
  public ArticleDTO select(ArticleDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ArticleDTO> selectAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(ArticleDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(ArticleDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public int count() {
    // TODO Auto-generated method stub
    return 0;
  }
}
