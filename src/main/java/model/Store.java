package model;

public class Store{
	private int petId;
	private int quantity;
	private int id;
	private String shipDate;
	private boolean complete;
	private String status;


	public void setPetId(int petId){
		this.petId = petId;
	}

	public int getPetId(){
		return petId;
	}

	public Store petId (int id){
		this.id = id;
		return this;
	}



	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public Store quantity(int quantity){
		this.quantity = quantity;
		return this;
	}



	public void setStoreId(int id){
		this.id = id;
	}

	public int getStoreId(){
		return id;
	}
	public Store storeId(int id){
		this.id = id;
		return this;
	}


	public void setShipDate(String shipDate){
		this.shipDate = shipDate;
	}

	public String getShipDate(){
		return shipDate;
	}
	public Store shipDate(String shipDate){
		this.shipDate = shipDate;
		return this;
	}



	public void setComplete(boolean complete){
		this.complete = complete;
	}

	public boolean isComplete(){
		return complete;
	}
	public Store complete(boolean complete){
		this.complete = complete;
		return this;
	}



	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public Store status(String status){
		this.status = status;
		return this;
	}
}
