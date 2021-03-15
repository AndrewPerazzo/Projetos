package service;

import java.io.File;


public class ListaArquivos {
	
	static String caminhoEntrada = System.getProperty("user.dir") + "\\dados\\in";
	public File[] verificaListaArquivos(){
		if(!new File(caminhoEntrada).exists()) {
			new File(caminhoEntrada).mkdirs();
		}
		
		File dir = new File(caminhoEntrada);
		
		return dir.listFiles();
		
	} 
	
	

}
