package trabalhoEngenharia.Itens_biblioteca;

import java.time.LocalDate;

import trabalhoEngenharia.Usuarios.Usuario;

public class Emprestimo {

	private Usuario usuario;
	private Exemplar exemplar;
	private LocalDate dataEmprestimo, dataDevolucao;
	private boolean emAndamento;
	 
	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.setUsuario(usuario);
		this.setExemplar(exemplar);
		this.setEmAndamento(true);
	}


	public Emprestimo getEmprestimo() {
		if(usuario.isDevedor()) {
			System.out.println("Usuario em atraso de devolução!");
			return null;
		}
		this.setDataEmprestimo(LocalDate.now());
		this.dataDevolucao = this.calcularDataDevolucao();
		this.exemplar.setDisponivel(false);
		this.emAndamento = true;
		return this;
	}
	
	public LocalDate calcularDataDevolucao() {
		int limiteUsuario = this.usuario.getLimiteDiasEmprestimo();
		return LocalDate.now().plusDays(limiteUsuario); //pega data atual e devolve uma data posterior
	}
	
	/*public boolean emAtraso() {
		
		if(this.usuario.getEmprestimos().isEmpty())
			return false;
		
		int diaAtual = LocalDate.now().getDayOfYear();
		int diaDevolucao = this.dataDevolucao.getDayOfYear(); /para novo emprestimo, esse this não existe
		
		if ((diaAtual - diaDevolucao)>0){		
			return true;
		}
		return false;
	}*/
	
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

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}
	
	public void setDataDevolucao() {
		this.dataDevolucao = LocalDate.now();
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	
	
}
