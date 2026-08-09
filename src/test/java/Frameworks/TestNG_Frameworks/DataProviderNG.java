package Frameworks.TestNG_Frameworks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviderNG {

	
		// TODO Auto-generated method stub
		
		public static List<HashMap<String,String>>  jsonMapper(String jsonPath) throws IOException{
			//Convert the jsonFile into String
			String jsonToString = FileUtils.readFileToString(new File(jsonPath),StandardCharsets.UTF_8);
			//Convert String into list of Hashmap
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data =mapper.readValue(jsonToString, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
		}

	//check check check

}
