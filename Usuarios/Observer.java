package trabalhoEngenharia.Usuarios;

import trabalhoEngenharia.Itens_biblioteca.Exemplar;

public interface Observer extends Usuario{
	public void notificarReservas(Exemplar exemplar);
}
