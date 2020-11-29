package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class Extent {
	private String ymin;

	private String xmin;

	private String ymax;

	private String xmax;

	public String getYmin() {
		return ymin;
	}

	public void setYmin(String ymin) {
		this.ymin = ymin;
	}

	public String getXmin() {
		return xmin;
	}

	public void setXmin(String xmin) {
		this.xmin = xmin;
	}

	public String getYmax() {
		return ymax;
	}

	public void setYmax(String ymax) {
		this.ymax = ymax;
	}

	public String getXmax() {
		return xmax;
	}

	public void setXmax(String xmax) {
		this.xmax = xmax;
	}

	@Override
	public String toString() {
		return "ClassPojo [ymin = " + ymin + ", xmin = " + xmin + ", ymax = " + ymax + ", xmax = " + xmax + "]";
	}
}
