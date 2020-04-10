package br.com.mycompany.modelo;

import br.com.mycompany.enums.Letras;
import java.util.Scanner;

public class Criptografia {

    public static void executa(int resposta) {
        Scanner sc = new Scanner(System.in);
        if (resposta == 1) {
            String texto = "";
            System.out.print("Digite o texto que deseja Criptografar: ");
            String texto_recebido = sc.nextLine();
            System.out.print("Digite um determinado número de casas: ");
            int numero_casas = Integer.parseInt(sc.nextLine());

            for (int n = 0; n <= texto_recebido.length() - 1; n++) {
                String letra = "" + texto_recebido.charAt(n);
                if (validaTexto(letra)) {
                    String letraCriptografa = Letras.getLetraByValor(Letras.valueOf(letra.toUpperCase()).getValor() + numero_casas).toString().toLowerCase();
                    texto += letraCriptografa;
                } else {
                    texto += letra;
                }
            }
            System.out.println(texto);

        } else if (resposta == 2) {
            String texto = "";
            System.out.print("Digite o texto que deseja Decifrar: ");
            String texto_recebido = sc.nextLine();
            System.out.print("Digite um determinado número de casas: ");
            int numero_casas = Integer.parseInt(sc.nextLine());

            for (int n = 0; n <= texto_recebido.length() - 1; n++) {
                String letra = "" + texto_recebido.charAt(n);
                if (validaTexto(letra)) {
                    String letraCriptografa = Letras.getLetraByValor(Letras.valueOf(letra.toUpperCase()).getValor() - numero_casas).toString().toLowerCase();
                    texto += letraCriptografa;
                } else {
                    texto += letra;
                }
            }
            System.out.println(texto);

        } else if (resposta == 3) {
            System.exit(0);

        } else {
            System.out.println("Valor inválido. Tente novamente!");
        }
    }

    public static boolean validaTexto(String letra) {
        boolean valida = true;
        if (letra.matches("[0-9]")) {
            valida = false;
        }
        if (letra.matches("[\\.]")) {
            valida = false;
        }
        if (letra.matches("[\\s]")) {
            valida = false;
        }
        return valida;
    }

}
