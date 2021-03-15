package model;

public class Cliente extends Pessoa{

	String nome;
	String identificacao;
	static String tipo = "002";
	String ramoAtividade;
	
	public Cliente (String nome, String identificacao, String ramoAtividade) {
		this.nome = nome;
		this.identificacao = identificacao;
		this.ramoAtividade = ramoAtividade;
		
	}
	
	public void setRamoAtividade (String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
		
	}
	
	public void setNome (String nome) {
		this.nome = nome;
		
	}
	
	public void setIdentificacao (String identificacao) {
		this.identificacao = identificacao;
		
	}
	
	public String getNome() {
		return this.nome;
		
	}
	
	public String getRamoAtividade() {
		return this.ramoAtividade;
		
	}
	
	public String getIdentificacao() {
		return this.identificacao;
		
	}

}
