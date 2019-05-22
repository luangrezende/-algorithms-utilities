package test;

import java.util.Arrays;

public class App 
{
    // Variaveis globais
    public static int NumeroVezesRodadas;
    public static int primeiroInicio;
    public static String nomeBuscado = "Luan";
    public static String[] nomesLista = {"Jessica", "Marcos", "Caio", "João", "Hedgar", "Thiago", "Wendryo", "Maria", "Jussara", 
    "Tereza", "Janaina", "Thaina", "Pedro", "Ana", "Luan", "Lucas", "Andre", "Alex", "Hyra", "Enzo" };

    public static void main(String[] args)
    {
        Arrays.sort(nomesLista);
        BuscaBinaria(primeiroInicio, nomesLista.length);
    }

    // Efetua a busca
    public static void BuscaBinaria(int inicio, int fim){
        NumeroVezesRodadas++;
        int meio = (inicio + fim) / 2;

        if(nomeBuscado == nomesLista[meio]){
            System.out.println("Nome encontrado: " + nomesLista[meio] + "\n" + "Posição: " + meio + "\n" + "Vezes rodadas: " + NumeroVezesRodadas);
        }
        else{
            if(nomeBuscado.compareTo(nomesLista[meio]) > 0){
                BuscaBinaria(meio, fim);
            }
            if(nomeBuscado.compareTo(nomesLista[meio]) < 0){
                BuscaBinaria(inicio, meio);
            }
        }
    }

}
