package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class Attributes {
	public String StName;

	public String StPreDir;

	public String StPreType;

	public String StType;

	public String Region;

	public String StDir;

	public String City;

	public String Postal;

	public String getStName() {
		return StName;
	}

	public void setStName(String StName) {
		this.StName = StName;
	}

	public String getStPreDir() {
		return StPreDir;
	}

	public void setStPreDir(String StPreDir) {
		this.StPreDir = StPreDir;
	}

	public String getStPreType() {
		return StPreType;
	}

	public void setStPreType(String StPreType) {
		this.StPreType = StPreType;
	}

	public String getStType() {
		return StType;
	}

	public void setStType(String StType) {
		this.StType = StType;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String Region) {
		this.Region = Region;
	}

	public String getStDir() {
		return StDir;
	}

	public void setStDir(String StDir) {
		this.StDir = StDir;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getPostal() {
		return Postal;
	}

	public void setPostal(String Postal) {
		this.Postal = Postal;
	}

	@Override
	public String toString() {
		return "ClassPojo [StName = " + StName + ", StPreDir = " + StPreDir + ", StPreType = " + StPreType + ", StType = " + StType + ", Region = " + Region + ", StDir = " + StDir + ", City = " + City + ", Postal = " + Postal + "]";
	}
}