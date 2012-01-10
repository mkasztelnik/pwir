import org.stgregorioschurchdc.www.Calendar.*;

public class Client {
public static void  main(String args[]) {
try {
     //tworzymy referencje do usługi
     Calendar calendar = new CalendarLocator();

     //pobieramy port SOAPowy
     EasterDateSoapPort port = calendar.getEasterDateSoapPort();

     //wywolujemy zdalnie funkcję usługi
     System.out.println(port.easter_date(Short.parseShort(args[0])));

} catch (Exception e) {
     System.err.println("App exception: " +
                           e.getMessage());
      e.printStackTrace();
}

}
}
