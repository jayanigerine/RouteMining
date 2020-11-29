package ufm.cis.jayani.RouteMining.services;

import ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response.AddressValidateResponse;

import org.springframework.http.ResponseEntity;

public interface AddressAutoCorrectService {
	ResponseEntity<AddressValidateResponse> autoCorrectAddress(String address1, String address2, String city, String state, String zip5);
}
