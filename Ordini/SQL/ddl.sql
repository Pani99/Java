--client
create table utente(
nome varchar2(30) not null,
cognome varchar2(30) not null,
indirizzo varchar2(30) not null,
cap char(5) not null,
nascita date not null,
username varchar2(10),
password varchar2(500) not null,
email varchar2(50) not null unique,
constraint p_username primary key(username));

create table articolo(
id_articolo int,
marca varchar2(30) not null,
modello varchar2(30) not null,
prezzo number(7,2) not null,
constraint p_id_articolo primary key(id_articolo)
);

create table immagine(
id_img int primary key references articolo(id_articolo),
url varchar2(500) not null,
descrizione varchar2(1500));

create table ordine(
id_ordine int,
totale number(9,2) not null,
data date not null,
username varchar2(10),
constraint p_id_ordine primary key (id_ordine),
constraint f_username foreign key (username) references utente(username) on delete cascade);

create table ordine_articolo(
id_ordine int,
id_articolo int,
quantita number(3) default 1,
constraint f_id_ordine foreign key (id_ordine) references ordine(id_ordine) on delete cascade,
constraint f_id_articolo foreign key (id_articolo) references articolo(id_articolo) on delete cascade,
constraint p_oa primary key(id_ordine, id_articolo));

-- sequences
create sequence ordine_seq;
create sequence articolo_seq;


-- admin
create table amministratore(
username varchar2(10),
password varchar2(800) not null,
email varchar2(50) not null unique,
constraint p_admin primary key(username));


-- view
create or replace view report as
select utente.username, utente.email, ordine.id_ordine, totale, sum(quantita) as qta
from utente,ordine,ordine_articolo, articolo
where 
ordine.id_ordine = ordine_articolo.id_ordine
and
articolo.id_articolo = ordine_articolo.id_articolo
and
utente.username = ordine.username
group by utente.username, utente.email, ordine.id_ordine, totale
order by utente.username, ordine.id_ordine;

CREATE OR REPLACE VIEW somma_ordini AS
SELECT utente.username, SUM(quantita) AS ordini
FROM ordine_articolo, articolo, utente, ordine
WHERE ordine_articolo.id_articolo = articolo.id_articolo
AND utente.username = ordine.username
AND ordine.id_ordine = ordine_articolo.id_ordine
GROUP BY  utente.username;

CREATE OR REPLACE VIEW somma_spese_cliente AS
SELECT ordine.username, sum(articolo.prezzo*ordine_articolo.quantita) AS totale
FROM ordine_articolo, articolo, ordine
WHERE ordine_articolo.id_articolo = articolo.id_articolo
AND ordine.id_ordine = ordine_articolo.id_ordine
GROUP BY ordine.username;