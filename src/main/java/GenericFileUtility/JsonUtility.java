package GenericFileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public String getDataFromJsonFile() throws Exception {
		FileReader fr = new FileReader("./CommonData/AppCommonData.json");
		
		JSONParser parser = new JSONParser();
		Object obj	=parser.parse(fr);
		          
		//convert JAVAObj to JSON Object
		
			
		JSONObject	map=(JSONObject)obj;
	      String value =map.get("url").toString();
	      return value; 
	}
}
