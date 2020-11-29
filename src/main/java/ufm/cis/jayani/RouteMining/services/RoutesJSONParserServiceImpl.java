package ufm.cis.jayani.RouteMining.services;


import java.util.Iterator;

import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Service;

@Service
@Log
public class RoutesJSONParserServiceImpl implements RoutesJSONParserService {
	// public static void main(String[] args) {
	public String getTotalCount(String input, String crid) {
		JSONParser parser = new JSONParser();
		String totCntStr = "";
		try {
			Object obj = parser.parse(input);
			JSONObject responseObject = (JSONObject) obj;
			JSONArray results = (JSONArray) responseObject.get("results");
			JSONObject result = (JSONObject) results.get(0);
			JSONObject value = (JSONObject) result.get("value");
			JSONArray features = (JSONArray) value.get("features");
			Iterator featureIterator = features.iterator();

			while (featureIterator.hasNext()) {
				JSONObject feature = (JSONObject) featureIterator.next();
				JSONObject attributes = (JSONObject) feature.get("attributes");

				String cridID = (String) attributes.get("CRID_ID");
				if (cridID.equalsIgnoreCase(crid)) {
					Long totCNT = (Long) attributes.get("TOT_CNT");
					totCntStr = totCNT.toString();
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return totCntStr;
	}
}
