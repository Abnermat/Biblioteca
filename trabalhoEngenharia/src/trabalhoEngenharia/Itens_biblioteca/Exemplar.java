package trabalhoEngenharia.Itens_biblioteca;


public class Exemplar {
//**********************************************
	private static int contador = 1;
	private String id;
	private Livro livro;
	private boolean disponivel;
	
	public Exemplar(Livro livro) {
		this.id = gerarId();
		this.livro = livro;
		this.disponibilizar();
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

	public boolean isDisponivel() {
		return this.disponivel; 
	}
	
	public Livro getLivro() {
		return this.livro;
	} 
	public void disponibilizar() {
		this.disponivel = true;
	}
	public void indisponibilizar() {
		this.disponivel = false;
	}
	public String minhaDisponibilidade() {
		if(this.disponivel == true) {
			return "disponivel";
		}
		return "indisponivel";
		
	}
		
}
