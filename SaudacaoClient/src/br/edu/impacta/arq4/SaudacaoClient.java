package br.edu.impacta.arq4;

import static javax.swing.JOptionPane.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class SaudacaoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String nome = showInputDialog("Qual é o seu nome?");
		Socket soc = new Socket("172.18.34.30" , 58888);
		InputStream is = soc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = soc.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println(nome);
		pw.flush();
		String resposta = br.readLine();
		showMessageDialog(null, "Resposta do servidor: " + resposta);
		pw.close();
		br.close();
		soc.close();
		
	}

}
