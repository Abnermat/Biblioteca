package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Exemplar;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.*;


public class RealizarDevolucaoCmd implements Comando{
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
			
			Usuario usuario = fachada.pesquisarUsuario((String)args[1]); //procura ambos no sistema
			Livro livro = fachada.pesquisarLivro((String)args[2]);
			
			if(usuario!=null) {
				if(livro!=null) {
					for(Emprestimo emp: usuario.getEmprestimos()) {      //verifica se há debito
						if(emp.getExemplar().getId().equals(livro.getId())) {
							emp.getExemplar().setDisponivel(true);
							emp.setDataDevolucao();
							emp.setEmAndamento(false);
							System.out.println("O livro " + livro.getTitulo() + " foi devolvido com sucesso!");
							return;
						}
					}	
					System.out.println("Não houve emprestimo do livro " + livro.getTitulo() + "!");
				}
				System.out.println("Livro inexistente!");
				return;
			}		
			System.out.println("Usuario inexistente!");
	}
	
}
