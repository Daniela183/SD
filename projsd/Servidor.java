/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projsd;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author gearl
 */
public class Servidor {
    public Servidor() {
	}

	public String digaOla() {
		return "Olá Mundo!";
	}

	public static void main(String[] args) {
		try {
			
			//Criação do objeto remoto
			Servidor obj = new Servidor();
			
			//Exportação do objeto remoto.
			Ola stub = (Ola) UnicastRemoteObject.exportObject((Remote) obj, 0);

			//Registro do objeto remoto com RMI Registry.
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Ola", (Remote) stub);

			System.err.println("Servidor está pronto...");

		} catch (Exception e) {
			System.err.println("Exceção no Servidor:" + e.toString());
			e.printStackTrace();
		}
	}

}
