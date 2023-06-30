package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.command.*;

public class Console {
	
    private Map<String, Comando> comandos;

    public Console() {
        comandos = new HashMap<>();
    }

    public void inicializar(String codigo, Comando comando) { //adicionar comandos na inicialização
        
    	comandos.put("emp", new RealizarEmprestimoCmd()); //listar comandos
    	comandos.put(codigo, comando); //listar comandos
    	comandos.put(codigo, comando); //listar comandos
        
        
        //... usuarios;
        BibliotecaFachada fachada = BibliotecaFachada.getInstance();
    }
    
    public void executarComando(String codigo, String... args) { //teoricamente args pode ser tratado como uma matriz
    	
        Comando comando = this.comandos.get(codigo); //tenta pegar na Map o comando solicitado
        
        if (comando != null) {
            comando.executar(args);
        } else {
            System.out.println("Comando " + codigo + " não encontrado!");
        }
    }
    
    public static void main(String[] args) {
    	
    }
}
