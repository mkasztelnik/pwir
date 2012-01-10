
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Echo extends Remote {
    String reply(String s) throws RemoteException;
}
