package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Usuarios.*;


public class RealizarDevolucaoCmd implements Comando{
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		System.out.println("Livro devolvido!!!");
	}
}
