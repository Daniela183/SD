/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemas;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author gearl
 */

 
import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface Client extends Remote {
    public String getName() throws RemoteException;
    public void retrieveMessage(String msg) throws RemoteException;
}