/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projsd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gearl
 */
public class Olamundo {
    private Olamundo() {
	}

	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];

		try {
			
			//Obtém o stub para registro
			Registry registry = LocateRegistry.getRegistry(host);
			
			//Obtém o stub para o objeto remoto (Ola) do registro.
			Ola stub = (Ola) registry.lookup("Ola");

			//Invocação do método remoto
			String resposta = stub.digaOla();
			System.out.println("Resposta: " + resposta);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exceção do cliente: " + e.toString());
		}
	}
}
