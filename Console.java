package trabalhoEngenharia;

import java.util.*;
import trabalhoEngenharia.command.*;
import trabalhoEngenharia.Usuarios.*;
import trabalhoEngenharia.Itens_biblioteca.*;

public class Console {
	
    private Map<String, Comando> comandos;
    BibliotecaFachada fachada = BibliotecaFachada.getInstance();
    
    
    
    public Console() {
        comandos = new HashMap<>();
    }

    public void inicializar() { //adicionar comandos na inicialização
        
    	comandos.put("emp", new RealizarEmprestimoCmd()); //preencher map
    	comandos.put("dev", new RealizarDevolucaoCmd()); 
    	comandos.put("res", new RealizarReservaCmd()); 
        
    }
    
   public void validarComando(Object... args) { //teoricamente args pode ser tratado como uma matriz
	   
        Comando comando = comandos.get((String)args[0]); //tenta pegar na Map o comando solicitado
        
        if (comando != null) {
        	System.out.println("O comando existe e pode ser executado!");
        	if(args.length < 2) {
        		System.out.println("Saindo do sistema...");
        		return;
        	}
        	if(this.fachada.constamNaLista(args)) {
        		comando.executar(fachada, args);
        		return;
        	}
        } 
        System.out.println("Comando " + args[0] + " invalido!");
    }
    
    public static void main(String[] args) {
    	
    	Console console = new Console();
        Scanner scanner = new Scanner(System.in);
    	
    	Livro livro1 = new Livro("100", "Engenharia de Software", "Addison Wesley", 6, 2000, "Ian Sommervile");
        Livro livro2 = new Livro("101", "UML – Guia do Usuário", "Campus", 7, 2000, "Grady Booch", "James Rumbaugh", "Ivar Jacobson");
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", 2, 2014, "Steve McConnell");
        Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", 1, 2002, "Robert Martin");
        Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", 1, 1999, "Martin Fowler");
        Livro livro6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", 3, 2014, "Norman Fenton", "James Bieman");
        Livro livro7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison Wesley Professional", 1, 1994,"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides");
        Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", 3, 2003, "Martin Fowler");
  	
        Exemplar exemplar1 = new Exemplar();
        Exemplar exemplar2 = new Exemplar();
        Exemplar exemplar3 = new Exemplar();
        Exemplar exemplar4 = new Exemplar();
        Exemplar exemplar5 = new Exemplar();
        Exemplar exemplar6 = new Exemplar();
        Exemplar exemplar7 = new Exemplar();
        Exemplar exemplar8 = new Exemplar();
        Exemplar exemplar9 = new Exemplar();
        
    	        
        livro1.addExemplar(exemplar1);
        livro1.addExemplar(exemplar2);
        livro2.addExemplar(exemplar3);
        livro3.addExemplar(exemplar4);
        livro4.addExemplar(exemplar5);
        livro5.addExemplar(exemplar6);
        livro5.addExemplar(exemplar7);
        livro7.addExemplar(exemplar8);
        livro7.addExemplar(exemplar9);
    	
    	Usuario usuario1 = new AlunoGraduacao("123", "João da Silva");
    	Usuario usuario2 = new AlunoPos("456", "Luiz Fernando Rodrigues");
    	Usuario usuario3 = new AlunoGraduacao("100", "Carlos Lucena");
    	
    	console.fachada.addLivro(livro1); //add livros
    	console.fachada.addLivro(livro2);
    	console.fachada.addLivro(livro3);
    	
    	console.fachada.addUsuario(usuario1);
    	console.fachada.addUsuario(usuario2);
    	console.fachada.addUsuario(usuario3);
    	
    	console.inicializar();
        System.out.print("Digite o comando: ");
        String comando = scanner.nextLine();
        Object[] partes = quebrarString(comando);
        
        console.validarComando(partes);
        
        System.out.println(Arrays.toString(partes));
   
    }
    
    public static String[] quebrarString(String texto) {
        String[] partes = texto.split("\\s");
        return partes;  	
    }

}
