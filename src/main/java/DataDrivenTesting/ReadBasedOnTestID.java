package DataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadBasedOnTestID {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String expectTestId ="RealMe";
				
FileInputStream fis = new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\OrgTestScript.xlsx");
		
//		step 2 : open Workbook in read mode
		Workbook wb =WorkbookFactory.create(fis);
	Sheet sh	=wb.getSheet("Sheet2");
	
	//for(int i=0; i<=n)
		
		
		
	}

}
