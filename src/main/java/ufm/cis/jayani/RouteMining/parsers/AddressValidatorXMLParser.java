package ufm.cis.jayani.RouteMining.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response.AddressValidateResponse;

public class AddressValidatorXMLParser {
	/*
	Not used currently as fasterxml provides XML to POJO conversion
	 */
	public static void main(String[] args) {
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<AddressValidateResponse><Address ID=\"0\"><Address2>42074 CARRIAGE COVE CIR</Address2><City>CANTON</City><State>MI</State><Zip5>48187</Zip5><Zip4>3559</Zip4><DeliveryPoint>74</DeliveryPoint><CarrierRoute>C051</CarrierRoute><DPVConfirmation>Y</DPVConfirmation><DPVCMRA>N</DPVCMRA><DPVFootnotes>AABB</DPVFootnotes><Business>N</Business><CentralDeliveryPoint>Y</CentralDeliveryPoint><Vacant>N</Vacant></Address></AddressValidateResponse>";
		ObjectMapper xmlMapper = new XmlMapper();
		try {
			AddressValidateResponse addressValidateResponse = xmlMapper
					.readValue(xmlString, AddressValidateResponse.class);
			System.out.println(addressValidateResponse.toString());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
