package fontes;

import java.io.Serializable;

public class No implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Cliente cliente;
    public No direito;
    public No esquerdo;

    public No(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int compareTo(No no) {
    	return this.cliente.getNome().compareTo(no.cliente.getNome());
    }
   
}
