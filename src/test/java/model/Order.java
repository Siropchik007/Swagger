package model;
import utils.DesData;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Order{
	private int petId;
	private int quantity;
	private int id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
	@JsonDeserialize(using = DesData.class)
	private ZonedDateTime shipDate;
	private boolean complete;
	private String status;


	public void setPetId(int petId){
		this.petId = petId;
	}

	public int getPetId(){
		return petId;
	}

	public Order petId (int id){
		this.id = id;
		return this;
	}



	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public Order quantity(int quantity){
		this.quantity = quantity;
		return this;
	}



	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
	public Order id(int id){
		this.id = id;
		return this;
	}


	public void setShipDate(ZonedDateTime shipDate){
		this.shipDate = shipDate;
	}

	public ZonedDateTime getShipDate(){
		return shipDate;
	}
	public Order shipDate(ZonedDateTime shipDate){
		this.shipDate = shipDate;
		return this;
	}



	public void setComplete(boolean complete){
		this.complete = complete;
	}

	public boolean isComplete(){
		return complete;
	}
	public Order complete(boolean complete){
		this.complete = complete;
		return this;
	}



	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public Order status(String status){
		this.status = status;
		return this;
	}
}
