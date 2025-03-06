package farmstory.dto;

import farmstory.DataTransferObject;

public class CommentDTO implements DataTransferObject {
	
	private int id;
	private int articleId;
	private String author;
	private String content;
	private String register_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "CommentDAO [id=" + id + ", article_id=" + articleId + ", author=" + author + ", content=" + content
				+ ", register_date=" + register_date + "]";
	}
	
	
	
}
