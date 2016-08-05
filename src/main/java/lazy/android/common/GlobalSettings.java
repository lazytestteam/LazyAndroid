package lazy.android.common;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月27日 上午11:14:22
 * @version 1.0
 * @remark
 */
public class GlobalSettings {

	public static Properties prop = getProperties();

	public static String appPath = prop.getProperty("appPath", "apps");

	public static String timeout = prop.getProperty("timeout", "5000");

	public static String stepInterval = prop.getProperty("stepInterval", "500");

	public static String baseStorageUrl = prop.getProperty("baseStorageUrl",
			System.getProperty("user.dir"));

	public static String getProperty(String property) {
		return prop.getProperty(property);
	}

	public static Properties getProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("prop.properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
