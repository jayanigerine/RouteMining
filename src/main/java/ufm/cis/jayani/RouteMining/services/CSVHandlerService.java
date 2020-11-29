package ufm.cis.jayani.RouteMining.services;

import java.nio.file.Path;
import java.util.List;

import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;

public interface CSVHandlerService {
	List<CsvBean> readInput(Path path, Class clazz);

	String writeCsvFromBean(String filePath, List<CsvBean> list);
}
