package fontes;

import java.io.Serializable;

public class ArvoreBinaria  implements Serializable {

	private static final long serialVersionUID = 1L;
	private No raiz;   
   
   
    public Cliente busca (String nome) {
    	
    	if (raiz == null) return null;
    	
    	No no = new No(new Cliente(nome,0F,0F));
    	
    	if (raiz.compareTo(no) == 0) return raiz.cliente;    	
   	
    	return busca(no, raiz);    	
    }
    
    private Cliente busca (No noBusca, No noBase) {
    	
        if (noBase == null) return null;
    	
    	if (noBase.compareTo(noBusca) == 0) return noBase.cliente;
    	
    	if (noBase.compareTo(noBusca) > 0) 
    	{
    		return busca (noBusca, noBase.esquerdo);
    	}
    	else 
    	{
    	   return busca (noBusca, noBase.direito);
    	}    	
    }
    
    public void inserir(Cliente cliente) throws Exception {
        if (raiz == null) {
            raiz = new No(cliente);
           // System.out.println("Inseriu na raiz " + cliente.getNome());
        } else {
        	
            No novo = new No(cliente);
            inserir(raiz, novo);
        }
    }

    private void inserir(No arvore, No novo) throws Exception {
        if (novo.cliente.getNome().compareTo(arvore.cliente.getNome()) > 0)  // o novo é maior que o no atual
        {
            if (arvore.direito == null)  // se o direito estiver vago.. ocupa o lugar
            {
                arvore.direito = novo;
              //  System.out.println("Inseriu no lado direito " + novo.cliente.getNome());
            } 
            else 
            {
            	
                inserir(arvore.direito, novo); // se não continua procurando no ramo direito
            }
        } 
        else if (novo.cliente.getNome().compareTo(arvore.cliente.getNome()) < 0) // Se o novo é menor que o atual
        {
            if (arvore.esquerdo == null) 
            {
                arvore.esquerdo = novo; // tem vaga do lado esquerdo. Achou a vaga e ocupa.
               // System.out.println("Inseriu no lado esquerdo " + novo.cliente.getNome());
            } 
            else 
            {            	
                inserir(arvore.esquerdo, novo); // Se não continua pesquisando do lado esquerdo
            }
        } else {
        	throw new Exception("Erro inesperado. Já existe " + novo.cliente.getNome());
        }
    }
    public int conta() {
    	return conta(raiz);
    }
    private int conta(No h) {
        if (h == null) return 0;
        return conta(h.esquerdo) + conta(h.direito) + 1;
    } 
    
    public int niveis() {
    	return niveis(raiz);
    }
    
    private int niveis(No h) {

        int nivelEsquerdo, nivelDireito;
        
        if (h == null) return -1;
        
        nivelEsquerdo = niveis(h.esquerdo);
        nivelDireito = niveis(h.direito);
        if (nivelEsquerdo > nivelDireito) return nivelEsquerdo+1;
        else return nivelDireito+1;
    }
    
    public void imprime() {
    	imprime(raiz);
    }
    private void imprime (No h) { 
        if (h == null) return;
        System.out.println(h.cliente.getNome()); 
        imprime(h.esquerdo);
        imprime(h.direito);
    }
    
    private void printNo(String c, int b) {
        int i;
        for (i = 0; i < b; i++) System.out.print("\t");
        System.out.println(c+"");
    }
    
    public void mostra() {
    	mostra(raiz,0);
    }
    private void mostra(No x, int b) {
        if (x == null) {
            printNo("(Vago)", b);
            return;
        }
        mostra(x.direito, b+1);    
        printNo(x.cliente.getNome(), b);
        mostra(x.esquerdo, b+1);    
    }
}
