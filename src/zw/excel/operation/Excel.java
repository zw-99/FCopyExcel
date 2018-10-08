package zw.excel.operation;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import zw.excel.common.Common;
import zw.excel.ov.ColumnData;
import zw.excel.util.Util;


public class Excel {
	List<ColumnData> columnDatas = new ArrayList<ColumnData>();
	public void read(String path) throws IOException{
		//�ж�·���Ƿ���Ч
		if(path == null || path.equals("")) {
			return;
		} else {
			String fileType = Util.getFileType(path);
			if(fileType != null) {
				if(fileType == "xls")
					readXls(path);
				else if (fileType == "xlsx") 
					readXlsx(path);	
			}
		}
	}

	/**
	 * ��Ŀ������д������
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public boolean write(String path) throws IOException, InvalidFormatException {
		if(path == null || path.equals("")) {
			return false;
		}
		String fileType = Util.getFileType(path);
		if(fileType != null) {
			System.out.println(fileType);
			if(fileType.equals("xls")) {
				return writeXls(path);
			} else if (fileType.equals("xlsx")) { 
				return writeData2Xlsx(path);
			}
		}
		System.out.println("write");
		return false;
	}
	
	/**
	 * office2010�����ϰ汾��д������
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	private boolean writeData2Xlsx(String path) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
//		Workbook writeWorkbook = new XSSFWorkbook();
//		Sheet writeSheet = writeWorkbook.createSheet(Common.QU_KE_SORT_SHEET);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook readWorkbook = new XSSFWorkbook(is);
		XSSFSheet readSheet = readWorkbook.getSheet(Common.QU_KE_SORT_SHEET);
		for (ColumnData columnData : columnDatas) {
			//Ŀ�굥Ԫ������е�Ԫ��Ĳ�ֵ
			int cellsAddValue = Integer.parseInt(new SimpleDateFormat("dd").format(columnData.getDate()));
			//�ڱ�������Ѱ���б�����еĳ���
			for(int i = Common.TARGET_FILE_CITY_ROW_INDEX-1; i < readSheet.getLastRowNum(); i++) {
				//��ȡ������
				String cityCell = readSheet.getRow(Common.TARGET_FILE_CITY_COLUMN_INDEX-1).getCell(i).getStringCellValue();
				//�ҵ����б����ĳɽ���д��Ŀ�����С�
				if(cityCell == columnData.getCityData().getCity()) {
					XSSFCell writeCell = readSheet.createRow(i).createCell(cellsAddValue + Common.TARGET_FILE_CITY_COLUMN_INDEX + 1);
					writeCell.setCellValue(columnData.getCityData().getCustomerCount());
					break;
				}
			}
		}
		readWorkbook.close();
		//is.close();
		//���������д�뵽Ӳ��
		FileOutputStream writeFile = new FileOutputStream(path);
//		writeWorkbook.write(writeFile);
//		writeWorkbook.close();
		writeFile.close();
		System.out.println("writeData2Xlsx-----end");
		return true;
		//Workbook workbook = new XSSFWorkbook();
		//Sheet sheet = workbook.createSheet();
	}

	private boolean writeXls(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	private void readXlsx(String path) throws IOException {
		// TODO Auto-generated method stub
//		InputStream readFile = new FileInputStream(path);
//		Workbook workbook = new  XSSFWorkbook(readFile);
//		Sheet sheet = workbook.getSheet();
//		if(sheet == null)
//		  return;
		//��ȡ�������
	}

	private void readXls(String path)throws IOException {
		// TODO Auto-generated method stub
		
	}
}
