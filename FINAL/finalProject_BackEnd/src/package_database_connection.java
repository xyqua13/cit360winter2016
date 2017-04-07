import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="package_database")
public class package_database_connection {
	@Id
	private int packageId;
	private int userId;
	private String carrier;
	private Date arrival_date;
	private String package_details;
	
	
	
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Date getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}
	public String getPackage_details() {
		return package_details;
	}
	public void setPackage_details(String package_details) {
		this.package_details = package_details;
	}
}
