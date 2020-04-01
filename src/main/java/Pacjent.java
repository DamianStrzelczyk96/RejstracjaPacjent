import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Pacjent {
    private String name;
    private String pesel;


}
