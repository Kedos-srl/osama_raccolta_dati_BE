# osama raccolta dati

## Prerequisiti
Aver installato Docker
## Avvio applicazione
Posizionarsi nella cartella del progetto ed eseguire il comando

`docker compose up --build`

Questo avvierà:
- Database sulla porta 3311 popolato con i dati di test.
- API App raggiungibile localhost:8011/osamard-api-docker


Se si vuole cambiare il dump del db sostituire il file:
`osama_raccolta_dati_BE/osamard/sql/dump/dump_osamard_db.sql`

## Postman
- Creare un nuovo workspace
- Importare la collection "API.postman_collection.json"
- Importare l'ambiente "Docker.postman_environment"
- Importare l'ambiente "Ide.postman_environment"

Enjoy :) 