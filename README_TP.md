# TP - Application de suivi des reparations de vehicules

## Fonctionnalites CRUD

Le projet permet de gerer:

- Clients: ajouter, afficher, modifier, supprimer.
- Vehicules: ajouter, afficher, modifier, supprimer.
- Reparations: ajouter, afficher, modifier, supprimer.

## Architecture

```text
garage/
|-- pom.xml
|-- database-phpmyadmin.sql
|-- src/
|   |-- main/
|   |   |-- java/com/reparation/garage/
|   |   |   |-- GarageApplication.java
|   |   |   |-- controller/
|   |   |   |   |-- ClientController.java
|   |   |   |   |-- HomeController.java
|   |   |   |   |-- ReparationController.java
|   |   |   |   |-- VehiculeController.java
|   |   |   |-- model/
|   |   |   |   |-- Client.java
|   |   |   |   |-- Reparation.java
|   |   |   |   |-- Vehicule.java
|   |   |   |-- repository/
|   |   |   |   |-- ClientRepository.java
|   |   |   |   |-- ReparationRepository.java
|   |   |   |   |-- VehiculeRepository.java
|   |   |-- resources/
|   |   |   |-- application.properties
|   |   |   |-- static/css/style.css
|   |   |   |-- templates/
|   |   |   |   |-- clients.html
|   |   |   |   |-- reparations.html
|   |   |   |   |-- vehicules.html
```

## Tables MySQL

- `client(id, nom, contact)`
- `vehicule(id, marque, modele, client_id)`
- `reparation(id, vehicule_id, description, date_reparation)`

## Routes principales

- `/clients`: liste et ajout des clients.
- `/clients/edit/{id}`: formulaire de modification d'un client.
- `/clients/update/{id}`: enregistrement de la modification.
- `/clients/delete/{id}`: suppression d'un client.
- `/vehicules`: liste et ajout des vehicules.
- `/vehicules/edit/{id}`: formulaire de modification d'un vehicule.
- `/vehicules/update/{id}`: enregistrement de la modification.
- `/vehicules/delete/{id}`: suppression d'un vehicule.
- `/reparations`: liste et ajout des reparations.
- `/reparations/edit/{id}`: formulaire de modification d'une reparation.
- `/reparations/update/{id}`: enregistrement de la modification.
- `/reparations/delete/{id}`: suppression d'une reparation.

## Installation depuis zero

1. Installer Java JDK 17 ou plus.
2. Installer XAMPP, puis demarrer Apache et MySQL.
3. Ouvrir phpMyAdmin: `http://localhost/phpmyadmin`.
4. Importer le fichier `database-phpmyadmin.sql` dans phpMyAdmin.
5. Verifier le mot de passe MySQL dans `src/main/resources/application.properties`.
   - XAMPP par defaut: utilisateur `root`, mot de passe vide.
   - Si tu as un mot de passe, modifier `spring.datasource.password`.
6. Dans le terminal, lancer:

```powershell
.\mvnw.cmd spring-boot:run
```

7. Ouvrir l'application dans le navigateur:

```text
http://localhost:8080
```

## Ordre d'utilisation

1. Ajouter un client.
2. Modifier ou supprimer un client avec les boutons dans le tableau.
3. Ajouter un vehicule et choisir son client.
4. Modifier ou supprimer un vehicule avec les boutons dans le tableau.
5. Ajouter une reparation et choisir son vehicule.
6. Modifier ou supprimer une reparation avec les boutons dans le tableau.

Spring Boot peut aussi creer les tables automatiquement grace a:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Le script SQL est fourni pour creer les memes tables manuellement dans phpMyAdmin.

Si une page affiche une erreur apres une modification du code Java, arreter Spring Boot puis relancer:

```powershell
.\mvnw.cmd spring-boot:run
```
