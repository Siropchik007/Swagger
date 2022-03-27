package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
public class Request{
	private String photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;

}