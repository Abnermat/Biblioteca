package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Emprestimo;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.*;

public class VisualizarHistoricoCmd implements Comando{

	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		Usuario usuario = fachada.pesquisarUsuario((String)args[1]);
		if(usuario!=null) {
			System.out.println("Historico de emprestimos do usuario " + usuario.getNome() + ":");
			if(usuario.getEmprestimos().isEmpty() == false) {
				
				for(Emprestimo emp: usuario.getEmprestimos()) {
					if(emp.getUsuario().getId().equals(usuario.getId())) {
						
							System.out.println("------------------------------");
							Livro l = fachada.pesquisarLivro(emp.getExemplar().getId());
							System.out.println("Exemplar: " + l.getTitulo());
							System.out.println("Emprestimo: " + emp.getDataEmprestimo());
							System.out.println("Devolução: " + emp.calcularDataDevolucao());
							
							System.out.print("Status: ");
							if(emp.isEmAndamento()&&emp.emAtraso()) {
								System.out.println("Em andamento (atraso)");
							}else if(emp.isEmAndamento()) {
								System.out.println("Em andamento");
							}else {
								System.out.println("Finalizado");
							}
							System.out.println("------------------------------");				
						
					}
				}
				return;
			}			
			System.out.println("Usuario não tem emprestimos!");
			return;
		}

		System.out.println("Usuario inexistente!");	
		
	}

}
