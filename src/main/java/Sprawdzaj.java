import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Sprawdzaj {
    private static final String FILE_NAME = "src/main/resources/Excel.xlsx";
    public static void człowiek(String name){
        List<Pacjent> employeeList = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(workbook.getNumberOfSheets()-1);
            for (int i = 1 ; i < datatypeSheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = datatypeSheet.getRow(i);
                employeeList.add(new Pacjent(currentRow.getCell(0).toString(), currentRow.getCell(1).toString()));
               /* for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    System.out.println(currentRow.getCell(j));
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (employeeList.stream().anyMatch(pacjent1 -> pacjent1.getName().equals(name) || pacjent1.getPesel().equals(name))){
            System.out.println("Jest w bazie");
        }else {
            System.out.println("Nie ma go w bazie");
        }


    }
}