package br.com.jau.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.jau.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		converters.add(new YamlJackson2HttpMessageConverter()); 
	}

	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// VIa query PARAM : localhost:8080/api/person/v1?mediaType=xml
		
		configurer.favorParameter(true)
		.parameterName("mediaType")
		.ignoreAcceptHeader(true).useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		    .mediaType("json", MediaType.APPLICATION_JSON)
		    .mediaType("xml", MediaType.APPLICATION_XML);
		
		// VIa header PARAM : localhost:8080/api/person/v1
		
				configurer.favorParameter(false)
				.ignoreAcceptHeader(false)
				.useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
				    .mediaType("json", MediaType.APPLICATION_JSON)
				    .mediaType("xml", MediaType.APPLICATION_XML)
				    .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
		
	}

}
