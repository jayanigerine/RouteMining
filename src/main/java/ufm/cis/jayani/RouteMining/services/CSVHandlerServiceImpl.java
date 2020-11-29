package ufm.cis.jayani.RouteMining.services;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import ufm.cis.jayani.RouteMining.domain.csv.CsvBean;
import ufm.cis.jayani.RouteMining.parsers.CsvTransfer;
import ufm.cis.jayani.RouteMining.storage.StorageProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSVHandlerServiceImpl implements CSVHandlerService {
	private final Path rootLocation;

	@Autowired
	public CSVHandlerServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	public List<CsvBean> readInput(Path path, Class clazz) {

		CsvTransfer csvTransfer = new CsvTransfer();
		ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
		ms.setType(clazz);

		try {
			Reader reader = Files.newBufferedReader(path);
			CsvToBean cb = new CsvToBeanBuilder(reader)
					.withType(clazz)
					.withMappingStrategy(ms)
					.build();
			csvTransfer.setCsvList(cb.parse());
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return csvTransfer.getCsvList();
	}

	@Override
	public String writeCsvFromBean(String fileName, List<CsvBean> list) {
		Path destinationFile = this.rootLocation.resolve(
				Paths.get(fileName))
				.normalize().toAbsolutePath();
		try {
			Writer writer = new FileWriter(destinationFile.toString());

			StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
					.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.build();

			sbc.write(list);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
