package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarReservaCmd implements Comando{

	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		System.out.println("Reserva realizada!!!");
		
	}

}
