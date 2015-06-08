/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import IStroka.IStroka;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ko
 */
public class Server implements IStroka {

    public Server() {
    }

// реализация интерфейса
    public String getStroka(String str) {
        System.out.print("First string: " + str);
        str = str.replaceAll(" ", "");
        System.out.println("; Final string: " + str);
        return str;
    }

    public static void main(String args[]) {

        try {
            int port;
            port = 8071;
            System.out.println("Server ready");
            System.out.println("PORT: " + port);
            final Registry registry = LocateRegistry.createRegistry(port);
            Server obj = new Server();
            IStroka stub
                    = (IStroka) UnicastRemoteObject.exportObject(obj, 0);

            registry.bind("Stroka", stub);

            System.out.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
