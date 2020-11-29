package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class Location {
	public Double x;

	public Double y;

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

	@Override
	public String toString() {
		return "ClassPojo [x = " + x + ", y = " + y + "]";
	}
}
