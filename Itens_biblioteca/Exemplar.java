package trabalhoEngenharia.Itens_biblioteca;

public class Exemplar {
//**********************************************
	private static int contador = 1;
	private String id;
	private Livro livro;
	private boolean disponivel;
	
	
	public Exemplar(Livro livro) {
		this.id = gerarId();
		this.setDisponivel(true);
		this.livro = livro;
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
		return disponivel;
	}


	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Livro getLivro() {
		return this.livro;
	}
		
}
