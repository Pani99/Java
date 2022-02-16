package businesscomponent.model;

public class OrdineArticolo {
	private long idArticolo;
	private long idOrdine;
	private int quantita;
	public long getIdArticolo() {
		return idArticolo;
	}
	public void setIdArticolo(long idArticolo) {
		this.idArticolo = idArticolo;
	}
	public long getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(long idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	@Override
	public String toString() {
		return "OrdineArticolo [idArticolo=" + idArticolo + ", idOrdine=" + idOrdine + ", quantita=" + quantita + "]";
	}
	
	
	
}
