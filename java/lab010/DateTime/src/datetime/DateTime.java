/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Set;
/**
 *
 * @author sarah
 */
public class DateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        LocalDate myDateNow = LocalDate.now();
        System.out.println("Hello From Local Date " + myDateNow);
        LocalTime myTimeNow = LocalTime.now();
        System.out.println("Hello From Local Time " + myTimeNow);

        Set<String> allZonesIDs = ZoneId.getAvailableZoneIds();
        allZonesIDs.forEach(System.out::println);

    }
    
}
