package trabalhoEngenharia.Usuarios;

public class Professor implements Usuario {

	private String id;
	private String nome;
	
	
	public Professor(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public void solicitarEmprestimo(String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolverExemplar(String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solicitarReserva(String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

}
