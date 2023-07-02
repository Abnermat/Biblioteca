package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public interface Comando {
	public void executar(BibliotecaFachada fachada, Object... args); 
}
