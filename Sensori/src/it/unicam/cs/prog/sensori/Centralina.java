package it.unicam.cs.prog.sensori;

public class Centralina {
	private Sensore[] acquisizioni;
	
	Centralina(int numeroLetture) {
		acquisizioni = new Sensore[numeroLetture];
	}
	
	private void iniziaLettura() throws Exception {
		for(int i = 0; i < this.acquisizioni.length; i++) {
			if(generaLetturaRandom(2) == 0) {
				this.acquisizioni[i] = new SensorePioggia(generaLetturaRandom(10));
			} else {
				this.acquisizioni[i] = new SensoreVento(generaLetturaRandom(360), generaLetturaRandom(30));
			}
		}
		Thread.sleep(generaLetturaRandom(10));
	}
	
	private int generaLetturaRandom(int r) { return (int)(Math.random() * r); }
	
	public String getMediaLetture() {
		long mediaForza = 0, mediaDirezione = 0, mediaPioggia = 0;
		int contaVento = 0, contaPioggia = 0;
		for(int i = 0; i < this.acquisizioni.length; i++) {
			if(this.acquisizioni[i] instanceof SensorePioggia) {
				mediaPioggia += ((SensorePioggia)(this.acquisizioni[i])).getPrecipitazioni();
				contaPioggia++;
			} else {
				mediaForza += ((SensoreVento)(this.acquisizioni[i])).getForza();
				mediaDirezione += ((SensoreVento)(this.acquisizioni[i])).getDirezione();
				contaVento++;
			}
		}
		return 	"Forza media: " + (double)mediaForza/contaVento
				+ " m/s | Direzione media: " + (double)mediaDirezione/contaVento
				+ "° | Precipitazioni medie: " + (double)mediaPioggia/contaPioggia + " mm";
	}
	
	@Override public String toString() {
		String risultato = "";
		for(int i = 0; i < this.acquisizioni.length; i++) {
			risultato += this.acquisizioni[i] + "\n";
		}
		return risultato;
	}
	
	public static void main(String[] arg) throws Exception {
		Centralina casa = new Centralina(1000);
		casa.iniziaLettura();
		System.out.println(casa);	// Richiama metodo toString()
		System.out.println(casa.getMediaLetture());
	}
	
}
