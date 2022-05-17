package model;

public class TagsItem{
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public TagsItem name (String name){
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public TagsItem id (int id){
		this.id = id;
		return this;
	}

	public void setId(int id) {
		this.id = id;
	}

}
