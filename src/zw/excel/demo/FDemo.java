package zw.excel.demo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import zw.excel.operation.Excel;
import zw.excel.ov.CityData;
import zw.excel.ov.ColumnData;

public class FDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel excel = new Excel();
		ColumnData columnData = new ColumnData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			columnData.setCityData(new CityData("万州", 111));
			columnData.setDate(sdf.parse("2018-10-8"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			excel.write("C:\\Users\\13479\\Desktop\\市场部12月订单统计.xlsx");
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
