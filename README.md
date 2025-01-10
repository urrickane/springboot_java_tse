# Projet Team Management

Ce projet est une application Spring Boot pour la gestion des équipes. Il permet de créer, modifier, afficher et supprimer des équipes via une interface web et une API REST.

## Fonctionnalités

- Ajouter une équipe avec son nom et sa ville.
- Modifier les informations d'une équipe existante.
- Supprimer une équipe de la base de données.
- Lister toutes les équipes enregistrées.

## Prérequis

- **Java** : Version 17 ou supérieure.
- **Maven** : Version 3.8 ou supérieure.
- **PostgreSQL** : Version 17.
- **IDE recommandé** : IntelliJ IDEA ou Eclipse.

## Installation

### Cloner le dépôt :
```bash
git clone https://github.com/urrickane/springboot_java_tse.git
cd springboot_java_tse
```
### Configurer la base de données
```bash
createdb -U *votre_nom_utilisateur* -h localhost -p *port_configuré_pour_postgresql* teams_db
pg_restore -U *votre_nom_utilisateur* -h localhost -p *port_configuré_pour_postgresql* -d teams_db -c './dump bdd/backup_teams_db.dump'
```
Remplacez *votre_nom_utilisateur* par le nom de votre identifiant super-utilisateur de postgresql. Par défaut, postgres.
Remplacez *port_configuré_pour_postgresql* par le port utilisé par postgresql que vous avez configuré au démarrage. Par défaut, 5432.
### Mettre à jour les informations de connexion dans src/main/resources/application.properties
```bash
spring.datasource.url=jdbc:postgresql://localhost:*port_configuré_pour_postgresql*/teams_db
spring.datasource.username=*votre_nom_utilisateur*
spring.datasource.password=*votre_mot_de_passe*
```
Remplacez *votre_nom_utilisateur* et *votre_mot_de_passe* par vos identifiants super-utilisateur de postgresql. Par défaut, postgres.
Remplacez *port_configuré_pour_postgresql* par le port utilisé par postgresql que vous avez configuré au démarrage. Par défaut, 5432.
### Installer les dépendances Maven
```bash
mvn clean install
```

## Lancement

```bash
mvn spring-boot:run
```
Puis rendez-vous à l'adresse [http://localhost:8080/teams.html](http://localhost:8080/teams.html) dans votre navigateur.

## API REST

| Méthode |	Endpoint        |	Description                  | Corps requis                   |
| ------- | --------------- | ---------------------------- | ------------------------------ |
| GET	    | /api/teams      | Liste toutes les équipes     | Aucun                          |
| POST	  | /api/teams      | Ajoute une nouvelle équipe   | {"name": "...", "city": "..."} |
| PUT	    | /api/teams/{id} | Modifie une équipe existante | {"name": "...", "city": "..."} |
| DELETE  | /api/teams/{id} | Supprime une équipe par ID   | Aucun                          |

## Tests

### Exécuter les tests
```bash
mvn test
```
Les tests incluent :
- Vérification de l'ajout d'une équipe.
- Modification des informations d'une équipe.
- Suppression d'une équipe.

## Auteur

Ewan Sauze
