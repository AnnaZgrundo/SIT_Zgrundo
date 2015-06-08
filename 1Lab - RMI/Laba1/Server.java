/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Arsenal
 */
public class Server implements Hello {

	public Server() {}

// реализация интерфейса
    	public String sayHello() {
		return "Hello, world!";
	}

   	 public static void main(String args[]) {

		try {
// создаем и экспортируем удаленный объект
			Server obj = new Server();
    			Hello stub = 
				(Hello) UnicastRemoteObject.exportObject(obj, 0);

// Регистрируем удаленный объект в RMI-регистраторе под именем
			 Registry registry = LocateRegistry.getRegistry();
   			 registry.bind("Hello", stub);

  			 System.err.println("Server ready");
		} catch (Exception e) {
			    System.err.println("Server exception: " + e.toString());
			    e.printStackTrace();
		}
    	}
}

