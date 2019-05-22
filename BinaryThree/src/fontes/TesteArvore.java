package fontes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class TesteArvore {

	public static void main(String[] args) {

		ArvoreBinaria arvore = new ArvoreBinaria();

		try {
			// arvore.inserir(new Cliente("Helio",84,1.7F));
			// arvore.inserir(new Cliente("MARIA",84,1.7F));
			// arvore.inserir(new Cliente("Zulmira",84,1.7F));
			// arvore.inserir(new Cliente("Marcos",84,1.7F));
			// arvore.inserir(new Cliente("BRUNA",84,1.7F));
			//
			// arvore.inserir(new Cliente("SIMPSON",84,1.7F));
			// arvore.inserir(new Cliente("CARLOS HENRIQUE",84,1.7F));
			// arvore.inserir(new Cliente("MARCELO",84,1.7F));
			// arvore.inserir(new Cliente("ALEXANDRE",84,1.7F));
			// arvore.inserir(new Cliente("NINA 1",84,1.7F));
			// arvore.inserir(new Cliente("PAULO",84,1.7F));
			// arvore.inserir(new Cliente("MATHEUS",84,1.7F));
			// arvore.inserir(new Cliente("SONIA",84,1.7F));
			// arvore.inserir(new Cliente("NINA 2",84,1.7F));
			// arvore.inserir(new Cliente("ANA CLARA",84,1.7F));
			// arvore.inserir(new Cliente("MARILISA",84,1.7F));
			// arvore.inserir(new Cliente("SILVANA",84,1.7F));
			// arvore.inserir(new Cliente("NINA 3",84,1.7F));
			// arvore.inserir(new Cliente("MARCIA",84,1.7F));
			// arvore.inserir(new Cliente("DIANA",84,1.7F));
			// arvore.inserir(new Cliente("JOSE MARIA",84,1.7F));
			// arvore.inserir(new Cliente("CARLOS",84,1.7F));
			// arvore.inserir(new Cliente("VILMA",84,1.7F));
			// arvore.inserir(new Cliente("DEBORA",84,1.7F));
			// arvore.inserir(new Cliente("NINA 4",60,1.6F));
			// arvore.inserir(new Cliente("NINA 5",84,1.7F));
			// arvore.inserir(new Cliente("NICE",84,1.7F));
			// arvore.inserir(new Cliente("PAULA",84,1.7F));
			// arvore.inserir(new Cliente("JOSE",84,1.7F));
			// arvore.inserir(new Cliente("ELIANA",84,1.7F));
			// arvore.inserir(new Cliente("BARNEY",84,1.7F));
			// arvore.inserir(new Cliente("MARIA 9",84,1.7F));
			// arvore.inserir(new Cliente("HUGO",84,1.7F));
			// arvore.inserir(new Cliente("MARIA 8",84,1.7F));
			// arvore.inserir(new Cliente("AILTON",84,1.7F));
			// arvore.inserir(new Cliente("SIMONE",84,1.7F));
			// arvore.inserir(new Cliente("MARIA 7",84,1.7F));
			// arvore.inserir(new Cliente("BELA",84,1.7F));
			// arvore.inserir(new Cliente("RICARDO",84,1.7F));
			// arvore.inserir(new Cliente("MANOEL",84,1.7F));
			// arvore.inserir(new Cliente("JOAQUIM",84,1.7F));
			// arvore.inserir(new Cliente("DIEGO",84,1.7F));
			// arvore.inserir(new Cliente("MAURICIO",84,1.7F));
			// arvore.inserir(new Cliente("CLARISSE",84,1.7F));
			// arvore.inserir(new Cliente("NATALIA",84,1.7F));
			// arvore.inserir(new Cliente("MARIA JOSE",84,1.7F));
			// arvore.inserir(new Cliente("MARISSA",84,1.7F));
			// arvore.inserir(new Cliente("JORGE",84,1.7F));
			// arvore.inserir(new Cliente("VITOR",84,1.7F));
			// arvore.inserir(new Cliente("ARTHUR",84,1.7F));
			// arvore.inserir(new Cliente("MARIO",84,1.7F));
			// arvore.inserir(new Cliente("BARBARA",84,1.7F));

			File file = new File("C:\\Users\\rgome\\Desktop\\teste\\dados.bin");

			if (file.exists()) {
				arvore = descerializa();
			} else 
			{
				Random r = new Random();

				r.ints();

				char valor;

				String resul = "";

				for (int i = 0; i < 1000000; i++) {
					resul = "";
					for (int j = 0; j < 10; j++) {
						valor = (char) (r.nextInt() % 0xFF);

						while (valor < 'A' || valor > 'Z') {
							valor = (char) (r.nextInt() % 0xFF);
						}
						resul += valor;
					}
					arvore.inserir(new Cliente(resul, 84, 1.7F));
				}
				arvore.inserir(new Cliente("HANNAH", 65, 1.6F));
				arvore.inserir(new Cliente("NINA", 70, 1.6F));
				arvore.inserir(new Cliente("RANGEL", 84, 1.7F));
				arvore.inserir(new Cliente("DIEGO", 74, 1.7F));
				serializa(arvore);
			}

			Cliente c = arvore.busca("RANGEL");

			if (c != null) {
				System.out.println(" " + c.getNome() + " - " + c.imc());
			} else {
				System.out.println("N�o achou");

			}
			
			Cliente d = arvore.busca("HANNAH");
			System.out.println(" " + d.getNome() + " - " + d.imc());
			Cliente e = arvore.busca("NINA");
			System.out.println(" " + e.getNome() + " - " + e.imc());
			Cliente r = arvore.busca("RANGEL");
			System.out.println(" " + r.getNome() + " - " + r.imc());
			Cliente t = arvore.busca("DIEGO");
			System.out.println(" " + t.getNome() + " - " + t.imc());

			System.out.println(arvore.conta());
			System.out.println(arvore.niveis());

			// arvore.imprime();
			// arvore.mostra();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	private static void serializa(ArvoreBinaria arvore) throws IOException {

		ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\rgome\\Desktop\\teste\\dados.bin"));
		objstream.writeObject(arvore);
		objstream.close();
	}

	private static ArvoreBinaria descerializa() throws ClassNotFoundException, IOException {

		ObjectInputStream objstream = new ObjectInputStream(new FileInputStream("C:\\Users\\rgome\\Desktop\\teste\\dados.bin"));
		ArvoreBinaria arvore = (ArvoreBinaria) objstream.readObject();
		objstream.close();

		return arvore;
	}

}
