package ufm.cis.jayani.RouteMining.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ufm.cis.jayani.RouteMining.domain.address.candidates.response.SpatialReference;
import ufm.cis.jayani.RouteMining.domain.gps.routes.request.SelectingFeatures;

public class AddressCandidatesJSONParser {
	/*
	Not used currently as we are converting json object to POJO
	 */
	public SelectingFeatures getCordinates(String json) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(json);
			JSONObject responseObject = (JSONObject) obj;
			SpatialReference spatialReference = (SpatialReference) responseObject.get("spatialReference");
			JSONArray candidates = (JSONArray) responseObject.get("candidates");
			JSONObject candidate = (JSONObject) candidates.get(0);
			JSONObject location = (JSONObject) candidate.get("location");
			Double xCordinate = (Double) location.get("x");
			Double yCordinate = (Double) location.get("y");
			System.out.println("xCordinate: " + xCordinate + " yCordinate: " + yCordinate);
			SelectingFeatures selectingFeatures = new SelectingFeatures();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
