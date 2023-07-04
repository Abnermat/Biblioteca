package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class SairSistemaCmd implements Comando {

	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		System.out.println("programa encerrado!");
		System.exit(0);
		
	}

}
