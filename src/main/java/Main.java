
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

        public class Main {
            private static final String FILE_NAME = "src/main/resources/Excel.xlsx";

            public static void main(String[] args) throws IOException {
                List<Pacjent> pacjentList = new ArrayList<>();
                pacjentList.add(new Pacjent("Jakub Trzcinski", "96071502" ));
                pacjentList.add(new Pacjent("Mikołaj Rej","60708090"));
                pacjentList.add(new Pacjent("Jan Kochanowski","50607080"));
                System.out.println("Creating excel");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Pracownicy");
                creatingDataExcel(sheet, pacjentList);
                try {
                    FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
                    workbook.write(outputStream);
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Finish");

                Sprawdzaj.człowiek("Jan Kochanowski");
                Sprawdzaj.człowiek("Andrzej Duda");
                Sprawdzaj.człowiek("96071502");
//        try {
//
//            FileInputStream file = new FileInputStream(FILE_NAME);
//
//            //Get the workbook instance for XLS file
//            XSSFWorkbook workbook1 = new XSSFWorkbook(file);
//
//            //Get first sheet from the workbook
//            XSSFSheet sheet1 = workbook1.getSheetAt(0);
//
//            //Iterate through each rows from first sheet
//            Iterator<Row> rowIterator = sheet1.iterator();
//            while(rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                //For each row, iterate through each columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while(cellIterator.hasNext()) {
//
//                    Cell cell = cellIterator.next();
//
//
//                            System.out.print(cell.getStringCellValue() + "\t\t");
//
//
//                }
//                System.out.println("");
//            }
////            file.close();
////            FileOutputStream out =
////                    new FileOutputStream(FILE_NAME);
////            workbook.write(out);
////            out.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

            }
            private static void creatingDataExcel(XSSFSheet sheet, List<Pacjent> pacjentList) {
                int rowNum = 0;
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue("Imię i Nazwisko");
                row.createCell(1).setCellValue("Pesel");
                for (Pacjent employee : pacjentList) {
                    row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(employee.getName());
                    row.createCell(1).setCellValue(employee.getPesel());
                }
            }

        }

