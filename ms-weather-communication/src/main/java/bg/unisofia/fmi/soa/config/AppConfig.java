package bg.unisofia.fmi.soa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {
	// For property coverage
	private final Environment env;
	
	@Autowired
	public AppConfig(Environment env) {
		this.env = env;
	}

	public String getOpenWeatherApiUrl() {
		return env.getProperty("openweather.api.url");
	}
	
	public String getOpenWeatherApiKey() {
		return env.getProperty("openweather.api.key");
	}
	
	
}
