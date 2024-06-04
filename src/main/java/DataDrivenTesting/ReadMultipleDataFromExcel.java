package DataDrivenTesting;

import static org.testng.Assert.assertThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
FileInputStream fis = new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\OrgTestScript.xlsx");
		
//		step 2 : open Workbook in read mode
		Workbook wb =WorkbookFactory.create(fis);
		
		try {
		Sheet sh=wb.getSheet("org");
		System.out.println(sh.getLastRowNum());
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			Row row = sh.getRow(i);
			if(i==4) {

				
			for(int j=0; j<=row.getLastCellNum(); j++) {
				
           String value = row.getCell(j).toString()+" ";	
           System.out.print(value);
           
		      }
		    }
		  }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("===Done====");
	}
}

