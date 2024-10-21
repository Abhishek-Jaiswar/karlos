Prac 1:
<html>
<head>
<title>prac1</title>
<script>
 function calculate(operation) {
 var num1 = parseInt(document.arithmetic.n1.value);
 var num2 = parseInt(document.arithmetic.n2.value);
 var result;
 switch (operation) {
 case 'add': result = num1 + num2; break;
 case 'sub': result = num1 - num2; break;
 case 'mul': result = num1 * num2; break;
 case 'div': result = num1 / num2; break;
 }
 document.arithmetic.res.value = result;
 }
</script>
</head>
<body>
 <h1 align="center"> Arithmetic Operations </h1>
 <form name="arithmetic">
 <table border="1" align="center">
 <tr>
 <td>Number 1: </td>
 <td><input type="text" name="n1" size="20"></td>
 </tr>
 <tr>
 <td>Number 2: </td>
 <td><input type="text" name="n2" size="20"></td>
 </tr>
 <tr>
 <td colspan="2">
 <input type="button" value="Add" onclick="calculate('add')">
 <input type="button" value="Subtract" onclick="calculate('sub')">
 <input type="button" value="Multiply" onclick="calculate('mul')">
 <input type="button" value="Divide" onclick="calculate('div')">
 </td>
 </tr>
 <tr>
 <td colspan="2">Result is: <input type="text" name="res" size="20"></td>
 </tr>
 </table>
 </form>
</body>
</html>


Prac 3:
Html:
<html> 
<head> 
<script type="text/javascript"> function gcd() 
{ 
var x,y; 
x=parseInt(document.myform.n1.value); 
y=parseInt(document.myform.n2.value); 
while(x!=y) 
{ 
if(x>y){x=x-y;} 
else{y=y-x;} 
} 
document.myform.result.value=x; 
} 
</script> 
</head> 
<body> 
<center> 
<h1>---Program to calculate GCD of two numbers---</h1> 
<hr color="red"> 
<form name="myform"> 
Enter Number 1: <input type="text" name="n1" value=""> <br> <br> 
Enter Number 2: <input type="text" name="n2" value=""> <br> <br> 
<input type="button" name="btn" value="Get GCD" onClick="gcd()"><br><br> 
GCD: <input type="text" name="result" value=""> 
</form> 
</center> 
</body> 
</html> 
package gcdpackage; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.firefox.FirefoxProfile; 
public class Test { 
 
 static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
 public static void main(String[] args) { 
 System.setProperty("webdriver.gecko.driver", driverPath); 
 FirefoxProfile fp = new FirefoxProfile(); 
 fp.setPreference(FirefoxProfile.PORT_PREFERENCE, "7055"); 
 FirefoxOptions options = new FirefoxOptions(); 
 options.setProfile(fp); 
 WebDriver driver = new FirefoxDriver(options); 
 driver.get("file:///D:/Usman/College/503%20pracs/gcdhtml.html"); 
 driver.manage().window().maximize(); 
 driver.findElement(By.name("n1")).sendKeys("36"); 
 driver.findElement(By.name("n2")).sendKeys("6"); 
 driver.findElement(By.name("btn")).click(); 
 String result = driver.findElement(By.name("result")).getAttribute("name=result"); 
 System.out.println("GCD=" + result); 
 } 
}


Prac 4:
package excelwrite; 
import jxl.*; 
import jxl.write.*; 
import jxl.write.Number; 
import java.io.*; 
import java.util.Locale; 
public class Excelwriter { 
 
 public static void main(String[] args) throws IOException, WriteException { 
 int r = 0, c = 0; 
 String header[] = {"Student Name", "Subject1", "Subject2", "Subject3", "Total"}; 
 String sname[] = {"Carls", "James", "Paul", "Philip", "Smith", "Thomson", "Rhodey", "Stark", "Gary", 
"AnneMarie"}; 
 int marks[] = {50, 45, 60, 55, 70, 45, 67, 78, 89, 90, 30}; 
 File file = new File("student.xls"); 
 WorkbookSettings wbSettings = new WorkbookSettings(); 
 wbSettings.setLocale(new Locale("en", "EN")); 
 WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings); 
 workbook.createSheet("Report", 0); 
 WritableSheet excelSheet = workbook.getSheet(0); 
 // creating header row
 for (c = 0; c < header.length; c++) { 
 Label l = new Label(c, r, header[c]); 
 excelSheet.addCell(l); 
 } 
 // filling names in column 1
 for (r = 1; r <= sname.length; r++) { 
 Label l = new Label(0, r, sname[r - 1]); 
 excelSheet.addCell(l); 
 } 
 // filling marks in columns 2, 3, and 4
 for (r = 1; r <= sname.length; r++) { 
 for (c = 1; c < 4; c++) { 
 Number num = new Number(c, r, marks[r - 1]); 
 excelSheet.addCell(num); 
 } 
 } 
 // filling total in column 5
 for (r = 1; r <= sname.length; r++) { 
 int total = marks[r - 1] * 3; 
 Number num = new Number(4, r, total); 
 excelSheet.addCell(num); 
 } 
 workbook.write(); 
 workbook.close(); 
 System.out.println("Excel File Created!!!!!"); 
 } 
}
Prac 5:
package excelread; 
import java.io.File; 
import java.io.IOException; 
import jxl.Cell; 
import jxl.CellType; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException; 
public class Excelreader { 
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
 for (int j = 0; j < sheet.getRows(); j++) { 
 for (int i = 0; i < sheet.getColumns() - 1; i++) { 
 Cell cell = sheet.getCell(i, j); 
 if (cell.getType() == CellType.NUMBER) { 
 if (Integer.parseInt(cell.getContents()) >= 60) { 
 flag = true; 
 if (flag) { 
 count++; 
 flag = false; 
 } 
 break; 
 } 
 } 
 } 
 } 
 System.out.println("Total number of students who scored more than 60 in one or more subjects: " + 
count); 
 } catch (BiffException e) {
 e.printStackTrace();
 } 
 } 
 
 public static void main(String[] args) throws IOException { 
 Excelreader test = new Excelreader(); 
 test.setInputFile("C:\\Users\\Usman\\eclipseworkspace\\p5\\student.xls"); 
 test.read(); 
 } 
}


Prac 6:
package p6; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
public class FindAllLinks { 
 static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
 public static void main(String[] args) { 
 System.setProperty("webdriver.gecko.driver", driverPath); 
 WebDriver driver = new FirefoxDriver(); 
 String appUrl = "https://www.google.co.in/"; 
 driver.get(appUrl); 
 java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
 for (int i = 1; i < links.size(); i = i + 1) { 
 System.out.println(links.get(i).getText()); 
 } 
 System.out.println("Total No. of Links: " + links.size()); 
 } 
}


Prac 7:
Html:
<select id="continents"> 
<option value="Asia">Asia</option> 
<option value="Europe">Europe</option>
<option value="Africa">Africa</option>
</select>
package p7; 
import java.util.List; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select; 
public class ComboBox { 
 static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
 public static void main(String[] args) { 
 System.setProperty("webdriver.gecko.driver", driverPath); 
 WebDriver driver = new FirefoxDriver(); 
 String appUrl = "https://www.toolsqa.com/automation-practice-form/"; 
 driver.get(appUrl); 
 Select oSelect = new Select(driver.findElement(By.id("continents"))); 
 List<WebElement> oSize = oSelect.getOptions(); 
 int iListSize = oSize.size(); 
 for (int i = 0; i < iListSize; i++) { 
 String sValue = oSelect.getOptions().get(i).getText(); 
 System.out.println(sValue); 
 } 
 System.out.println("Total No. Items in Dropdown: " + iListSize); 
 } 
}

   
Prac 8:
Html:
<input type="checkbox" value="A">A<br> 
<input type="checkbox" value="B" CHECKED>B<br> 
<input type="checkbox" value="C">C<br> 
<input type="checkbox" value="D" CHECKED>D<br> 
<input type="checkbox" value="E">E<br>
package p8; 
import java.util.List; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
public class MultiCheckBox { 
 static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
 public static void main(String[] args) { 
 System.setProperty("webdriver.gecko.driver", driverPath); 
 WebDriver driver = new FirefoxDriver(); 
 String appUrl = "https://www.toolsqa.com/automation-practice-form/"; 
 driver.get(appUrl); 
 List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); 
 int checkedCount = 0, uncheckedCount = 0; 
 for (int i = 0; i < checkBoxes.size(); i++) { 
 System.out.println(i + " checkbox is selected " + checkBoxes.get(i).isSelected()); 
 if (checkBoxes.get(i).isSelected()) { 
 checkedCount++; 
 } else { 
 uncheckedCount++; 
 } 
 } 
 System.out.println("No. of selected checkbox: " + checkedCount); 
 System.out.println("No. of unselected checkbox: " + uncheckedCount); 
 } 
}
 
 
