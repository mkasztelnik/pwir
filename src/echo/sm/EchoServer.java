
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoServer extends UnicastRemoteObject
                           implements Echo
{
    public EchoServer() throws RemoteException {
    }

    public String reply(String s) {
    	System.out.println("EchoServer: odebrana wiadomosc "+s);
        return s;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
      	String name = args[0];
	try {
		EchoServer server = new EchoServer();
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind(name, server);
		System.out.println("EchoServer: zarejestrowalem sie");
	} catch (Exception e) {
		System.err.println("EchoServer wyjatek: " + e.getMessage());
		e.printStackTrace();
	}
    }
}
