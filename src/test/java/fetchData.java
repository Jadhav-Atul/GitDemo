import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fetchData {
	
	
	public ArrayList<String> fetchExcelData(String sheetName) throws IOException {
		
		ArrayList<String> myData = new ArrayList<String>();
		
		FileInputStream myFile = new FileInputStream("C:\\Users\\Atul\\Documents\\MyTempDoc\\TestAutomationJava\\myTest1.xlsx");
		XSSFWorkbook wB = new XSSFWorkbook(myFile);	//Excel object created
		
		int sheets = wB.getNumberOfSheets();	//Number of sheets in the excel
		
		for(int i=0;i<sheets;i++)
		{
			if(wB.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName))
			{
				XSSFSheet mySheet = wB.getSheetAt(i);	//Sheet is located
				
				Iterator<Row> Rows = mySheet.rowIterator();
				while(Rows.hasNext())
				{
					Row currentRow = Rows.next();
					if(currentRow.getCell(0).getStringCellValue().equalsIgnoreCase("login"))
					{
						Iterator<Cell> Cells = currentRow.cellIterator();
						
						while(Cells.hasNext())
						{
							Cell currentCell = Cells.next();
							if(currentCell.getCellType() == CellType.STRING)
							{
								myData.add(currentCell.getStringCellValue());
							}
							else
							{
								myData.add(NumberToTextConverter.toText(currentCell.getNumericCellValue()));
							}
							
						}
					}

				}
				
				
			}
			
		}
		
		
		
		return myData;
		 }
}
