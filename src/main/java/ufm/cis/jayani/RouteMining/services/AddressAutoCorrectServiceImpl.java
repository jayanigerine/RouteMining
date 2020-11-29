package ufm.cis.jayani.RouteMining.services;

import lombok.extern.java.Log;
import ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response.AddressValidateResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class AddressAutoCorrectServiceImpl implements AddressAutoCorrectService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${address.autocorrect.usps.api}")
	private String autoCorrectUSPSAPI;

	@Value("${address.autocorrect.usps.api.userid}")
	private String autoCorrectUSPSUserID;

	@Value("${address.autocorrect.usps.api.password}")
	private String autoCorrectUSPSPassword;

	@Override
	public ResponseEntity<AddressValidateResponse> autoCorrectAddress(
			String address1, String address2, String city, String state, String zip5) {
		String resourceUrl
				= autoCorrectUSPSAPI + "<AddressValidateRequest USERID=\"" + autoCorrectUSPSUserID + "\" "
				+ "PASSWORD=\"" + autoCorrectUSPSPassword + "\">"
				+ "<Revision>1</Revision>"
				+ "<Address ID=\"0\"><Address1>" + address1 + "</Address1>"
				+ "<Address2>" + address2 + "</Address2>"
				+ "<City>" + city + "</City>"
				+ "<State>" + state + "</State>"
				+ "<Zip5>" + zip5 + "</Zip5>"
				+ "<Zip4/>"
				+ "</Address></AddressValidateRequest>";
		ResponseEntity<AddressValidateResponse> response
				= restTemplate.getForEntity(resourceUrl, AddressValidateResponse.class);

		return response;
	}
}
