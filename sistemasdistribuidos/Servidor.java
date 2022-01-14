/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemasdistribuidos;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 *
 * @author Daniela
 */
public class Servidor {
    public static void main(String args[]) {
    	
        try (DatagramSocket ser = new DatagramSocket(6789)) { 
            // cria um socket UDP
            byte[] buffer = new byte[1000];
            
            System.out.println("\n\n*** Servidor aguardando request");
       
            DatagramPacket req = new DatagramPacket(buffer, buffer.length);
            ser.receive(req);
            
            System.out.println("***Request recebido de: " + req.getAddress()+":"+req.getPort());
            
            // envia resposta
            DatagramPacket resp = new DatagramPacket(req.getData(), req.getLength(),req.getAddress(), req.getPort());
            ser.send(resp);
            
        } catch (SocketException e) {
            System.out.println("Erro de socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de envio/recepção do pacote: " + e.getMessage());
        }
    }
}
