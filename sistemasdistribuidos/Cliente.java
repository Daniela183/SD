/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemasdistribuidos;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Daniela
 */
public class Cliente {
    public static void main(String args[]) {
        DatagramSocket ser = null;
          try {
            String servidor = "Localhost";
              int porta = 6789;
                String msgm = "Mensagem de teste";
                    if (args.length > 0) servidor = args[0];
                    if (args.length > 1) porta = Integer.parseInt(args[1]);
                    if (args.length > 2) msgm = args[2];
                        byte[] m = msgm.getBytes(); // transforma arg em bytes

			InetAddress serv = InetAddress.getByName(servidor);

			ser = new DatagramSocket(); // cria um socket UDP

			System.out.println("*Socket criado na porta: " + ser.getLocalPort());

			DatagramPacket req = new DatagramPacket(m, msgm.length(), serv, porta);

			ser.send(req); // envia datagrama contendo a mensagem m

			System.out.println("*Datagrama enviado: " + msgm);

			byte[] buffer = new byte[1000];

			DatagramPacket resp = new DatagramPacket(buffer, buffer.length);

			ser.setSoTimeout(10000); // timeout em ms

			ser.receive(resp); // aguarda resposta do servidor - bloqueante

			System.out.println("*Resposta do servidor: " + new StringBuilder
                            (new String(resp.getData(), 0, resp.getLength())).reverse().toString());

		} catch (SocketException e) {
			// timeout, erro na criação
			System.out.println("!Erro no socket: " + e.getMessage());
			
		} catch (IOException e) {
			System.out.println("!Erro de envio/recepção do pacote: " + e.getMessage());
			
		} finally {
			if (ser!= null) ser.close();
		}
	}
}
