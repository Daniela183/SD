/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Daniela e Vitor
 */
public class Facilitador {

    public static String Read(String Caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não foi encontrado!");
            return "";
        }
    }

    public static boolean Write(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException c) {
            System.out.println(c.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Facilitador facilitador = new Facilitador();
        
        String respostas = Facilitador.Read("C:/Users/gearl/Desktop/sistemaD/resposta.txt");
        String gabarito = Facilitador.Read("C:/Users/gearl/Desktop/sistemaD/gabarito.txt");
        
        char[] resposta = respostas.toCharArray();
        char[] gabarits = gabarito.toCharArray();
        
        for (int i = 0; i <= respostas.length() - 1; i++) {

            if (resposta[i] == gabarits[i]) {
                /*fora do for*/ System.out.println("Acertou \n");
                //variavel para guarda os acertos
            }else {
                System.out.println("Errou \n");
                //variavel para guarda os acertos
            }

        }
        
        System.out.println(facilitador.Read("C:/Users/gearl/Desktop/sistemaD/resposta.txt"));
        System.out.println(Facilitador.Read("C:/Users/gearl/Desktop/sistemaD/gabarito.txt"));
    }
}