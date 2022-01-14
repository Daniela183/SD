/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemas;

import java.rmi.RemoteException;
import com.mycompany.sistemas.Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client {
 
    private String name;
    private Server chatServer;
 
    public ClientImpl(String name, Server chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerClient(this);
 
        // broadcast status message to server
        String msg = "[" + this.name + "] got connected";
        chatServer.broadcastMessage(msg);
    }
 
    @Override
    public String getName() throws RemoteException {
        return this.name;
    /*@Override
    public String getName() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    }
 
    @Override
    public void retrieveMessage(String msg) throws RemoteException {
        System.out.println(msg);
    /*@Override
    public void retrieveMessage(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    }
}

