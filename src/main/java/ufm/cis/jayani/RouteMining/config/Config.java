package ufm.cis.jayani.RouteMining.config;

import java.net.URI;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class Config {
	@Bean
	public RestTemplate getRestTemplate() {

		RestTemplate restTemplate = new RestTemplate();

		UriTemplateHandler skipVariablePlaceHolderUriTemplateHandler = new UriTemplateHandler() {
			@Override
			public URI expand(String uriTemplate, Object... uriVariables) {
				return retrieveURI(uriTemplate);
			}

			@Override
			public URI expand(String uriTemplate, Map<String, ?> uriVariables) {
				return retrieveURI(uriTemplate);
			}

			private URI retrieveURI(String uriTemplate) {
				return UriComponentsBuilder.fromUriString(uriTemplate).build().toUri();
			}
		};

		restTemplate.setUriTemplateHandler(skipVariablePlaceHolderUriTemplateHandler);

		return restTemplate;
	}
}
