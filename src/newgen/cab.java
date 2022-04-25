package newgen;
public class cab {
	private long locationId;
	private String vehicleNo;
	private String vehicleCategory;
	private String availability;
	private long contactNumber;
	
	@Override
	public String toString() {
		return ""+ locationId + ","+ vehicleNo + ","
				+ vehicleCategory + "," + availability + "," + contactNumber +"";
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public cab(long locationId, String vehicleNo, String vehicleCategory, String availability, long contactNumber) {
		
		this.locationId = locationId;
		this.vehicleNo = vehicleNo;
		this.vehicleCategory = vehicleCategory;
		this.availability = availability;
		this.contactNumber = contactNumber;
	}
	

}
