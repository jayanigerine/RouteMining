package ufm.cis.jayani.RouteMining.services;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.java.Log;
import ufm.cis.jayani.RouteMining.domain.csv.Address;
import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;
import ufm.cis.jayani.RouteMining.domain.builder.Report;
import ufm.cis.jayani.RouteMining.domain.builder.Report1;
import ufm.cis.jayani.RouteMining.domain.csv.Report1CSVBean;
import ufm.cis.jayani.RouteMining.domain.builder.Report2;
import ufm.cis.jayani.RouteMining.domain.csv.Report2CSVBean;
import ufm.cis.jayani.RouteMining.domain.builder.ReportBuilder;
import ufm.cis.jayani.RouteMining.domain.builder.ResponseAddressGenerator;
import ufm.cis.jayani.RouteMining.domain.shippingAPI.verify.response.AddressValidateResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log
@Service
public class ProcessUploadFacadeImpl implements ProcessUploadFacade {

	private final StorageService storageService;
	private final CSVHandlerService csvHandlerService;
	private final AddressAutoCorrectService addressAutoCorrect;
	private final AddressCordinatesService addressCordinatesService;
	private final RouteAddressCountService routeAddressCountService;
	private final RoutesJSONParserService routesJSONParserService;

	@Autowired
	public ProcessUploadFacadeImpl(StorageService storageService, CSVHandlerService csvHandlerService,
			AddressAutoCorrectService addressAutoCorrect, AddressCordinatesService addressCordinatesService,
			RouteAddressCountService routeAddressCountService, RoutesJSONParserService routesJSONParserService) {
		this.storageService = storageService;
		this.csvHandlerService = csvHandlerService;
		this.addressAutoCorrect = addressAutoCorrect;
		this.addressCordinatesService = addressCordinatesService;
		this.routeAddressCountService = routeAddressCountService;
		this.routesJSONParserService = routesJSONParserService;
	}

	@Override
	public String processFileUpload(MultipartFile file) {

		Path filePath = store(file);
		List<CsvBean> addresses = parseInputAddress(filePath);

		List rep1CsvBeanList = new ArrayList<Report1CSVBean>();
		List rep2CsvBeanList = new ArrayList<Report2CSVBean>();

		for (CsvBean csvBeanAddress : addresses) {
			Address address = (Address) csvBeanAddress;
			if(address.getStreet_number().contains("street_number"))
				continue;

			Report1CSVBean report1CSVBean = new Report1CSVBean();
			Report2CSVBean report2CSVBean = new Report2CSVBean();
			report1CSVBean.setStreet_number(address.getStreet_number());
			report1CSVBean.setStreet_name(address.getStreet_name());
			report1CSVBean.setCity(address.getCity());
			report1CSVBean.setState(address.getState());
			report1CSVBean.setZip(address.getZip());

			ResponseEntity<AddressValidateResponse> response = getAutoCorrect("",
					address.getStreet_number() + " " + address.getStreet_name(), address.getCity(),
					address.getState(), address.getZip());

			String lineAddress = getLineAddress(response);
			report1CSVBean.setCorrectedLineAddress(lineAddress);
			String carrierRoute = response.getBody().getAddress().getCarrierRoute();
			report1CSVBean.setRoute_id(carrierRoute);
			report2CSVBean.setCarrier_route(carrierRoute);
			String selectingFeature = getCordinates(lineAddress, carrierRoute);

			String totalAddressCount = getTotalCount(selectingFeature, carrierRoute);
			report2CSVBean.setAddress_count(totalAddressCount);

			rep1CsvBeanList.add(report1CSVBean);
			rep2CsvBeanList.add(report2CSVBean);

			log.info(totalAddressCount);
		}

		ResponseAddressGenerator director = new ResponseAddressGenerator();
		ReportBuilder report1 = new Report1();
		ReportBuilder report2 = new Report2();
		director.constructReport(report1, rep1CsvBeanList);
		director.constructReport(report2, rep2CsvBeanList);

		publishReport(file.getOriginalFilename(), report1.getReport());
		publishReport(file.getOriginalFilename(), report2.getReport());
		return "";//redirect response html file name
	}

	private ResponseEntity<AddressValidateResponse> getAutoCorrect(String address1, String address2, String city,
			String state, String zip5) {
		ResponseEntity<AddressValidateResponse> response =
				addressAutoCorrect.autoCorrectAddress(address1, address2, city, state, zip5);
		return response;
	}

	private String getCordinates(String address, String carrierRoute) {
		if (carrierRoute == null)
			return "";//todo handle null condition
		return addressCordinatesService.getCordinates(address);
	}

	public String getTotalCount(String selectingFeatures, String carrierRoute) {
		return routeAddressCountService.getTotalCount(routesJSONParserService, selectingFeatures, carrierRoute);
	}

	private Path store(MultipartFile file) {
		return storageService.store(file);
	}

	private List<CsvBean> parseInputAddress(Path path) {
		return csvHandlerService.readInput(path, Address.class);
	}

	private String publishReport(String fileName, Report report) {
		fileName = report.getReportType() + fileName;
		report.getReportCsvBean().add(0, report.getHeader());
		return csvHandlerService.writeCsvFromBean(fileName, report.getReportCsvBean());
	}

	private String getLineAddress(ResponseEntity<AddressValidateResponse> response) {
		StringBuilder sb = new StringBuilder();
		//todo handle null conditions here
//        sb.append(response.getBody().getAddress().getAddress1());
//        sb.append(" ,");
		sb.append(response.getBody().getAddress().getAddress2()).append(" ,");
		sb.append(response.getBody().getAddress().getCity()).append(" ,");
		sb.append(response.getBody().getAddress().getState()).append(" ,");
		sb.append(response.getBody().getAddress().getZip5());

		log.info("*** New Record ***");
		log.info(sb.toString() + " " + response.getBody().getAddress().getCarrierRoute());
		return sb.toString();
	}
}
