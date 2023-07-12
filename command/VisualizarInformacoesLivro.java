package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class VisualizarInformacoesLivro implements Comando {

	@Override
	public void executar(Object... args) {
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		String idLivro = (String)args[1];
		fachada.obterInformacoesLivro(idLivro);
		
	}

}
