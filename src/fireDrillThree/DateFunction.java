package fireDrillThree;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateFunction {


    public Period getAge(String myDate) {
        LocalDate newDate = LocalDate.parse(myDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(LocalDate.now(), newDate);
    }
}



