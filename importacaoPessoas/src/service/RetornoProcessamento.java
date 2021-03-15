package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RetornoProcessamento {
	static String caminhoRetorno = System.getProperty("user.dir") + "\\dados\\out";
	public void processa(String nomeArquivo, int qtdeClientes, int qtdeVendedores, int idVendaMaior, String nomeVendedor) throws IOException {
		String novoArquivo = nomeArquivo.replace("in", "out").concat(".proc");
		if(!new File(caminhoRetorno).exists()) {
			new File(caminhoRetorno).mkdir();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(novoArquivo));
		String texto = "Quantidade de clientes: " + String.valueOf(qtdeClientes);
	    writer.write(texto);
	    writer.newLine();
	    texto = "Quantidade de vendedores: " + String.valueOf(qtdeVendedores);
	    writer.write(texto);
	    writer.newLine();
	    texto = "Id Venda de valor mais alto: " + String.valueOf(idVendaMaior);
	    writer.write(texto);
	    writer.newLine();
	    texto = "Vendedor com menor volume de vendas: " +nomeVendedor;
	    writer.write(texto);
	    writer.close();
	}
	

}
