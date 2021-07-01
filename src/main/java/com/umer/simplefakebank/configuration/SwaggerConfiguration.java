package com.umer.simplefakebank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final String APACHE_LICENSE_2_0 = "http://www.apache.org/licenses/LICENSE-2.0";
	private static final String APACHE_2_0 = "Apache 2.0";
	private static final String URN_TOS = "urn:tos";
	private static final String API_VERSION_NUMBER = "1.0";
	private static final String API_TITLE = "Simple Fake Bank API";
	private static final String APPLICATION_JSON = "application/json";

	private static final String CONTACT_EMAIL = "syedumerahmedcode@gmail.com";
	private static final String CONTACT_URL = "https://www.linkedin.com/in/syed-umer-ahmed-a346a746/";
	private static final String CONTACT_NAME = "Syed Umer Ahmed";

	public static final Contact DEFAULT_CONTACT = new Contact(
			SwaggerConfiguration.CONTACT_NAME,
			SwaggerConfiguration.CONTACT_URL, 
			SwaggerConfiguration.CONTACT_EMAIL);
	
	public static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo(
                    SwaggerConfiguration.API_TITLE,
                    getApiDescription(),
                    SwaggerConfiguration.API_VERSION_NUMBER,
                    SwaggerConfiguration.URN_TOS,
                    DEFAULT_CONTACT,
                    SwaggerConfiguration.APACHE_2_0,
                    SwaggerConfiguration.APACHE_LICENSE_2_0,
                    new ArrayList<>());
	
	 private static String getApiDescription() {
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("This API allows: \n");
	        stringBuilder.append("to create a new bank account for a customer, with an initial deposit amount; \n");
	        stringBuilder.append("Transfer amounts between any two accounts; \n");
	        stringBuilder.append("Retrieve balances for a given account, and; \n");
	        stringBuilder.append("Retrieve transfer history for a given account.");
	        return stringBuilder.toString();
	    }
	 
	 private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
	            new HashSet<>(Arrays.asList(SwaggerConfiguration.APPLICATION_JSON));
	 
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

}
