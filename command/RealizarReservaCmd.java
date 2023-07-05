package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarReservaCmd implements Comando{

	@Override
	public void executar(Object... args) {
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.realizarReserva(null, null, null);
		
	}

}
