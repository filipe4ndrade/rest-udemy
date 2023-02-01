package br.com.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * VIA QUERY PARAM //http://localhost:8080/api/person/v1/1?mediaType=json
	 * 
	 * @Override public void
	 * configureContentNegotiation(ContentNegotiationConfigurer configurer) { //
	 * TODO Auto-generated method stub
	 * configurer.favorParameter(true).parameterName("mediaType")
	 * .ignoreAcceptHeader(true).useRegisteredExtensionsOnly(false)
	 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
	 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
	 * 
	 * }
	 */

	// VIA HEADER PARAM http://localhost:8080/api/person/v1/1
	// Em headers accept escolhe o parâmetro para o postman
	
	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);

	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		var allowedOrigin = "http://localhost:8080";
		registry.addMapping("/**")
		           //.allowedMethods("GET","POST","PUT")
		            .allowedMethods("*")
		            .allowedOrigins(allowedOrigin)
		            .allowCredentials(true);
	}

}
