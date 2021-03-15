package model;

public class Vendedor extends Pessoa {
	
	String nome;
	String identificacao;
	static String tipo = "001";
	double salario;
	double vendas;
	
	public Vendedor(String nome, String identificacao,  double salario) {
		this.nome = nome;
		this.identificacao = identificacao;
		this.salario = salario;
			
	}
	
	
	public Vendedor(String nome,  double vendas) {
		this.nome = nome;
		this.vendas = vendas;
			
	}
	
	
	public void setNome (String nome) {
		this.nome = nome;
		
	}
	
	public void setIdentificacao (String identificacao) {
		this.identificacao = identificacao;
		
	}
	
	
	public void setSalario(double salario) {
		this.salario = salario;
		
	}
	
	public void setVenda(double vendas) {
		this.vendas = vendas;
		
	}
	
	

	public String getNome() {
		return this.nome;
		
	}
	
	public String getIdentificacao() {
		return this.identificacao;
		
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public double getVendas() {
		return this.vendas;
	}


}

