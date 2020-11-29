package ufm.cis.jayani.RouteMining.controllers;

import ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response.AddressValidateResponse;
import ufm.cis.jayani.RouteMining.services.AddressAutoCorrectService;
import ufm.cis.jayani.RouteMining.services.AddressCordinatesService;
import ufm.cis.jayani.RouteMining.services.RouteAddressCountService;
import ufm.cis.jayani.RouteMining.services.RoutesJSONParserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class APIRequestController {

	@Autowired
	AddressAutoCorrectService addressAutoCorrectService;
	@Autowired
	AddressCordinatesService addressCordinatesService;
	@Autowired
	RoutesJSONParserService routesJSONParserService;
	@Autowired
	RouteAddressCountService routeAddressCountService;

	@RequestMapping(value = "/autocorrect")
	public String getAutoCorrect(
			@RequestParam(name = "address1",
						  required = false) String address1,
			@RequestParam(name = "address2",
						  required = true) String address2,
			@RequestParam(name = "city",
						  required = false) String city,
			@RequestParam(name = "state",
						  required = false) String state,
			@RequestParam(name = "zip5",
						  required = false) String zip5,
			RedirectAttributes redirectAttributes) {
		ResponseEntity<AddressValidateResponse> response = addressAutoCorrectService.autoCorrectAddress(address1,
				address2, city, state, zip5);

		StringBuilder sb = new StringBuilder();
//        sb.append(response.getBody().getAddress().getAddress1());
//        sb.append(" ,");
		sb.append(response.getBody().getAddress().getAddress2()).append(", ");
		sb.append(response.getBody().getAddress().getCity()).append(", ");
		sb.append(response.getBody().getAddress().getState()).append(", ");
		sb.append(response.getBody().getAddress().getZip5());


		redirectAttributes.addFlashAttribute("carrierRoute", response.getBody().getAddress().getCarrierRoute());

		redirectAttributes.addFlashAttribute("correctedAddress", sb.toString());

		return "redirect:/";
	}

	@RequestMapping(value = "/address-count")
	public String postTestRequest(@RequestParam(name = "correctedAddressLine") String address,
			@RequestParam(name = "carrierRouteID") String crid, RedirectAttributes redirectAttributes) {
		String cordinates = addressCordinatesService.getCordinates(address);
		String totalAddressCount = routeAddressCountService.getTotalCount(routesJSONParserService, cordinates, crid);

		redirectAttributes.addFlashAttribute("carrierRoute", crid);

		redirectAttributes.addFlashAttribute("correctedAddress", address);

		redirectAttributes.addFlashAttribute("totalAddressCount", totalAddressCount);

		return "redirect:/";
	}

}
