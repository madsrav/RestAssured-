package com.rmgyantra.Parsing;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.rmgyantra.POJOLibrary.POJOClass;

public class SerializationTest {
	
	@Test
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		POJOClass pj = new POJOClass("sravankumar", "sdet11", "created", 10);
		File f= new File("./JSON1File.json");
		ObjectMapper om= new ObjectMapper();
		om.writeValue(f, pj);
	}

}
