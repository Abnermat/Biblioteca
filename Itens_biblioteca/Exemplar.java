package trabalhoEngenharia.Itens_biblioteca;

import java.util.*;

import trabalhoEngenharia.Usuarios.Observer;


public class Exemplar {
//**********************************************
	private static int contador = 1;
	private String id;
	private Livro livro;
	private boolean emprestado;
	private boolean reservado;
	
	public Exemplar(Livro livro) {
		this.id = gerarId();
		this.livro = livro;
	}

    private String gerarId() {
        String id = String.format("%02d", contador);
        contador++;
        return id;
    }

    public String getId() {
        return id;
    }

	public String getIdExemplar() {
		return this.id;
	}

	public boolean isEmprestado() {
		return this.emprestado; 
	}
	public boolean isReservado() {
		return this.reservado; 
	}


	public void setEmprestado(boolean valor) {
		this.emprestado = valor;
	}
	public void setReservado(boolean valor) {
		this.reservado = valor;
	}

	public Livro getLivro() {
		return this.livro;
	} 
	
	/*public void verificarReservasObs() {
		int qtdReservasAbertas = 0;
		for(Reserva r: this.reservas) {
			if(r.isAberta())
				qtdReservasAbertas++;
		}
		if(qtdReservasAbertas > 2)
			this.notificarObservadores();
	}

    private void notificarObservadores() {
        for (Observer obsr : observadores) {
            obsr.notificarReservas(this);
        }
    }
    public void addObservador(Observer observador) {
    	this.observadores.add(observador);
    }*/
    
    //public List<Reserva> getReservas(){
    	//return this.reservas;
    //}
		
}
