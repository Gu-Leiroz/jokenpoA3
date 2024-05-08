package jokenpo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	

	    private static final int PORT = 7777;

	    public static void main(String[] args) {
	        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            System.out.println("Iniciando Servidor");

	            Socket jogador1Socket = serverSocket.accept();
	            System.out.println("Jogador 1 conectado.");

	            Socket jogador2Socket = serverSocket.accept();
	            System.out.println("Jogador 2 conectado.");

	            BufferedReader jogador1Input = new BufferedReader(new InputStreamReader(jogador1Socket.getInputStream()));
	            PrintWriter jogador1Output = new PrintWriter(jogador1Socket.getOutputStream(), true);

	            BufferedReader jogador2Input = new BufferedReader(new InputStreamReader(jogador2Socket.getInputStream()));
	            PrintWriter jogador2Output = new PrintWriter(jogador2Socket.getOutputStream(), true);

	            jogador1Output.println("Você é o jogador 1.");
	            jogador2Output.println("Você é o jogador 2.");

	            while (true) {
	                String jogador1escolha = jogador1Input.readLine();
	                String jogador2escolha = jogador2Input.readLine();

	                if (jogador1escolha == null || jogador2escolha == null) {
	                    break;
	                }

	                String resultado = defineVencedor(jogador1escolha, jogador2escolha);
	                jogador1Output.println("Resultado: " + resultado);
	                jogador2Output.println("Resultado: " + resultado);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static String defineVencedor(String escolha1, String escolha2) {
	        if (escolha1.equals(escolha2)) {
	            return "Empate!";
	        } else if ((escolha1.equals("pedra") && escolha2.equals("tesoura")) ||
	                   (escolha1.equals("tesoura") && escolha2.equals("papel")) ||
	                   (escolha1.equals("papel") && escolha2.equals("pedra"))) {
	            return "Jogador 1 venceu!";
	        } else {
	            return "Jogador 2 venceu!";
	        }
	    }
	}


