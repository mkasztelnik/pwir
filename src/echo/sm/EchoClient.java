
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class EchoClient {
    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());
        try {
	    String host = args[0];
            String name = args[1];
	    Registry registry = LocateRegistry.getRegistry(host);
            Echo echo = (Echo) registry.lookup(name);
            System.out.println(echo.reply(args[2]));
        } catch (Exception e) {
            System.err.println("Echo exception: " +
                               e.getMessage());
            e.printStackTrace();
        }
    }
}

