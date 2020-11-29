package ufm.cis.jayani.RouteMining.domain.gps.routes.request;

public class Features {
	public Geometry geometry;

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "ClassPojo [geometry = " + geometry + "]";
	}
}
