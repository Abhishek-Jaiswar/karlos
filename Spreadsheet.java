
// p4 excel writer
package exelwrite;

import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import java.util.Locale;
import java.io.*;

public class ExcelWriter {
    public static void main(String[] args) throws IOException, WriteException { 

        String header[] = {"Student Name", "Subject1", "Subject2", "Subject3", "Total"}; 
        
        String sname[] = {"Carls", "James", "Paul", "Philip", "Smith", "Thomson", "Rhodey", "Stark", "Gary", "AnneMarie"}; 
        
        int marks1[] = {50, 45, 60, 55, 70, 45, 67, 78, 89, 90}; 
        int marks2[] = {55, 47, 62, 58, 75, 48, 70, 80, 92, 85}; 
        int marks3[] = {60, 50, 65, 60, 80, 50, 75, 85, 95, 87}; 
        
        File file = new File("student.xls"); 
        WorkbookSettings wbSettings = new WorkbookSettings(); 
        wbSettings.setLocale(new Locale("en", "EN")); 
        
        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings); 
        workbook.createSheet("Report", 0); 
        WritableSheet excelSheet = workbook.getSheet(0); 
        
        for(int c = 0; c < header.length; c++) { 
            Label l = new Label(c, 0, header[c]); 
            excelSheet.addCell(l); 
        } 
        
        for(int r = 1; r <= sname.length; r++) { 
            Label l = new Label(0, r, sname[r-1]); 
            excelSheet.addCell(l); 
        } 
        
        for(int r = 1; r <= sname.length; r++) { 
            Number num1 = new Number(1, r, marks1[r-1]); 
            excelSheet.addCell(num1); 
            
            Number num2 = new Number(2, r, marks2[r-1]); 
            excelSheet.addCell(num2); 
            
            Number num3 = new Number(3, r, marks3[r-1]); 
            excelSheet.addCell(num3); 
            
            int total = marks1[r-1] + marks2[r-1] + marks3[r-1]; 
            Number totalMarks = new Number(4, r, total); 
            excelSheet.addCell(totalMarks); 
        } 
        workbook.write(); 
        workbook.close(); 
        
        System.out.println("Excel File Created!!!!!"); 
    }
}

// excel read 

package excelread;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        boolean flag = false;
        int count = 0;

        try {
            w = Workbook.getWorkbook(inputWorkbook);

            Sheet sheet = w.getSheet(0);

            for (int j = 1; j < sheet.getRows(); j++) {
                for (int i = 1; i < sheet.getColumns() - 1; i++) { 
                    Cell cell = sheet.getCell(i, j);
                    if (cell.getType() == CellType.NUMBER) {
                        if (Integer.parseInt(cell.getContents()) >= 60) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    count++;
                    flag = false;
                }
            }

            System.out.println("Total number of students who scored more than 60 in one or more subjects: " + count);
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ExcelReader test = new ExcelReader();

        test.setInputFile("C:\\Users\\abhis\\eclipse-workspace\\seleniumPrac4\\student.xls");
        
        test.read();
    }
}


