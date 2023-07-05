package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class SairSistemaCmd implements Comando {

	@Override
	public void executar(Object... args) {
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.sairDoSistema();
		
	}

}
