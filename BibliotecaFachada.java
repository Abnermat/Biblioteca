package trabalhoEngenharia;

import java.util.List;

import trabalhoEngenharia.Usuarios.Usuario;
import trabalhoEngenharia.Itens_biblioteca.Livro;

public class BibliotecaFachada {

	private static BibliotecaFachada fachada;
	
	private List<Usuario> listaDeUsuarios;
	private List<Livro> listaDeExemplares;
	
	public static BibliotecaFachada getInstance() { //singleton
		if(fachada == null) {
			fachada = new BibliotecaFachada();
		}
		return fachada;
	}
}
