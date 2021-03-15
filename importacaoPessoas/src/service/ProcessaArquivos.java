package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import model.Venda;
import model.Vendedor;


public class ProcessaArquivos {
	
	public void executeListaArquivos() {
		
		
		ListaArquivos lista = new ListaArquivos();
		
		
		File[] arquivos = lista.verificaListaArquivos();
		if(arquivos.length < 1) {
			System.out.println("Coloque arquivos na pasta dados\\in");
			System.exit(0);
		}
		for (File arquivo : arquivos ) {
			int quantidadeVendedores = 0;
			int quantidadeClientes = 0;
			int idVendaMaisAlta = 0;
			String nomeVendedor = "";
			double menorValor = 0.00;
			double maiorValor = 0.00;
			List<Vendedor> listaVendas = new ArrayList<Vendedor>();
			List<Venda> listaVenda = new ArrayList<Venda>();
			boolean arquivoValido = arquivo.isFile() && arquivo.getName().endsWith(".dat");
			String caminho = "";
			
			if(arquivoValido){
				caminho = arquivo.getPath();
				FileInputStream inputStream = null;
				Scanner sc = null;
				try {
				    try {
						inputStream = new FileInputStream(caminho);
					} catch (FileNotFoundException e) {
						System.out.println("Arquivo nao encontrado");
					}
				    sc = new Scanner(inputStream, "UTF-8");
				    while (sc.hasNextLine()) {
				        String line = sc.nextLine();
				        String[] separated = line.split(";");
				        if (separated[0].equals("001")) {
				        	//To Do - Se apresentar problemas de vendedores duplicados, utilizar de lista para nao contabilizar registros ja existentes no mesmo arquivo.
				         	quantidadeVendedores++;
				        }
				        if (separated[0].equals("002")) {
				        	//To Do - Se apresentar problemas de clientes duplicados, utilizar de lista para nao contabilizar registros ja existentes no mesmo arquivo.
				        	quantidadeClientes++;
				        }
				        if (separated[0].equals("003")) {
				        	boolean encontrou = false;
				        	Venda venda = new Venda(Integer.parseInt(separated[1]),Integer.parseInt(separated[2]),  Integer.parseInt(separated[3]), Double.parseDouble(separated[4]), separated[5]);
				        	listaVenda.add(venda);
				        	if(!listaVendas.isEmpty()){
				        		for (Vendedor v:listaVendas) {
				        			if(v.getNome().equals(venda.getNomeVendedor())) {
				        				v.setVenda(v.getVendas() + venda.getQtdeItem() * venda.getPrecoItem());
				        				encontrou =true;
				        				break;
				        			}
				        			
				        		}
				        		if(!encontrou)
				        			listaVendas.add(new Vendedor(venda.getNomeVendedor(), venda.getPrecoItem()*venda.getQtdeItem()));
				        		
				        	}else listaVendas.add(new Vendedor(venda.getNomeVendedor(), venda.getPrecoItem()*venda.getQtdeItem()));
				        	
				        }
				    }
				    boolean primeiraVez = true;
				    for(Vendedor v:listaVendas) {
				    	
				    	if(v.getVendas() < menorValor || primeiraVez)
				    		menorValor = v.getVendas();
				    		nomeVendedor = v.getNome();
				    		primeiraVez = false;
				    	}
				    
				    primeiraVez = true;
				    for(Venda v:listaVenda) {
				    	
				    	if(v.getPrecoItem() * v.getQtdeItem() > maiorValor || primeiraVez)
				    		maiorValor = v.getPrecoItem() * v.getQtdeItem();
				    	    idVendaMaisAlta =  v.getIdVenda();                                            
				    		primeiraVez = false;
				    	}
				    
				    if (sc.ioException() != null) {
				        throw sc.ioException();
				    }
				} catch (IOException e) {
					System.out.println("Falha ao manipular arquivo");
				} finally {
				    if (inputStream != null) {
				        try {
							inputStream.close();
						} catch (IOException e) {
							System.out.println("Falha ao fechar o stream");
						}
				    }
				    if (sc != null) {
				        sc.close();
				    }
				}
			
			}
			RetornoProcessamento retorno = new RetornoProcessamento();
			if(arquivoValido) {
				try {
					retorno.processa(caminho, quantidadeClientes, quantidadeVendedores, idVendaMaisAlta, nomeVendedor);
				} catch (IOException e) {
					System.out.println("Falha ao gravar arquivo");
				}
			}
			//TODO - Se fosse um processo automatizado, aqui estaria a logica de delete ou de mover o arquivo original para backup.
		}
		
		
		
		
		
		
	}

}
