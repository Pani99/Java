package architecture.dao;

public interface DAOConstants {
	//-------------client
	String SELECT_UTENTE = "select * from utente";
	String SELECT_ORDINE = "select * from ordine";
	String SELECT_ARTICOLO= "select * from articolo ORDER BY id_articolo";
	String SELECT_ORDINE_ARTICOLO = "select * from ordine_articolo";
	String SELECT_IMMAGINE  = "select * from immagine";
	
	String UPDATE_UTENTE = "Update utente set nome = ?, cognome = ?, indirizzo = ?, cap = ?, nascita = ?, password = ?, email = ? where username = ?";
	
	String DELETE_UTENTE = "Delete from utente where username = ?";

	String SELECT_USERPASS = "select password from utente where username = ?";
	
	String SELECT_ORDINE_SEQ = "select ordine_seq.nextval from dual";
	
	String INSERT_ORDINE_ARTICOLO = "Insert into ordine_articolo values(?,?,?)";
	
	String UPDATE_ORDINE = "Update ordine set totale = ?, data = ?, username = ? where id_ordine = ?";
	
	
	//--------------------ADMIN
	String SELECT_AMMINISTRATORE = "select * from amministratore";
	String SELECT_ADMINPASS = "select password from amministratore where username = ?";
	String UPDATE_AMMINISTRATORE = "Update amministratore set password = ?, email = ? where username = ?";
	String DELETE_AMMINISTRATORE = "Delete from amministratore where username = ?";
	
	String SELECT_ARTICOLO_SEQ = "select articolo_seq.nextval from dual";
	String UPDATE_ARTICOLO = "Update articolo set marca = ?, modello = ?, prezzo = ? where id_articolo = ?";
	
	String DELETE_ORDINE = "Delete from ordine where id_ordine = ?";
	
	String DELETE_ARTICOLO = "Delete from articolo where id_articolo = ?";
	
	String SELECT_REPORT = "Select * from report";
	
	String UPDATE_IMMAGINE = "Update immagine set url = ?, descrizione = ? where id_img = ?";
	String DELETE_IMMAGINE = "Delete from immagine where id_img = ?";
	
	//----------------------
	String SELECT_ARTICOLO_BYID = "select * from articolo where id_articolo = ?";
	
	String SELECT_UTENTE_BYID = "select * from utente where username = ?";
	
	String SELECT_ORDINE_BYID = "select * from ordine where id_ordine = ?";
	
	String SELECT_IMMAGINE_BYID = "select * from immagine where id_img = ?";
	
	String SELECT_AMMINISTRATORE_BYID = "select * from amministratore where username = ?";
	
	//....................QUERY
	
	String SELECT_PIU_VENDUTO ="select id_articolo, sum(quantita) as n_vendite from ordine_articolo group by id_articolo order by n_vendite desc" ;
	String SELECT_TOTALE_VENDITE = "select sum(totale) from ordine";
	String SELECT_CLIENTE_AFFEZIONATO = "select username, sum(totale) as spese from ordine group by username order by spese desc";
	String SELECT_CLIENTE_PIU_ORDINI = "select username, count(*) as n_ordini from ordine group by username order by n_ordini desc";
	
	String SELECT_TOTAL_EARNINGS = "SELECT SUM(totale) "
			+ "FROM (SELECT articolo.id_articolo, SUM(prezzo) AS totale "
			+ "FROM articolo, ordine_articolo "
			+ "WHERE articolo.id_articolo = ordine_articolo.id_articolo "
			+ "GROUP BY articolo.id_articolo)";
	
	String SELECT_BEST_SELLER = "SELECT id_articolo FROM ordine_articolo GROUP BY id_articolo ";
	
	String SELECT_MOST_ORDERS = "SELECT username FROM somma_ordini WHERE ordini = (SELECT MAX(ordini) FROM somma_ordini)";
	String SELECT_MOST_ORDERS_NUMBER = "SELECT MAX(ordini) FROM(SELECT username, COUNT(*) AS ORDINI"
			+ " FROM report GROUP BY username)";
	String SELECT_MOST_SPENT_USER = "SELECT username FROM somma_spese_cliente WHERE totale = (SELECT MAX(totale) FROM somma_spese_cliente)";
	
}
