package trabalhoEngenharia.Itens_biblioteca;

import java.time.LocalDate;

import trabalhoEngenharia.Usuarios.Usuario;

public class Emprestimo {

	private Usuario usuario;
	private Exemplar exemplar;
	private LocalDate dataEmprestimo, dataDevolucao;
	 
	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.setUsuario(usuario);
		this.setExemplar(exemplar);
	}

	public Emprestimo getEmprestimo() {
		if(this.calcularAtraso() > 0) {
			System.out.println("Usuario em atraso de devolução!");
			return null;
		}
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolucao = this.calcularDataDevolucao();
		this.exemplar.setDisponivel(false);
		return this;
	}
	
	public LocalDate calcularDataDevolucao() {
		int limiteUsuario = this.usuario.getLimiteDiasEmprestimo();
		
		return LocalDate.now().plusDays(limiteUsuario);
	}
	
	public int calcularAtraso() {
		int diaAtual = LocalDate.now().getDayOfYear();
		int diaDevolucao = this.dataDevolucao.getDayOfYear();
		
		return diaAtual - diaDevolucao;			
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	
	
	
}
