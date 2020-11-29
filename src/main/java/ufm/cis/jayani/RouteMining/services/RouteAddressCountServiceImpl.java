package ufm.cis.jayani.RouteMining.services;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class RouteAddressCountServiceImpl implements RouteAddressCountService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${address.cordinates.route.usps.api}")
	private String addressCordinatesRouteUSPSApi;

	@Value("${address.cordinates.route.usps.api.trailingattrs}")
	private String addressCordinatesRouteUSPSApiTrailingAttrs;

	@Override
	public String getTotalCount(RoutesJSONParserService routesJSONParserServiceString, String selectingFeatures,
			String carrierRoute) {
		String resourceUrl
				= addressCordinatesRouteUSPSApi + selectingFeatures + addressCordinatesRouteUSPSApiTrailingAttrs;

		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

		RoutesJSONParserServiceImpl routesJSONParserServiceImpl = new RoutesJSONParserServiceImpl();
		String totalCount = routesJSONParserServiceImpl.getTotalCount(response.getBody(), carrierRoute);
		if (totalCount.equalsIgnoreCase("")) {
			totalCount = "0";
		}
		return totalCount;
	}
}
