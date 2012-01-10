
import java.rmi.RMISecurityManager;
import java.rmi.Naming;


public class EchoClient {
    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            String name = args[0];
            Echo echo = (Echo) Naming.lookup(name);
            System.out.println(echo.reply(args[1]));
        } catch (Exception e) {
            System.err.println("Echo exception: " +
                               e.getMessage());
            e.printStackTrace();
        }
    }
}

