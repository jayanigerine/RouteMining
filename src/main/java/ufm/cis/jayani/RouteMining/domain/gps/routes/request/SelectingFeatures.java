package ufm.cis.jayani.RouteMining.domain.gps.routes.request;

import ufm.cis.jayani.RouteMining.domain.address.candidates.response.SpatialReference;

public class SelectingFeatures {
	public Features[] features;

	public String geometryType;

	public Sr sr;

	public Features[] getFeatures() {
		return features;
	}

	public void setFeatures(Features[] features) {
		this.features = features;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	public Sr getSr() {
		return sr;
	}

	public void setSr(Sr sr) {
		this.sr = sr;
	}

	public void setSr(SpatialReference sr) {
		this.sr = new Sr();
		this.sr.latestWkid = sr.latestWkid;
		this.sr.wkid = sr.wkid;
	}

	@Override
	public String toString() {
		return "ClassPojo [features = " + features + ", geometryType = " + geometryType + ", sr = " + sr + "]";
	}
}