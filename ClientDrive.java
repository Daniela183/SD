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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
 
public class ClientDrive {
    public static void main(String[] args) {
        try {
            // enter username
            Scanner in = new Scanner(System.in);
            System.out.print("Seu nome: ");
            String name = in.nextLine().trim();
 
            // get chatServer (stub) from RMI registry
            Server chatServer = (Server)Naming.lookup("rmi://localhost/ABC");
            ClientImpl chatClient= new ClientImpl(name, chatServer);
 
            while (true) {
                String msg = in.nextLine().trim();
                msg = "[" + chatClient.getName() + "] " + msg;
                chatServer.broadcastMessage(msg);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("Servidor falhou: " + e);
        }
    }
}

