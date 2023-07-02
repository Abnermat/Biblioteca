package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarReservaCmd implements Comando{

	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		fachada.realizarReserva ((String) args[1], (String) args[2]);
		
	}

}
