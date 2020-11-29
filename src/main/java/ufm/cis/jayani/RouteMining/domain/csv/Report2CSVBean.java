package ufm.cis.jayani.RouteMining.domain.csv;

import com.opencsv.bean.CsvBindByPosition;

public class Report2CSVBean implements CsvBean {
	public Report2CSVBean() {

	}

	public Report2CSVBean(String carrier_route, String address_count) {
		this.carrier_route = carrier_route;
		this.address_count = address_count;
	}

	@CsvBindByPosition(position = 0)
	private String carrier_route;
	@CsvBindByPosition(position = 1)
	private String address_count;

	public String getCarrier_route() {
		return carrier_route;
	}

	public Report2CSVBean setCarrier_route(String carrier_route) {
		this.carrier_route = carrier_route;
		return this;
	}

	public String getAddress_count() {
		return address_count;
	}

	public Report2CSVBean setAddress_count(String address_count) {
		this.address_count = address_count;
		return this;
	}
}
