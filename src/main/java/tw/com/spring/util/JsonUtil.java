package tw.com.spring.util;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonUtil {

	private static final ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
	
	/**
	 * json轉物件
	 * @param jsonInString
	 * @param valueType
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException
	 */
	public static <T> T jsonToObject(String jsonInString, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException{
		return (T) mapper.readValue(jsonInString, valueType);
	}
	
	/**
	 * 物件轉json
	 * @param obj 物件
	 * @return
	 */
	public static String objectToJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error("JsonUtil objectToJson error: ", e);
		}
		
		return "";
	}
	
	/**
	 * 字串轉MAP
	 * @param json
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws Exception
	 */
	public static Map<String, Object> stringToMap(String json) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
	}
	
	public static String writePrettyPrinter(Object obj) {
		try{
			return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
		}catch(Exception e){
			LOG.error("JsonUtil writePrettyPrinter error: ", e);
		}
		return "";
	}
	
}
