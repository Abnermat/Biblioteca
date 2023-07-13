package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class VisualizarInformacoesLivro implements Comando {

	@Override
	public void executar(Object... args) {
		
		String idLivro = (String)args[1];
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.obterInformacoesLivro(idLivro);
		
	}

}
