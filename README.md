# fiche-and-frise-api

Une fois démarré, le serveur est accessible à l'adresse localhost:8081

##Liste des routes disponibles :
####Fiches : 

- GET : /fiches
- GET : /fiches/{id}
- POST : /fiches/new
- POST : /fiches/delete/{id}
- PUT : /fiches/update

####Frises : 

- GET : /frises
- GET : /frises/{id}
- GET : /frises/{id}/evenements
- GET : /frises/{id}/evenements/{idEvenement}
- POST : /frises/new
- PUT : /frises/update/evenement
- POST : /frises/delete/evenement
- POST : /frises/delete/{id}
- PUT : /frises/update

####Themes : 

- GET : /themes
- GET : /themes/{id}

####User : 

- GET : /login
- POST : /login
- GET : /registration
- POST : /registration