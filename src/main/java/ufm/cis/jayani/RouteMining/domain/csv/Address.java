package ufm.cis.jayani.RouteMining.domain.csv;

import com.opencsv.bean.CsvBindByPosition;

public class Address implements CsvBean {
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

	public String getStreet_number() {
		return street_number;
	}

	public Address setStreet_number(String street_number) {
		this.street_number = street_number;
		return this;
	}

	public String getStreet_name() {
		return street_name;
	}

	public Address setStreet_name(String street_name) {
		this.street_name = street_name;
		return this;
	}

	public String getApt_number() {
		return apt_number;
	}

	public Address setApt_number(String apt_number) {
		this.apt_number = apt_number;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public Address setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Address setZip(String zip) {
		this.zip = zip;
		return this;
	}
}
