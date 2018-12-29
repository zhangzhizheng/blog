package entity;

public class Tag {
	private int id;
	private String tagName;
	private int status;
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	public Tag(int id, String tagName, int status) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
}
