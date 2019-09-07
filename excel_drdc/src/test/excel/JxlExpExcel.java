package test.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExpExcel {

	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		File file = new File("E:/Projects/jxl_test.xls");
		try {
			file.createNewFile();
			//创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//创建sheet
			WritableSheet sheet = workbook.createSheet("Sheet1",0);
			Label label = null;
			//第一行设置列名
			for (int i = 0; i < title.length; i++) {
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			for (int i = 1; i < 10; i++) {
				label = new Label(0,i,"a" + i);
				sheet.addCell(label);
				label = new Label(1,i,"user" + i);
				sheet.addCell(label);
				label = new Label(2,i,"男");
				sheet.addCell(label);
			}
			
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
