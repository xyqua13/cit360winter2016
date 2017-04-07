package finalProject;

import java.io.Serializable;
import java.util.Date;

public class singlePackage implements Serializable {
	private int id;
	private String carrier;
	private Date arrivalDateTime = new Date();
	private String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}

