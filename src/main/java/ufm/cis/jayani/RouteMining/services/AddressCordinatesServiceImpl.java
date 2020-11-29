package ufm.cis.jayani.RouteMining.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import ufm.cis.jayani.RouteMining.domain.address.candidates.response.AddressCandidatesResponse;
import ufm.cis.jayani.RouteMining.domain.gps.routes.request.Features;
import ufm.cis.jayani.RouteMining.domain.gps.routes.request.Geometry;
import ufm.cis.jayani.RouteMining.domain.gps.routes.request.SelectingFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class AddressCordinatesServiceImpl implements AddressCordinatesService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${address.cordinates.usps.api}")
	private String addressCordinatesUSPSApi;

	@Value("${address.cordinates.usps.api.trailingattrs}")
	private String addressCordinatesUSPSApiTrailingAttrs;

	@Override
	public String getCordinates(String address) {
		String resourceUrl
				= addressCordinatesUSPSApi + address + "&SingleLine=" + address + addressCordinatesUSPSApiTrailingAttrs;

		ResponseEntity<AddressCandidatesResponse> response
				= restTemplate.getForEntity(resourceUrl, AddressCandidatesResponse.class);

		SelectingFeatures selectingFeatures = new SelectingFeatures();
		selectingFeatures.setGeometryType("esriGeometryPoint");
		Features[] feature = new Features[1];
		Geometry geometry = new Geometry();
		geometry.setX(response.getBody().getCandidates()[0].getLocation().getX());
		geometry.setY(response.getBody().getCandidates()[0].getLocation().getY());
		geometry.setSpatialReference(response.getBody().getSpatialReference());
		feature[0] = new Features();
		feature[0].setGeometry(geometry);
		selectingFeatures.setSr(response.getBody().getSpatialReference());
		selectingFeatures.setFeatures(feature);

		ObjectMapper mapper = new ObjectMapper();

		String selectingFeature = "";

		try {
			selectingFeature = mapper.writeValueAsString(selectingFeatures);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return selectingFeature;
	}
}
