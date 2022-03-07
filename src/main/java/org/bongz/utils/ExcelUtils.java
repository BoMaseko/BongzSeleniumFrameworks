package org.bongz.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bongz.constants.FrameworkConstants;

/**
 * Utility class to read or write to excel. <p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class ExcelUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExcelUtils() {}
	
	
	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * @author Bongz
	 * @param sheetname Excel sheetname to read the value from
	 * @return List where each index holds a map and Each map holds the details about the test
	 * TODO create reusable methods
	 */
	public static List<Map<String, String>> getTestDetails(String sheetname) {
		
		
		/*
		 * This can be utilised by ??Try with resources?? 
		 * will close the connection of inputstream
		 * 
		 * */
		List<Map<String, String>> list = null;
		
		//FileInputStream fs = null;
		/*Try with resource .. can be implemented with class that implements clickable
		 * if used no need for finally block
		 * **/
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())){
			 //fs = new FileInputStream(FrameworkConstants.getExcelpath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			//String sheetname = "RUNMANAGER";
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			
			int lastrownum = sheet.getLastRowNum();
			int lastcolumn = sheet.getRow(0).getLastCellNum();
			
			Map<String, String> map = null;
			list = new ArrayList<Map<String,String>>();
			
			for(int i=1; i<=lastrownum; i++) {//row
				map = new HashMap<String, String>();
				for(int j=0; j<lastcolumn; j++) {//colum
					String key = sheet.getRow(0).getCell(j).getStringCellValue();//column
					String value = sheet.getRow(i).getCell(j).getStringCellValue();//row
					map.put(key, value);
				}
				list.add(map);
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { if(Objects.nonNull(fs)) fs.close(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */
		return list;
		
	}
}
