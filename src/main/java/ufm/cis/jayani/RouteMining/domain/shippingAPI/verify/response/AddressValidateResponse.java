package ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response;

public class AddressValidateResponse {
	public Address Address;

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address Address) {
		this.Address = Address;
	}

	@Override
	public String toString() {
		return "[Address = " + Address + "]";
	}
}