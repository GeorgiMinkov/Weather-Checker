package bg.unisofia.fmi.soa.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bg.uni_sofia.fmi.weather.web_service.GetLocationWeatherRequest;
import bg.uni_sofia.fmi.weather.web_service.GetLocationWeatherResponse;
import bg.uni_sofia.fmi.weather.web_service.LocationData;
import bg.unisofia.fmi.soa.config.AppConfig;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@RestController
@Slf4j
public class WeatherInfoManager {
	private static final String NAMESPACE_URI = "http://fmi.uni-sofia.bg/weather/web-service";

	private final AppConfig appConfig;
	private final RestTemplate restTemplate;

	@Autowired
	public WeatherInfoManager(AppConfig appConfig, RestTemplate restTemplate) {
		super();
		this.appConfig = appConfig;
		this.restTemplate = restTemplate;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationWeatherRequest")
	@ResponsePayload
	public GetLocationWeatherResponse getLocationWeather(@RequestPayload GetLocationWeatherRequest request) {
		log.info(">>>>>>>>>> getLocationWeather " + request);
		// send data to open weather;
		GetLocationWeatherResponse weatherResponse = new GetLocationWeatherResponse();
		
		if (request != null && request.getLocation() != null && !StringUtils.isEmpty(request.getLocation().getCity())
				&& !StringUtils.isEmpty(request.getLocation().getCountry())) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			HttpEntity<Object> entity = new HttpEntity<>(null, headers);

			String url = String.format(appConfig.getOpenWeatherApiUrl(), request.getLocation().getCity(),
					request.getLocation().getCountry(), appConfig.getOpenWeatherApiKey());

			System.out.println(url);
			String response = restTemplate
					.exchange(url, HttpMethod.GET, entity, String.class).getBody();

			JSONObject json = new JSONObject(response);
			JSONObject weather = new JSONObject(json.getJSONArray("weather").get(0).toString());

			LocationData locationData = new LocationData();
			locationData.setCity(json.get("name").toString());
			locationData.setCountry(json.getJSONObject("sys").get("country").toString());
			locationData.setTemperature(new BigDecimal(json.getJSONObject("main").get("temp").toString()));
			locationData.setHumidity(json.getJSONObject("main").get("humidity").toString());
			locationData.setDescription(weather.get("description").toString());

			weatherResponse.setLocationData(locationData);
		} 

		// return data

		return weatherResponse;
	}
}
