package assesment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadDataExcel {

	public static void main(String[] args) throws IOException {

		File xlsFile = new File(System.getProperty("user.dir") + "/src/main/java/testdata/emptestdata.xls");
		System.out.println(xlsFile.getName());

		FileInputStream inputStream = new FileInputStream(xlsFile);

		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			

		// Reading the first sheet of the excel file
		HSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			// Iterating all the columns in a row
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue()+"\t");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue()+"\t");
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue()+"\t");
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}

		inputStream.close();

	}

}