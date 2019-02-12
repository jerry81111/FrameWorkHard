package tw.com.spring.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class XmlUtil {
			
	private static final XmlMapper xmlMapper = new XmlMapper();
	
	static {
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
	}
	
    public static String writeXmlDecl(Object o) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(o);
    }
    
    public static String writePrettyPrinter(Object obj) throws JsonProcessingException {
    	return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

}
