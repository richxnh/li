package li.office;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class T {
	public static void main(String[] args) throws Exception {
		Workbook workbook = new HSSFWorkbook(new FileInputStream("F:\\PPS\\人力资源部\\2010会员档案总列表.xls"));

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Sheet sheet = workbook.getSheetAt(0);
			int n = 0;
			for (Row row : sheet) {
				System.out.print(n++ + "\t");
				for (Cell cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		}
	}
}