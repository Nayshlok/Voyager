package models;

public class Post {

	private Long id = 0l;
	private Long counter = 1l;
	private String title;
	private String message;
	private String author;
	
	public Post() {}
	
	public Post(String title, String message, String author) {
		id = ++counter;
		this.setTitle(title);
		this.setMessage(message);
		this.author = author; 
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}

	public Long getCounter() {
		return counter;
	}

	public void setCounter(Long counter) {
		this.counter = counter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}	
	
	
}