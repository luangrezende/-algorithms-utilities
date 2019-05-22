package filafifo;

import Classes.pessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FilaFiFo {
    public static void main(String[] args) {
        Metodos mtd = new Metodos();
        
        ArrayList<pessoa> user = new ArrayList<>();
        
        
        
        System.out.println(user[0].getNome());
        
        //JOptionPane.showMessageDialog(null, mtd.adicionaFila(user), "Monta fila", 1);
       // JOptionPane.showMessageDialog(null, mtd.furaFila(user, 2), "FuraFila", 1);
    }
    
}
