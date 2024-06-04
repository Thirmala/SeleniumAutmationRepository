package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		step 1 : get the Excel path location & java Object of the physical ExcelFile
		FileInputStream fis = new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\OrgTestScript.xlsx");
		
//		step 2 : open Workbook in read mode
		Workbook wb =WorkbookFactory.create(fis);
		
		//get the control of the "org" sheet
		   Sheet sh = wb.getSheet("org");
		   
		   //get the control from first Row
	    Row row=  sh.getRow(1);
		    //row 1 means index 1
		    
        //get the control of 2nd Cell & read String Data
	   Cell cell =row.getCell(2);
		   String data=cell.getStringCellValue();  
		    
		System.out.println(data);
		
//	OR	   String data =WorkbookFactory.create(fis).getSheet("org").getRow(1).getCell(2).getStringCellValue();

		
		//close work book
		wb.close();
	}

}
