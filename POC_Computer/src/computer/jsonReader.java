package computer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class jsonReader {

	// Method to read json file and store data into an 2D Array Object
	public static Object [][] getJsondata(String JSON_path, String JSON_data, int JSON_attributes) throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader(JSON_path));
		JSONObject jo = (JSONObject) obj;
		JSONArray js = (JSONArray) jo.get(JSON_data);
		Object [][] arr = new String [js.size()][JSON_attributes];
		for (int i = 0; i < js.size(); i++){
			JSONObject obj1 = (JSONObject) js.get(i);
			arr[i][0] = String.valueOf(obj1.get("TestCaseName"));
			arr[i][1] = String.valueOf(obj1.get("TestScenarioMethod"));
			arr[i][2] = String.valueOf(obj1.get("SearchComputerName"));
			arr[i][3] = String.valueOf(obj1.get("ComputerSearchAction"));
			arr[i][4] = String.valueOf(obj1.get("ComputerName"));
			arr[i][5] = String.valueOf(obj1.get("IntroducedDate"));
			arr[i][6] = String.valueOf(obj1.get("DiscontinuedDate"));
			arr[i][7] = String.valueOf(obj1.get("CompanyName"));
			arr[i][8] = String.valueOf(obj1.get("ComputerEditPageAction"));
			arr[i][9] = String.valueOf(obj1.get("ValidationPoint"));
			arr[i][10] = String.valueOf(obj1.get("Validation"));
			arr[i][11] = String.valueOf(obj1.get("Element"));
			arr[i][12] = String.valueOf(obj1.get("DefaultValue"));
		}
		return arr;
	}
	
}
