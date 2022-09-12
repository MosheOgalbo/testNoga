import java.io.File;
import java.io.FileInputStream;

public class GetExcel {
    public static FileInputStream Excel( ) throws Exception
    {

        // Create a file object
        // for the path of existing Excel file
        // Give the path of the file as parameter
        // from where file is to be read
        File file = new File("/Users/moshe_ogalbo/Downloads/cost_2022_04_09-2022_11_09.xlsx");

        // Create a FileInputStream object
        // for getting the information of the file
        FileInputStream fip = new FileInputStream(file);

        // Getting the workbook instance for XLSX file
//        XSSFWorkbook workbook = new XSSFWorkbook(fip);

        // Ensure if file exist or not
        if (file.isFile() && file.exists()) {
            System.out.println("Geeks.xlsx open");
        }
        else {
            System.out.println("Geeks.xlsx either not exist"
                    + " or can't open");
        }
        return fip ;
    }
}
