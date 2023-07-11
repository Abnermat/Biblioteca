package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.Itens_biblioteca.Livro;

public interface Observer extends Usuario{
	public void notificarSobreReservas(Livro livro);
}
