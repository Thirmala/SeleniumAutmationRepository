package GenericFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
 public String getDataFromPropertiesFile(String key) throws Exception {
	 
		FileInputStream fis = new FileInputStream("./CommonData/commondata.properties");
		
           Properties pObj = new Properties();
        pObj.load(fis);
       String value = pObj.getProperty(key);
	return value;
	 
 }
}
