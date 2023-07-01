package trabalhoEngenharia.Usuarios;

public class AlunoPos implements Usuario {

	private String id;
	private String nome;
	
	
	public AlunoPos(String id, String nome) {
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
	public void solicitarEmprestimo(String codigo, String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolverExemplar(String codigo, String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solicitarReserva(String codigo, String codUsu, String codLivro) {
		// TODO Auto-generated method stub
		
	}

}
