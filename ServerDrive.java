/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemas;

/**
 *
 * @author gearl
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
 
public class ServerDrive {
 
    public static void main(String[] args) {
        try {
            // enter username
            Scanner in = new Scanner(System.in);
            System.out.print("Seu nome: ");
            String name = in.nextLine().trim();
 
            // register a name to RMI registry, for binding chatServer
            LocateRegistry.createRegistry(1099);
 
            ServerImpl chatServer = new ServerImpl(name);
            String url = "rmi://localhost/ABC";
            Naming.rebind(url, chatServer);
            System.out.println("Servidor rodando...");
 
            while (true) {
                String msg = in.nextLine().trim();
                msg = "[" + chatServer.getName() + "] " + msg;
                chatServer.broadcastMessage(msg);
            }
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Servidor falhou: " + e);
        }
 
    }
}

