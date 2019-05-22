package filafifo;

import Classes.pessoa;

public class Metodos {
    
    //ADICIONA NA FILA
    public String[] adicionaFila(pessoa[] lista){
        String[] listaResultado = new String[lista.length];
        int j=0;
        for (int i = lista.length-1; i >= 0; i--) {
            listaResultado[j] = lista[i].getNome();
            j++;
        }
        return listaResultado;
    }
    
    //FURA FILA
    public String[] furaFila(pessoa[] lista, int posicao){
        int j = 1;
        String[] listaResultado = new String[lista.length];
        for (int i = 1; i <= lista.length; i++) {
            if (i == posicao) {
                listaResultado[0] = lista[j].getNome();
            }
            else{
                listaResultado[j] = lista[j].getNome();
                j++;
            }
        }
        return listaResultado;
    }
    
    
}
