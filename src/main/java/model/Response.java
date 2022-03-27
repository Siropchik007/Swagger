package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class Response{
	private List<String> photoUrls;
	private String name;
	@JsonProperty ("id")
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}