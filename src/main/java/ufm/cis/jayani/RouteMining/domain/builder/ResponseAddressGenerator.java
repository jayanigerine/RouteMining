package ufm.cis.jayani.RouteMining.domain.builder;

import java.util.List;

import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;

public class ResponseAddressGenerator {
	public void constructReport(ReportBuilder reportBuilder, List<CsvBean> csvBeanList) {
		reportBuilder.setReportType();
		reportBuilder.addReportData(csvBeanList);
		reportBuilder.setHeaders();
	}
}
