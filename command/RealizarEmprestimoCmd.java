package trabalhoEngenharia.command;

import java.time.LocalDate;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.*;
import trabalhoEngenharia.Usuarios.*;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		Usuario usuario = fachada.pesquisarUsuario((String)args[1]);
		Livro livro = fachada.pesquisarLivro((String)args[2]);
		
		if(livro.getExemplares().isEmpty()) {
			System.out.println("Livro ainda sem exemplares!");
			return;
		}
		
		for(Exemplar e: livro.getExemplares()) {
			if(e.isDisponivel()) {
				Emprestimo emprestimo = new Emprestimo(usuario, e).getEmprestimo();
				if(emprestimo != null) {
					
					usuario.getEmprestimos().add(emprestimo);
					System.out.println("Usuario: " + usuario.getNome());
					System.out.println("Livro: " + livro.getTitulo());
					System.out.println("Emprestimo realizado!");
					System.out.println("Devolução: " + emprestimo.calcularDataDevolucao());
					return;
				}
				System.out.println("Usuario em débito!");
				return;
			}
		}
		System.out.println("Não há exemplares disponiveis!");
		
		
	}

}
