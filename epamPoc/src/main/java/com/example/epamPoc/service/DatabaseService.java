package com.example.epamPoc.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.epamPoc.entity.DatabasesDetail;
import com.example.epamPoc.repository.DatabaseDetailRepository;
import com.example.epamPoc.util.PocUtility;

@Service
public class DatabaseService {

	@Autowired
	private DatabaseDetailRepository repository;

	public void saveDetail() {
		for (int i = 0; i < 2000; i++) {
			DatabasesDetail test = new DatabasesDetail(PocUtility.random(), PocUtility.random(), (int) Math.random(),
					"sit");
			repository.save(test);
		}
	}

	public List<DatabasesDetail> getDatabaseInfo() {

		return repository.findAll();
	}

	public List<DatabasesDetail> getReconInfo() throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Reviews");

		writeHeaderLine(sheet);

		writeDataLines(repository.findAll(), workbook, sheet);
		FileOutputStream outputStream = new FileOutputStream("dbDetail-export.xlsx");
		workbook.write(outputStream);
		workbook.close();
		return null;
	}

	private void writeDataLines(List<DatabasesDetail> dataBaseDetailList, XSSFWorkbook workbook, XSSFSheet sheet) {
		int rowCount = 1;

		for (DatabasesDetail result : dataBaseDetailList) {
			
			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(result.getDatabaseNameString());

			cell = row.createCell(columnCount++);
			cell.setCellValue(result.getHost());

//			cell = row.createCell(columnCount++);
//
//			CellStyle cellStyle = workbook.createCellStyle();
//			CreationHelper creationHelper = workbook.getCreationHelper();
//			cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
//			cell.setCellStyle(cellStyle);
//			cell.setCellValue(timestamp);

			cell = row.createCell(columnCount++);
			cell.setCellValue(result.getPort());

			cell = row.createCell(columnCount);
			cell.setCellValue(result.getDbenv());

		}

	}

	private void writeHeaderLine(XSSFSheet sheet) {
		Row headerRow = sheet.createRow(0);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("databaseNameString");

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("host");

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("port");

		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("dbenv");

	}

}
