package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarReservaCmd implements Comando{

	@Override
	public void executar(Object... args) {
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		String idUsuario = (String)args[1];
		String idLivro = (String)args[2];
		
		fachada.realizarReserva(idUsuario, idLivro);
		
	}

}
