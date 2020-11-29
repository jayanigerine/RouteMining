package ufm.cis.jayani.RouteMining.domain.gps.routes.request;

import ufm.cis.jayani.RouteMining.domain.address.candidates.response.SpatialReference;

public class Geometry {
	public Double x;

	public Double y;

	public SpatialReference spatialReference;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	@Override
	public String toString() {
		return "ClassPojo [x = " + x + ", y = " + y + ", spatialReference = " + spatialReference + "]";
	}
}
