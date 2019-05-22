package fontes;

import java.io.Serializable;

public class Cliente  implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private String nome;
  private float peso;
  private float altura;
  
  public Cliente (String nome, float peso, float altura) {
	  this.nome = nome;
	  this.peso = peso;
	  this.altura = altura;
  }
  
  public String getNome() {
	  return nome;
  }
  
  public int compareTo(String nome) {
	  return this.nome.compareTo(nome);
  }
  
  public float imc() {
	  return peso / (altura*altura);
  }
  
}
