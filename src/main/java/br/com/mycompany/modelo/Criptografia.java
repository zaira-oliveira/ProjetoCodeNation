package br.com.mycompany.modelo;

import br.com.mycompany.enums.Letras;
import java.security.*;
import java.util.Scanner;

public class Criptografia {

    public static void executa(int resposta) throws NoSuchAlgorithmException {
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
            System.out.println("SHA1:" + SHA1(texto));

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
            System.out.println("SHA1:" + SHA1(texto));

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

    public static String SHA1(String input) throws NoSuchAlgorithmException {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            mDigest.update(input.getBytes());
            
            byte[] result = mDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : result) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
    }
}
