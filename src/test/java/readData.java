import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {
	
	public ArrayList<String> getData01() throws IOException
	//public static void main(String[] args) throws IOException
	{
		//An array for storing data from the excel
		ArrayList<String> liginData = new ArrayList<String>();
		
		FileInputStream myFile = new FileInputStream("C://Users//Atul//Documents//MyTempDoc//TestAutomationJava//mytest.xlsx");	//Excel sheet location
		XSSFWorkbook wbook = new XSSFWorkbook(myFile);	//An object created for the excel sheet
		
		//get the required sheet
		int totalSheets = wbook.getNumberOfSheets();
		Iterator<Sheet> sheet = wbook.sheetIterator();
		Sheet firstSheet =sheet.next();
		Sheet secondSheet = sheet.next();
		Iterator<Row> rows =secondSheet.rowIterator();
		while(rows.hasNext()) 
		{
			Row currentRow =rows.next();
			if(currentRow.getCell(0).getStringCellValue().equalsIgnoreCase("Login"))
			{
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				
				while(cellIterator.hasNext())
				{
					Cell temp1 = cellIterator.next();
					liginData.add(temp1.getStringCellValue());
					System.out.println(temp1.getStringCellValue());  
					
				}
			}
		}
		//System.out.println("Data from ArrayList");
		//System.out.println( liginData.get(0) );
		//System.out.println( liginData.get(1) );
		//System.out.println( liginData.get(2) );
		//System.out.println( liginData.get(3) );
		return liginData;
	}
	

}
