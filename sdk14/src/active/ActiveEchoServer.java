
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.rmi.MarshalledObject;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationGroup;

import java.util.Properties;


public class ActiveEchoServer extends Activatable
                           implements Echo
{
    public ActiveEchoServer(ActivationID id, MarshalledObject data)
    throws RemoteException {
        super(id, 0);
    }


    public String reply(String s) {
        System.out.println("EchoServer: odebrana wiadomosc "+s);
        return s;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());

        Properties prop = new Properties();
        prop.put("java.security.policy", "java.policy");
        ActivationGroupDesc grp = new ActivationGroupDesc(prop, null);

        try {
            ActivationGroupID agid = ActivationGroup.getSystem().registerGroup(grp);
            ActivationDesc desc = new ActivationDesc
                (agid, "ActiveEchoServer", args[0], null);

            Echo server = (Echo) Activatable.register(desc);
            System.out.println("Stworzona instancja stub serwera");
            Naming.rebind(args[1], server);
            System.out.println("Setup: zarejestrowalem stub servera");
        } catch (Exception e) {
            System.err.println("Setup wyjatek: "+e.getMessage());
            e.printStackTrace();
        }
        System.exit(0);
    }
}

