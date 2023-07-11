package trabalhoEngenharia.Itens_biblioteca;

public class Exemplar {
//**********************************************
	private static int contador = 1;
	private String id;
	private Livro livro;
	private boolean disponivel;
  	private Emprestimo emprestimo;
	
	
	public Exemplar(String id,Livro livro) {
    		this.id = id;
		this.setDisponivel(true);
		this.livro = livro;
		livro.addExemplar(this);
	}

	private String gerarId() {
		String id = String.format("%02d", contador);
		contador++;
		return id;
	}

	public String getId() {
		return id;
	}
	
	public String getIdExemplar() {
		return this.id;
	}
	
	public boolean getDisponivel() {
		return disponivel;
	}
	
	
	public void disponibilizar() {
		disponivel = true;
	}

	public void emprestar(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
		disponivel = false;
	}
	
	public Livro getLivro() {
		return livro;
	}
  
		
}
