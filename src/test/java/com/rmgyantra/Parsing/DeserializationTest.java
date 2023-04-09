package com.rmgyantra.Parsing;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.rmgyantra.POJOLibrary.POJOClass;

public class DeserializationTest {
	
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		//make comment on pojoclass constructor before
		ObjectMapper om= new ObjectMapper();
		POJOClass pj = om.readValue(new File("./DATA.json"), POJOClass.class);
		System.out.println(pj.getProjectName());
		
	}

}
