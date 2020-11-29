package ufm.cis.jayani.RouteMining.domain.csv;

import com.opencsv.bean.CsvBindByPosition;

public class Report1CSVBean implements CsvBean {
	public Report1CSVBean() {

	}

	public Report1CSVBean(String street_number, String street_name, String apt_number, String city, String state,
			String zip, String correctedLineAddress, String route_id) {
		this.street_number = street_number;
		this.street_name = street_name;
		this.apt_number = apt_number;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.correctedLineAddress = correctedLineAddress;
		this.route_id = route_id;
	}

	@CsvBindByPosition(position = 0)
	private String street_number;
	@CsvBindByPosition(position = 1)
	private String street_name;
	@CsvBindByPosition(position = 2)
	private String apt_number;
	@CsvBindByPosition(position = 3)
	private String city;
	@CsvBindByPosition(position = 4)
	private String state;
	@CsvBindByPosition(position = 5)
	private String zip;

	@CsvBindByPosition(position = 6)
	private String correctedLineAddress;

	@CsvBindByPosition(position = 7)
	private String route_id;

	public String getCorrectedLineAddress() {
		return correctedLineAddress;
	}

	public Report1CSVBean setCorrectedLineAddress(String correctedLineAddress) {
		this.correctedLineAddress = correctedLineAddress;
		return this;
	}

	public String getRoute_id() {
		return route_id;
	}

	public Report1CSVBean setRoute_id(String route_id) {
		this.route_id = route_id;
		return this;
	}

	public String getStreet_number() {
		return street_number;
	}

	public Report1CSVBean setStreet_number(String street_number) {
		this.street_number = street_number;
		return this;
	}

	public String getStreet_name() {
		return street_name;
	}

	public Report1CSVBean setStreet_name(String street_name) {
		this.street_name = street_name;
		return this;
	}

	public String getApt_number() {
		return apt_number;
	}

	public Report1CSVBean setApt_number(String apt_number) {
		this.apt_number = apt_number;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Report1CSVBean setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public Report1CSVBean setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Report1CSVBean setZip(String zip) {
		this.zip = zip;
		return this;
	}
}
