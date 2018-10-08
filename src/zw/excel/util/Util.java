package zw.excel.util;

import java.io.File;

public class Util {
	public static String getFileType(String path) {
		if(path.equals(""))
			return null;
		String fileType =  path.substring(path.lastIndexOf(".")+1, path.length());
		return fileType;
	}
}
