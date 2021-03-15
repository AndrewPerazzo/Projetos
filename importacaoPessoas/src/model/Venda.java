package model;

public class Venda {
	
	static String tipo = "003";
	int idVenda;
	int idItem;
	int qtdeItem;
	double precoItem;
	String nomeVendedor;
	
	public Venda(int idVenda, int idItem, int qtdeItem, double precoItem, String nomeVendedor) {
		
		this.idVenda = idVenda;
		this.idItem = idItem;
		this.qtdeItem = qtdeItem;
		this.precoItem = precoItem;
		this.nomeVendedor = nomeVendedor;
		
	}
	
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public void setIdItem(int idItem) {
		this.idVenda = idItem;
	}
	
	public void setQtdeItem(int qtdeItem) {
		this.qtdeItem = qtdeItem;
	}
	
	public void setPrecoItem(double precoItem) {
		this.precoItem = precoItem;
	}
			
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	public String getNomeVendedor() {
		return this.nomeVendedor;
	}
	
	public int getIdItem() {
		return this.idItem;
	}
	
	public int getIdVenda() {
		return this.idVenda;
	}
	
	public int getQtdeItem() {
		return this.qtdeItem;
	}
	
	public double getPrecoItem() {
		return this.precoItem;
	}
	

}
