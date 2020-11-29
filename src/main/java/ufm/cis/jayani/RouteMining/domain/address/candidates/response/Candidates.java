package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class Candidates {
	public Extent extent;

	public String score;

	public String address;

	public Location location;

	public Attributes attributes;

	public Extent getExtent() {
		return extent;
	}

	public void setExtent(Extent extent) {
		this.extent = extent;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "ClassPojo [extent = " + extent + ", score = " + score + ", address = " + address + ", location = " + location + ", attributes = " + attributes + "]";
	}
}