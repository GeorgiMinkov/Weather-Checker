package bg.unisofia.fmi.soa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import bg.unisofia.fmi.soa.service.LocationClient;

@Configuration
@Deprecated
public class LocationConfig {
	
	@Bean
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("bg.unisofia.fmi.soa.wsdl");
	    return marshaller;
	  }

//	  @Bean
	  public LocationClient countryClient(Jaxb2Marshaller marshaller) {
	    LocationClient client = new LocationClient();
//	    client.setDefaultUri("http://localhost:9090/ws");
//	    client.setMarshaller(marshaller);
//	    client.setUnmarshaller(marshaller);
	    return client;
	  }
}