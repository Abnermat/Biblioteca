package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.command.*;
import trabalhoEngenharia.Usuarios.*;
import trabalhoEngenharia.Itens_biblioteca.*;

public class Console {
	
    private Map<String, Comando> comandos;
    
    public Console() {
        comandos = new HashMap<>();
    }

    public void inicializar() { //adicionar comandos na inicialização
    	
        comandos.put("emp", new RealizarEmprestimoCmd()); //preencher map
    	comandos.put("dev", new RealizarDevolucaoCmd()); 
    	comandos.put("res", new RealizarReservaCmd()); 
    	comandos.put("usu", new VisualizarHistoricoCmd());
    	comandos.put("sai", new SairSistemaCmd());
    	comandos.put("ntf", new VisualizarQtdNotif());
    	comandos.put("obs", new SerObservador());
		
        
    }
    
   public void validarComando(Object... args) { //teoricamente args pode ser tratado como uma matriz
		
	   
        Comando comando = comandos.get((String)args[0]); //tenta pegar na Map o comando solicitado
        
        if (comando != null) {
        		comando.executar(args);
        		return;
        } 
        System.out.println("Comando " + args[0] + " invalido!");
    }
    
    public static void main(String[] args) {
    	
    	Console console = new Console();
        Scanner scanner = new Scanner(System.in);
        BibliotecaFachada fachada = BibliotecaFachada.getInstance();
    	
    	Livro livro1 = new Livro("100", "Engenharia de Software", "Addison Wesley", 6, 2000, "Ian Sommervile");
        Livro livro2 = new Livro("101", "UML – Guia do Usuário", "Campus", 7, 2000, "Grady Booch", "James Rumbaugh", "Ivar Jacobson");
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", 2, 2014, "Steve McConnell");
        Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", 1, 2002, "Robert Martin");
        Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", 1, 1999, "Martin Fowler");
        Livro livro6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", 3, 2014, "Norman Fenton", "James Bieman");
        Livro livro7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison Wesley Professional", 1, 1994,"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides");
        Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", 3, 2003, "Martin Fowler");
  	
    	
    	Usuario usuario1 = new AlunoGraduacao("123", "João da Silva");
    	Usuario usuario2 = new AlunoPos("456", "Luiz Fernando Rodrigues");
    	Usuario usuario3 = new AlunoGraduacao("789", "Pedro Paulo");
    	Usuario usuario4 = new Professor("100", "Carlos Lucena");

    	
    	fachada.addLivro(livro1,2); //add livros
    	fachada.addLivro(livro2,1);
    	fachada.addLivro(livro3,0);
    	
    	fachada.addUsuario(usuario1); //add usuarios
    	fachada.addUsuario(usuario2);
    	fachada.addUsuario(usuario3);
    	fachada.addUsuario(usuario4);
    	
    	console.inicializar();
    	while(true) {
            System.out.print("Digite o comando: ");
            String comando = scanner.nextLine();
            Object[] partes = quebrarString(comando);
            
            console.validarComando(partes);    		
    	}

   
    }
    
    public static String[] quebrarString(String texto) {
        String[] partes = texto.split("\\s");
        return partes;  	
    }

}
