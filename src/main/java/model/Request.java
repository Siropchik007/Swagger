package model;

import lombok.Data;

import java.util.List;
@Data
public class Request{
	private String photoUrls;
	private String name;
	private int id;
	private String status;
	private Category category;
	private List<TagsItem> tags;


}