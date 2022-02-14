
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Set;


public class DateTime {
    public static void main(String[] args){
        LocalDate myDateNow = LocalDate.now();
        System.out.println("Hello From Local Date " + myDateNow);
        LocalTime myTimeNow = LocalTime.now();
        System.out.println("Hello From Local Time " + myTimeNow);

        Set<String> allZonesIDs = ZoneId.getAvailableZoneIds();
        allZonesIDs.forEach(System.out::println);

    }
}
