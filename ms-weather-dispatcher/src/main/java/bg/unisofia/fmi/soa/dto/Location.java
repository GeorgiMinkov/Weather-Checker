package bg.unisofia.fmi.soa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@JsonDeserialize
//@JsonSerialize
@JsonIgnoreProperties
public class Location {

	@JsonProperty(value = "city")
	private String city;
	
	@JsonProperty(value = "country")
	private String country;
}
