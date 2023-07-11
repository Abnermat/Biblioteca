package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.*;

public class VisualizarHistoricoCmd implements Comando{

	@Override
	public void executar(Object... args) {
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		String idUsuario = (String)args[1];
		
		fachada.visulizarHistorico(idUsuario);
		
	}

}
