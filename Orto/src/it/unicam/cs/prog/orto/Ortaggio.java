package it.unicam.cs.prog.orto;

public class Ortaggio {

	private String nome;
	private int numeroDiPiante;
	private int dataSemina;
	private int dataRaccoltaPrevista;
	
	/**
	 * Crea un oggetto Ortaggio
	 * @param nome 						Nome dell'ortaggio (di almeno 2 caratteri)
	 * @param numeroDiPiante 			Il numero di piante dell'ortaggio (maggiore di 0)
	 * @param dataSemina				La data in cui si è svolta la semina (maggiore di 0)
	 * @param dataRaccoltaPrevista		La data in cui si prevede di raccogliere la semina (maggiore di dataSemina)
	 * @throws Exception				se le condizioni sui parametri non sono rispettate
	 */
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

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public int getNumeroDiPiante() { return numeroDiPiante; }
	public void setNumeroDiPiante(int numeroDiPiante) { this.numeroDiPiante = numeroDiPiante; }

	public int getDataSemina() { return dataSemina; }
	public void setDataSemina(int dataSemina) { this.dataSemina = dataSemina; }

	public int getDataRaccoltaPrevista() { return dataRaccoltaPrevista; }
	public void setDataRaccoltaPrevista(int dataRaccoltaPrevista) { this.dataRaccoltaPrevista = dataRaccoltaPrevista; }
	
	
}
