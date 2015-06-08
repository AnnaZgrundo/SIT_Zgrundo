package IStroka;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStroka extends Remote {
	String getStroka(String str) throws RemoteException;
}
