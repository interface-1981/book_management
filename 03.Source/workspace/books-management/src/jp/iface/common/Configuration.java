package jp.iface.common;

import java.io.InputStreamReader;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	private static Configuration configuration;

	private Configuration() {

	    try {
	    	this.properties = new Properties();
	    	InputStreamReader inputStream = new InputStreamReader(this.getClass().getResourceAsStream("/configuration.properties"),"UTF-8");
	        properties.load(inputStream);
	        inputStream.close();

	    } catch (Exception ex) {
	        System.out.println(ex.getMessage());

	    }
	}

	// 値の取得
	public static String getValue(String key) {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration.properties.getProperty(key);
	}

	public static int getValueInt(String key) {
		return Integer.parseInt(getValue(key));
	}

	public static void refresh() {
		configuration = null;
	}

}
