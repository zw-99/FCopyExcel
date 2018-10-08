package zw.excel.ov;

public class CityData {
	private String city;
	private int customerCount;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}
	
	public CityData() {};
	public CityData(String city, int customerCount) {
		this.city = city;
		this.customerCount = customerCount;
	}
}
