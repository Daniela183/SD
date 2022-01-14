/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemas;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
 
public class ServerImpl extends UnicastRemoteObject implements Server {
 
    public String name;
    public List<Client> clients;
 
    public ServerImpl(String name) throws RemoteException {
        this.name = name;
        this.clients = new ArrayList<>();
    }
 
    @Override
    public String getName() throws RemoteException {
        return this.name;
    }/*@Override
    public String getName() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 
    @Override
    public void broadcastMessage(String msg) throws RemoteException {
        for (Client client : clients) {
            client.retrieveMessage(msg);
        }
        System.out.println(msg);
    }/*@Override
    public void broadcastMessage(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 
    @Override
    public void registerClient(Client client) throws RemoteException {
        this.clients.add(client);
    }/*@Override
    public void registerClient(Client client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

 
    @Override
    public List<Client> getClients() throws RemoteException {
        return this.clients;
    }/*@Override
    public List<Client> getClients() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
