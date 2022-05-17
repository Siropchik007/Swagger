package model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

public class Pet {
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public Pet photoUrls (List<String> photoUrls){
		this.photoUrls = photoUrls;
		return this;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}



	public String getName() {
		return name;
	}

	public Pet name (String name){
		this.name = name;
		return  this;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}
	public Pet id (int id){
		this.id = id;
		return  this;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Category getCategory() {
		return category;
	}
	public Pet category (Category category){
		this.category = category;
		return  this;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public List<TagsItem> getTags() {
		return tags;
	}
	public Pet tags (List<TagsItem> tags){
		this.tags = tags;
		return  this;
	}

	public void setTags(List<TagsItem> tags) {
		this.tags = tags;
	}



	public String getStatus() {
		return status;
	}
	public Pet status (String status){
		this.status = status;
		return  this;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}