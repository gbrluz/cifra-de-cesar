package com.example.cifradecesar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CifraDeCesarApplication {


    public static void main(String[] args) {

        SpringApplication.run(CifraDeCesarApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        char[] letras = alfabeto.toCharArray();

        System.out.println("Insira a string desejada: ");
        char[] palavra = scanner.nextLine().toLowerCase().replaceAll("\\p{Punct}", "")
                .replaceAll("á|à|â|ã|ä", "a")
                .replaceAll("é|è|ê|ë", "e").replaceAll("ì|í|î|ï", "i")
                .replaceAll("ò|ó|ô|õ|ö", "o").replaceAll("ù|ú|û|ü", "u")
                .toCharArray();
        System.out.println("Insira a chave desejada: ");
        int chave = scanner.nextInt();

        int tam = palavra.length;
        int az = letras.length;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < az; j++) {
                if (palavra[i] == letras[j]) {
                    while ((chave+j)>25){
                        chave -= 26;
                    }
                    while ((chave+j)<0){
                        chave += 26;
                    }
                    palavra[i] = letras[j + chave];
                    break;
                }
            }
        }
        System.out.print("A frase codificada é: ");
        System.out.println(palavra);
    }
}
