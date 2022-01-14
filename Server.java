/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author gearl
 */
public interface Server extends Remote {
    public String getName() throws RemoteException;
    public void broadcastMessage(String msg) throws RemoteException;
    public void registerClient(Client client) throws RemoteException;
    public List<Client> getClients() throws RemoteException;
}

