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
	
	public Integer getBackoffKafkaConsumerInitialInterval() {
		return Integer.parseInt(env.getProperty("retry.backoff.kafka.consumer.initialInterval"));
	}
	
	public Integer getBackoffKafkaConsumerMultiplier() {
		return Integer.parseInt(env.getProperty("retry.backoff.kafka.consumer.multiplier"));
	}
	
	public Integer getBackoffKafkaConsumerMaxInterval() {
		return Integer.parseInt(env.getProperty("retry.backoff.kafka.consumer.maxInterval"));
	}
	
	public String getDefaultDatabaseSchema() {
		return env.getProperty("application.db.schema.default");
	}
	
	public String getEnvDatabaseSchema() {
		return env.getProperty("application.db.schema");
	}
	
	public String getJooqSqlDialect() {
		return env.getProperty("spring.jooq.sql-dialect");
	}
	
	public Integer getHttpConnectionTimeout() {
		return Integer.parseInt(env.getProperty("http.connection.timeout"));
	}
	
	public Integer getHttpConnectionSoTimeout() {
		return Integer.parseInt(env.getProperty("http.connection.so.timeout"));
	}
}
