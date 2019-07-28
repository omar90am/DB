
import java.util.Date;
public class CSVFile {
	private int priKey;
	private int id;
	private String address;
	private String district;
	private int city_id;
	private int postal_code;
	private Date last_update;
	public int getPriKey() {
		return priKey;
	}
	public void setPriKey(int priKey) {
		this.priKey = priKey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "CSVFile [priKey=" + priKey + ", id=" + id + ", address=" + address + ", district=" + district
				+ ", city_id=" + city_id + ", postal_code=" + postal_code + ", last_update=" + last_update + "]";
	}
	
}
