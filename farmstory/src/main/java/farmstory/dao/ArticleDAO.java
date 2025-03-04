package farmstory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    // TODO Auto-generated method stub
    String sql = "insert into `article` (`title`, `content`, `author`) values (?,?,?)`";

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
	  String sql = "select * from `article` where `id`=?";
	  ArticleDTO articleDTO = null;
	  
	  try {
		  Connection conn = helper.getConnection();
		  PreparedStatement psmt = conn.prepareStatement(sql);
		  
		  psmt.setInt(1, dto.getId());
		  ResultSet rs = psmt.executeQuery();
		  
		  if(rs.next()) {
			  articleDTO = new ArticleDTO();
			  articleDTO.setId(rs.getInt("id"));
			  articleDTO.setTitle(rs.getString("title"));
			  articleDTO.setContent(rs.getString("content"));
			  articleDTO.setAuthor(rs.getString("author"));
			  articleDTO.setRegisterDate(rs.getString("registerDate"));
		  }
		  
		  
	  }catch(Exception e) {
		  LOGGER.error(e.getMessage());
	  }
	  
	  return articleDTO;
    
  }
  @Override
  public List<ArticleDTO> selectAll() {
    String sql = "select * from `article` order by `id` desc";
    List<ArticleDTO> articles = new ArrayList<>();
    
    try {
    	Connection conn = helper.getConnection();
    	PreparedStatement psmt = conn.prepareStatement(sql);
    	
    	ResultSet rs = psmt.executeQuery();
    	
    	while(rs.next()) {
    		ArticleDTO articleDTO = new ArticleDTO();
    		articleDTO.setId(rs.getInt("id"));
    		articleDTO.setTitle(rs.getString("title"));
    		articleDTO.setContent(rs.getString("content"));
    		articleDTO.setAuthor(rs.getString("author"));
    		articleDTO.setRegisterDate(rs.getString("registerDate"));
    		
    		articles.add(articleDTO);
    	}
    	
    }catch (Exception e) {
    	LOGGER.error(e.getMessage());
	}
    
    return articles;
  }
  @Override
  public void update(ArticleDTO dto) {
    String sql = "update `article` set `title`=?, `content`=? where `id`=?";
    try {
    	Connection conn = helper.getConnection();
    	PreparedStatement psmt = conn.prepareStatement(sql);
    	
    	psmt.setString(1, dto.getTitle());
        psmt.setString(2, dto.getContent());
        psmt.setInt(3, dto.getId());

        psmt.executeUpdate();
    	
    }catch (Exception e) {
    	LOGGER.error(e.getMessage());
	}
  }
  @Override
  public void delete(ArticleDTO dto) {
    String sql = "delete from `article` where `id`=?";
    
    try {
    	Connection conn = helper.getConnection();
    	PreparedStatement psmt = conn.prepareStatement(sql);
    	
    	psmt.setInt(1, dto.getId());
    	psmt.executeUpdate();
    	
    }catch (Exception e) {
    	LOGGER.error(e.getMessage());
	}
  }
  
  public int count() {
    String sql = "select count(*) from `article`";
    int count = 0;
    
    try {
    	Connection conn = helper.getConnection();
    	PreparedStatement psmt = conn.prepareStatement(sql);
    	ResultSet rs = psmt.executeQuery();
    	
    	if(rs.next()) {
    		count = rs.getInt(1);
    	}
    	
    }catch (Exception e) {
		LOGGER.error(e.getMessage());
	}
    
    return count;
  }
  
  //추가 메서드: 특정 게시글 번호로 조회
  public ArticleDTO findByNo(int no) {
      String sql = "SELECT * FROM articles WHERE no = ?";
      ArticleDTO article = null;

      try (Connection conn = helper.getConnection();
           PreparedStatement psmt = conn.prepareStatement(sql)) {

          psmt.setInt(1, no);
          ResultSet rs = psmt.executeQuery();

          if (rs.next()) {
              article = new ArticleDTO();
              article.setId(rs.getInt("id"));
              article.setTitle(rs.getString("title"));
              article.setContent(rs.getString("content"));
              article.setAuthor(rs.getString("author"));
              article.setRegisterDate(rs.getString("regitserDate"));
          }
      } catch (Exception e) {
          LOGGER.error("게시글 번호 조회 중 오류 발생: " + e.getMessage());
      }

      return article;
  }
}