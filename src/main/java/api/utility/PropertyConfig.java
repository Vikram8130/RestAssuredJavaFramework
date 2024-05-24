package api.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import api.tests.TestBaseClass;

public class PropertyConfig {

	/** The properties. */
	public final Properties properties = new Properties();

	/** The buffer reader. */
	BufferedReader bufferReader = null;

	/** The file. */
	String file = "";

	public PropertyConfig(String propertyFileName, String propertFilePath) {
		file = (TestBaseClass.cDir + propertFilePath + propertyFileName + ".properties");
		load(file);

	}

	public void load(String fileName) {
		try {
			bufferReader = new BufferedReader(new FileReader(fileName));
			properties.load(bufferReader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get property value from property file
	public String getPropertyValue(String propertyPath)
	{
		String testPropValue=null;
		
		try {
			testPropValue=properties.getProperty(propertyPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testPropValue;
		
	}

}
