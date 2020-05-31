package bg.unisofia.fmi.soa.service;

import javax.xml.soap.MessageFactory;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import bg.unisofia.fmi.soa.wsdl.GetLocationWeatherRequest;
import bg.unisofia.fmi.soa.wsdl.GetLocationWeatherResponse;

public class LocationClient {

	public GetLocationWeatherResponse getLocationWeather(GetLocationWeatherRequest request) {
		SaajSoapMessageFactory messageFactory;
		try {
			messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());

			messageFactory.afterPropertiesSet();

			WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

			marshaller.setContextPath("bg.unisofia.fmi.soa.wsdl");
			marshaller.afterPropertiesSet();

			webServiceTemplate.setMarshaller(marshaller);
			webServiceTemplate.setUnmarshaller(marshaller);
			webServiceTemplate.afterPropertiesSet();

			GetLocationWeatherResponse response = (GetLocationWeatherResponse) webServiceTemplate.marshalSendAndReceive(
					"http://localhost:9090/ws/location", request,
					new SoapActionCallback("http://fmi.uni-sofia.bg/weather/web-service/getLocationWeatherRequest"));
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
