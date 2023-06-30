package trabalhoEngenharia.Usuarios;

public interface Usuario {
	public String getId();
	public String getNome();
	public void solicitarEmprestimo();
	public void devolverExemplar();
	public void solicitarReserva();
}
