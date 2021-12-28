package it.unicam.cs.prog.comuni;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Elenco {
	private ArrayList elenco = new ArrayList();
	
	Elenco(String file) throws FileNotFoundException, ComuneException {
		file = "/Users/Rosario/Comuni/Comuni1.csv";
		FileReader f = new FileReader(file);
		Scanner in = new Scanner(f);
		in.useDelimiter(";|\\r\\n");
		while(in.hasNext()) {
			elenco.add(new Comune(in.next(),in.next(),in.next(),in.nextInt()));
		}
		in.close();
	}
	

	public int max() {
		int massimo = 0;
		for (int i = 0; i < elenco.size(); i++) {
			if (((Comune)(elenco.get(i))).getAbitanti() > massimo) {
				massimo = ((Comune)(elenco.get(i))).getAbitanti();
			}
		}
		return massimo;
	}
	
	public int getElementi() { return elenco.size(); }
	
	public int comuniInProvincia(String p) {
		int conta = 0;
		for (int i = 0; i < elenco.size(); i++) {
			if (((Comune)(elenco.get(i))).getProvincia().equals(p)) {
				conta++;
			}
		}
		return conta;
	}
}