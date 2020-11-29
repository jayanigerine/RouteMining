package ufm.cis.jayani.RouteMining.domain.builder;

import java.util.List;

import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;

public class Report {
	private CsvBean header;
	private String reportType;
	private List<CsvBean> reportCsvBean;

	public CsvBean getHeader() {
		return header;
	}

	Report setHeader(CsvBean header) {
		this.header = header;
		return this;
	}

	public String getReportType() {
		return reportType;
	}

	public Report setReportType(String reportType) {
		this.reportType = reportType;
		return this;
	}

	public List<CsvBean> getReportCsvBean() {
		return reportCsvBean;
	}

	public Report setReportCsvBean(List<CsvBean> reportCsvBean) {
		this.reportCsvBean = reportCsvBean;
		return this;
	}
}
