import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();	//Storing the cells's of a row. 
		
		FileInputStream file = new FileInputStream("C://Users//Atul//Documents//MyTempDoc//TestAutomationJava//demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);	//Accessed the excel
		
		int sheets = workbook.getNumberOfSheets();	//Number of sheets
		
		for(int i=0; i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet =workbook.getSheetAt(i);	//Accessed the sheet
				Iterator<Row> rows = sheet.rowIterator();
				Row firstRow = rows.next();					//FirstRow accessed
				Iterator<Cell> cells = firstRow.cellIterator();
				int k=0,column=0;
				while(cells.hasNext())
				{
					Cell value =cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column=k;
					}					
					k++;
				}
				System.out.println(column);
				
				//Scanning the column
				while(rows.hasNext())
				{
					Row r =rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						Iterator<Cell> cItr = r.cellIterator();
						while (cItr.hasNext()) 
						{
							Cell value = cItr.next();
							if(value.getCellType()==CellType.STRING)
							{	
								a.add(value.getStringCellValue());
							}
							else 
							{
								a.add(NumberToTextConverter.toText(value.getNumericCellValue()));								
							}							
						}
					}					
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}

}
