package com.mycompany.tcp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Daniela e Vitor
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
  
	ServerSocket Servidor = new ServerSocket(12345);

	System.out.println("Porta 12345 aberta!");

	Socket cliente = Servidor.accept();
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

	Scanner entrada = new Scanner(cliente.getInputStream());
            String a = null;
               Facilitador.Write("C:/Users/gearl/Desktop/sistemaD/respostaprova.txt", a);
		while (entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}

		entrada.close();
		Servidor.close();
	}
}