package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Exemplar;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.*;


public class RealizarDevolucaoCmd implements Comando{
	
	@Override
	public void executar(Object... args) {
		
		if(args.length != 3) {
			System.out.println("Erro na quantidade de parametros!");
			return;
		}
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		String idUsuario = (String)args[1];
		String idLivro = (String)args[2];
		
		fachada.realizarDevolucao(idUsuario, idLivro);
	}
	
}
