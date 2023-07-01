package trabalhoEngenharia.Usuarios;

public interface Usuario {
	public String getId();
	public String getNome();
	public void solicitarEmprestimo(String codigo, String codUsu, String codLivro);
	public void devolverExemplar(String codigo, String codUsu, String codLivro);
	public void solicitarReserva(String codigo, String codUsu, String codLivro);
}
