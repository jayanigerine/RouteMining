package ufm.cis.jayani.RouteMining.domain.builder;

import java.util.List;

import ufm.cis.jayani.RouteMining.domain.builder.ReportBuilder;
import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;
import ufm.cis.jayani.RouteMining.domain.csv.Report1CSVBean;

public class Report1 extends ReportBuilder {
	Report report = new Report();

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@Override
	public void setReportType() {
		report.setReportType("Address-CarrierRoute-");
	}

	@Override
	public void addReportData(List<CsvBean> csvBeanList) {
		report.setReportCsvBean(csvBeanList);
	}

	@Override
	public void setHeaders() {
		report.setHeader(new Report1CSVBean("street_number", "street_name",
				"apt_number", "city", "state",
				"zip", "correctedLineAddress", "route_id"));
	}
}
