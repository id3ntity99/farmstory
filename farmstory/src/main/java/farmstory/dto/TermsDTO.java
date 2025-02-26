package farmstory.dto;

import farmstory.DataTransferObject;

public class TermsDTO implements DataTransferObject {
	
	private int id;
	private String title;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "TermsDTO [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	

}
