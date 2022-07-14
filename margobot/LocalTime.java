import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class LocalTime {    
  public static void main(String[] args) {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();
   System.out.println(dtf.format(now));
  }    
} 