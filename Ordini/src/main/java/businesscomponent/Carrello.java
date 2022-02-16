package businesscomponent;

import java.util.Enumeration;
import java.util.Hashtable;

public class Carrello {
	private Hashtable<String, String[]> prodotti = new Hashtable<String, String[]>();
	private int articoli;
	
	public Carrello() {
		articoli = 0;
	}

	public int getArticoli() {
		return articoli;
	}

	public void aggiungiArticolo(String cod, String marca, String modello, double prezzo) {
		String[] record = { marca,modello,Double.toString(prezzo), "1", cod};
		articoli++;
		if(prodotti.containsKey(cod)) {
			String[] dati = prodotti.get(cod);
			int quantita = Integer.parseInt(dati[3]);
			quantita++;
			dati[3] = Integer.toString(quantita);
			prodotti.put(cod,dati);
		} else {
			prodotti.put(cod, record);
		}	
	}
	
	public void rimuoviArticolo(String cod) {
		if(prodotti.containsKey(cod)) {
			articoli--;
			String[] dati = prodotti.get(cod);
			if(Integer.parseInt(dati[3]) == 1) {
				prodotti.remove(cod);
			} else {
				int quantita = Integer.parseInt(dati[3]);
				quantita--;
				dati[3] = Integer.toString(quantita);
				prodotti.put(cod,dati);
			}	
		}
	}
	
	public double totaleParziale(String cod) {
		double totale = 0.00;
		String[] dati = prodotti.get(cod);
		totale += Double.parseDouble(dati[2]) * Integer.parseInt(dati[3]);
		return totale;
	}
	
	public double totaleComplessivo() {
		double totale = 0.00;
		Enumeration<String[]> dati = prodotti.elements();
		String [] elementi;
		while(dati.hasMoreElements()) {
			elementi = dati.nextElement();
			totale += Double.parseDouble(elementi[2]) * Integer.parseInt(elementi[3]);
		}
		return totale;
	}
	
	public Enumeration<String[]> getElementi(){
		return prodotti.elements();
	}
	
	
	

}
