package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class SpatialReference {
	public String latestWkid;

	public String wkid;

	public String getLatestWkid() {
		return latestWkid;
	}

	public void setLatestWkid(String latestWkid) {
		this.latestWkid = latestWkid;
	}

	public String getWkid() {
		return wkid;
	}

	public void setWkid(String wkid) {
		this.wkid = wkid;
	}

	@Override
	public String toString() {
		return "ClassPojo [latestWkid = " + latestWkid + ", wkid = " + wkid + "]";
	}
}