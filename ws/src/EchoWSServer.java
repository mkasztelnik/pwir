package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EchoWSServer {
  @WebMethod
  public String echo(String msg) {
    System.out.println("Otrzymałem wiadomość: " + msg);
    return msg;
  }

  public static void main(String[] args){
    EchoWSServer calculator = new EchoWSServer();
    Endpoint endpoint = Endpoint.publish("http://localhost:8080/echo", calculator);
  }
} 
