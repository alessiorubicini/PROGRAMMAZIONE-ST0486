package it.unicam.cs.prog.orto;

public class Ortaggio {
	private String nome;
	private int numeroDiPiante;
	private int dataSemina;
	private int dataRaccoltaPrevista;

	public Ortaggio(String nome, int numeroDiPiante, int dataSemina, int dataRaccoltaPrevista) throws Exception {
		if((nome.toCharArray().length >= 2) && (numeroDiPiante > 0) && (dataSemina > 0) && (dataRaccoltaPrevista > dataSemina)) {
			this.nome = nome;
			this.numeroDiPiante = numeroDiPiante;
			this.dataSemina = dataSemina;
			this.dataRaccoltaPrevista = dataRaccoltaPrevista;
		} else {
			throw new Exception("Parametri errati: ortaggio non creato");
		}
	}

	public String getNome() {
		return nome;
	
	}
	public void setNome(String nome) { this.nome = nome; }

	public int getNumeroDiPiante() {
		return numeroDiPiante;
	}
	
	public void setNumeroDiPiante(int numeroDiPiante) {
		this.numeroDiPiante = numeroDiPiante;
	}

	public int getDataSemina() {
		return dataSemina;
	}
	
	public void setDataSemina(int dataSemina) {
		this.dataSemina = dataSemina;
	}

	public int getDataRaccoltaPrevista() {
		return dataRaccoltaPrevista;
	}
	
	public void setDataRaccoltaPrevista(int dataRaccoltaPrevista) {
		this.dataRaccoltaPrevista = dataRaccoltaPrevista;
	}
	
	
}
