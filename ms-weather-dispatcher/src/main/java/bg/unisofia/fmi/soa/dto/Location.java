package bg.unisofia.fmi.soa.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Location {

	@JsonProperty(value = "city")
	private String city;
	
	@JsonProperty(value = "country")
	private String country;
	
	@JsonProperty(value = "temperature")
	private BigDecimal temperature;
	
	@JsonProperty(value = "humidity")
	private String humidity;
	
	@JsonProperty(value = "description")
	private String description;
}
