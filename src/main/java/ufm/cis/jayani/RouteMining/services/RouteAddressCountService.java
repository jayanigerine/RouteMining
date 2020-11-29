package ufm.cis.jayani.RouteMining.services;

public interface RouteAddressCountService {
	String getTotalCount(RoutesJSONParserService routesJSONParserService, String selectingFeatures,
			String carrierRoute);
}
