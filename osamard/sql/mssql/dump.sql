
set IDENTITY_INSERT campioni ON;
INSERT INTO osama_raccolta_dati.dbo.campioni (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Free',0,'2023-03-03 16:30:34.0','2023-03-03 16:30:34.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.campioni (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'Real cost',0,'2023-03-03 16:30:34.0','2023-03-03 16:30:34.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.campioni (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (3,N'Double than real',0,'2023-03-03 16:30:34.0','2023-03-03 16:30:34.0',1,1);

set IDENTITY_INSERT campioni OFF;
set IDENTITY_INSERT certificazioni_fabbrica ON;
INSERT INTO osama_raccolta_dati.dbo.certificazioni_fabbrica (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'AUDIT',0,'2023-03-03 16:15:17.0','2023-03-03 16:15:17.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.certificazioni_fabbrica (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'BSCI',0,'2023-03-03 16:15:17.0','2023-03-03 16:15:17.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.certificazioni_fabbrica (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (3,N'SEDEX',0,'2023-03-03 16:15:17.0','2023-03-03 16:15:17.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.certificazioni_fabbrica (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (4,N'ISO',0,'2023-03-03 16:15:17.0','2023-03-03 16:15:17.0',1,1);

set IDENTITY_INSERT certificazioni_fabbrica OFF;
set IDENTITY_INSERT certificazioni_materiali ON;
INSERT INTO osama_raccolta_dati.dbo.certificazioni_materiali (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'REACH',0,'2023-03-03 16:18:31.0','2023-03-03 16:18:31.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.certificazioni_materiali (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'OEKO TEX',0,'2023-03-03 16:18:31.0','2023-03-03 16:18:31.0',1,1);

set IDENTITY_INSERT certificazioni_materiali OFF;
set IDENTITY_INSERT contatto ON;
INSERT INTO osama_raccolta_dati.dbo.contatto (id,nome,posizione,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Turi sghei',N'Vendite',0,'2023-03-08 11:41:42.66','2023-03-08 11:41:42.66',1,1);

set IDENTITY_INSERT contatto OFF;
set IDENTITY_INSERT fornitore ON;
INSERT INTO osama_raccolta_dati.dbo.fornitore (id,ragione_sociale,tempo_mercato,fat_tot,fat_it,numero_dipendenti,rd_interno,id_trading,id_contatto,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Rag soc test1',N'un tempo',N'100â‚¬',N'100â‚¬',50,0,NULL,1,0,'2023-03-08 10:41:42.883','2023-03-08 10:41:42.883',1,1);

set IDENTITY_INSERT fornitore OFF;
set IDENTITY_INSERT fornitore_categoria ON;
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Writing',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'Accessori scrittura',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (3,N'Diary / Notes',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (4,N'Living',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (5,N'Accessori / Casalinghi ',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (6,N'Arredo casa',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (7,N'Storage',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (8,N'Scatole / Gif Box',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (9,N'Bags / Accessories',0,'2023-03-03 16:24:52.0','2023-03-03 16:24:52.0',1,1);

set IDENTITY_INSERT fornitore_categoria OFF;
set IDENTITY_INSERT fornitore_subcategoria ON;
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Penne',1,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'Pennarelli',1,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (3,N'Matite',1,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (4,N'Correttori',1,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (5,N'Towel - Spugna',4,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (6,N'Bed sheet',4,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.fornitore_subcategoria (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (7,N'Tableware',4,0,'2023-03-03 16:28:01.0','2023-03-03 16:28:01.0',1,1);

set IDENTITY_INSERT fornitore_subcategoria OFF;
set IDENTITY_INSERT foto_tipo_oggetto ON;
INSERT INTO osama_raccolta_dati.dbo.foto_tipo_oggetto (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'fornitore',0,'2023-03-06 15:00:02.0','2023-03-06 15:00:02.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.foto_tipo_oggetto (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'prodotto',0,'2023-03-06 15:00:02.0','2023-03-06 15:00:02.0',1,1);

set IDENTITY_INSERT foto_tipo_oggetto OFF;
set IDENTITY_INSERT moq ON;
INSERT INTO osama_raccolta_dati.dbo.moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'Per articolo',0,'2023-03-03 16:29:22.0','2023-03-03 16:29:22.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (2,N'Per colore',0,'2023-03-03 16:29:22.0','2023-03-03 16:29:22.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (3,N'Per Taglia',0,'2023-03-03 16:29:22.0','2023-03-03 16:29:22.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (4,N'Per ordine di acquisto',0,'2023-03-03 16:29:22.0','2023-03-03 16:29:22.0',1,1);
INSERT INTO osama_raccolta_dati.dbo.moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (5,N'Per spedizione',0,'2023-03-03 16:29:22.0','2023-03-03 16:29:22.0',1,1);

set IDENTITY_INSERT moq OFF;
set IDENTITY_INSERT prodotto ON;
INSERT INTO osama_raccolta_dati.dbo.prodotto (id,cod_articolo,id_materiale,id_dimensioni,id_moq,id_prezzo,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER,id_fornitore) VALUES (1,N'cod Articolo 1',NULL,NULL,1,NULL,0,'2023-03-08 11:41:42.89','2023-03-08 11:41:42.89',1,1,1);

set IDENTITY_INSERT prodotto OFF;
set IDENTITY_INSERT utente ON;
INSERT INTO osama_raccolta_dati.dbo.utente (id,username,nome,cognome,email,password,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,N'ANdreaTest',N'Andrea',N'Zamma',N'andrea.zammataro@kedos-srl.it',N'{SHA}a94a8fe5ccb19ba61c4c0873d391e987982fbbd3',0,'2023-03-02 16:52:06.0','2023-03-02 16:52:06.0',1,1);
set IDENTITY_INSERT utente OFF;
