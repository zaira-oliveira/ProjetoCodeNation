package br.com.mycompany.teste;

import br.com.mycompany.modelo.Criptografia;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Desafio Codenation: Criptografia de Júlio César ");
        System.out.println("--------------------------------------------------------------");

        System.out.println("[1] - Criptografar");
        System.out.println("[2] - Decifrar");
        System.out.println("[3] - Sair");
        System.out.print("Resposta: ");
        int opcao = Integer.parseInt(sc.nextLine());
        Criptografia.executa(opcao);

    }

}
