package zw.excel.ov;

import java.util.Date;

public class ColumnData {
	private Date date;
	private CityData cityData;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CityData getCityData() {
		return cityData;
	}
	public void setCityData(CityData cityData) {
		this.cityData = cityData;
	}
	
	public ColumnData() {};
	public ColumnData(Date date, CityData cityData) {
		this.date = date;
		this.cityData = cityData;
	}
}
