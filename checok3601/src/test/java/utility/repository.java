package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class repository {
public Properties repo() throws IOException {
	Properties prop = new Properties();
	ClassLoader loader = Thread.currentThread().getContextClassLoader();           
	InputStream stream = loader.getResourceAsStream("/data.properties");
	prop.load(stream);
	return prop;
}
}
