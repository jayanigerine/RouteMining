package ufm.cis.jayani.RouteMining.domain.builder;

import java.util.List;

import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;

public abstract class ReportBuilder {


	public abstract void setReportType();

	public abstract void addReportData(List<CsvBean> csvBeanList);

	public abstract void setHeaders();

	public abstract Report getReport();
}
