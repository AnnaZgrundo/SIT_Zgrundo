/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author ko
 */
import IStroka.IStroka;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        try {
            int host;
            String str;
            host = 8071;
            Registry registry = LocateRegistry.getRegistry(host);
            IStroka stub = (IStroka) registry.lookup("Stroka");
            Scanner sc = new Scanner(System.in);//сканер для чтения с консоли
            do {
                System.out.println("Enter string:");
                str = sc.nextLine();
                if (!str.equals("")) {
                    String stroka = stub.getStroka(str);
                    System.out.println("New string: " + stroka);
                }
                else 
                    System.out.println("End of work. Thanks for your attention!");
            } while (!str.equals(""));

            {

            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
