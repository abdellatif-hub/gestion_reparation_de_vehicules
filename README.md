## Projet 13 : Application Gestion Garage (Spring Boot + MySQL) 
Ce projet est une application web développée avec Spring Boot permettant de gérer :

- 👤 Les clients
- 🚗 Les véhicules
- 🔧 Les réparations

### L'application utilise :

- Spring Boot (MVC + JPA)
- MySQL (phpMyAdmin)
- Thymeleaf (frontend simple)

### ⚙️ Technologies utilisées
- Java 17
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- phpMyAdmin
- Maven
- Thymeleaf

### Dependencies : 
- Spring Web
- Spring Data JPA
- MySQL Driver
- Lombok
<img width="2559" height="1267" alt="1" src="https://github.com/user-attachments/assets/28160d87-24df-41fe-9f21-28a72ccb8ad3" />

  
--- 

# 🏗️ Architecture du projet : 
````
com.reparation.garage
│
├── controller
│   ├── ClientController
│   ├── VehiculeController
│   ├── ReparationController
│   └── HomeController
│
├── model
│   ├── Client
│   ├── Vehicule
│   └── Reparation
│
├── repository
│   ├── ClientRepository
│   ├── VehiculeRepository
│   └── ReparationRepository
│
└── GarageApplication
````
<img width="2559" height="1344" alt="2" src="https://github.com/user-attachments/assets/c0dda790-031e-46f0-887e-aff7f7c383a8" />

--- 

### Exécution réussie d’une application Spring Boot dans le terminal :
### Lancement de l'application : 
````
mvn spring-boot:run
````
###  Accès :
````
http://localhost:8080
````

Exécution réussie d’un projet Spring Boot dans le terminal avec Maven, sans erreurs, indiquant que l’application est démarrée et prête à fonctionner.
<img width="2307" height="1229" alt="3" src="https://github.com/user-attachments/assets/1c8034f3-5422-428c-9c1d-014a8d507ff7" />
<img width="2408" height="1242" alt="4" src="https://github.com/user-attachments/assets/d34a6eb8-b575-4987-b5fb-22130db49b05" />


--- 

## 🧱 Base de données (phpMyAdmin):
Structure de la base de données
<img width="2559" height="1275" alt="5" src="https://github.com/user-attachments/assets/8d023d06-5e5d-4caf-aafb-1e6217169ff8" />

### Description :

- client → informations des clients
- vehicule → lié à client (clé étrangère)
- reparation → lié à vehicule
  
# 🧾 Tables : 
### Table Client :
<img width="2559" height="1262" alt="6" src="https://github.com/user-attachments/assets/2f64013c-2ce3-4e88-a331-49357dd97516" />

- id
- nom
- contact

# 📌 Table Vehicule : 
<img width="2559" height="1268" alt="7" src="https://github.com/user-attachments/assets/61a5b21f-e799-4c18-8529-07fdaedf6bff" />
- id
- marque
- modele
- client_id
  
# 📌 Table Reparation
<img width="2559" height="1270" alt="8" src="https://github.com/user-attachments/assets/fe281074-3bda-4546-9095-555e7c8621ea" />

- id
- date_reparation
- description
- vehicule_id

## Interfaces de l'application

###  Gestion des clients
<img width="2559" height="1266" alt="9" src="https://github.com/user-attachments/assets/97f418cf-9c75-4c79-860b-25c8bf4963ec" />


### 🔎 Description :

- Ajouter un client (nom + contact)
- Afficher la liste
- Modifier / supprimer

<img width="2559" height="1268" alt="16" src="https://github.com/user-attachments/assets/9dd4ee1d-c073-4f4e-ab90-e8f3bc5a365c" />


--- 

## Modification client : 
<img width="2559" height="1270" alt="10" src="https://github.com/user-attachments/assets/4514c21c-8eac-4f88-aacb-ff577b9df31b" />


### 🔎 Description :

Modifier les informations d’un client


## Suppression client
<img width="2558" height="1261" alt="11" src="https://github.com/user-attachments/assets/d70f58e0-33ea-4194-abbf-d6d1ba3bae54" />


### 🔎 Description :

Popup de confirmation avant suppression

---

## 🚗 Gestion des véhicules
 Ajout véhicule : 
 <img width="2559" height="1270" alt="12" src="https://github.com/user-attachments/assets/3cc403b8-30d8-4aa3-bfc5-7a1cc43ac904" />
 ## 🔎 Description :

- Ajouter un véhicule
- Associer à un client

## Liste véhicules
<img width="2559" height="1264" alt="17" src="https://github.com/user-attachments/assets/88115ada-1e9b-4f7f-9cbe-4e5f674c38ad" />

### 🔎 Description :

Affichage des véhicules avec leurs clients

##  Modification véhicule

<img width="2559" height="1261" alt="13" src="https://github.com/user-attachments/assets/8c41ea53-f1f8-41c1-b611-f471a6b06739" />

### 🔎 Description :

Modifier marque, modèle, client


## 🔧 Gestion des réparations
<img width="2559" height="1271" alt="14" src="https://github.com/user-attachments/assets/cac1995f-d31e-4a30-8989-6df9761ae64d" />


### 🔎 Description :

- Choisir véhicule
- Ajouter description + date

### Liste réparations : 
<img width="2555" height="1267" alt="18" src="https://github.com/user-attachments/assets/a34596c4-69c4-4616-9e9a-34b61d1b5963" />

### 🔎 Description :

Historique des réparations

## Modification réparation 
<img width="2559" height="1263" alt="15" src="https://github.com/user-attachments/assets/27c8eddb-d51c-4f33-aabb-2134abacc337" />

### 🔎 Description :

Modifier réparation existante

## 🔄 Fonctionnalités principales

# CRUD complet :

- Ajouter
- Modifier
- Supprimer
- Afficher

# Relations :

- Client → Vehicule
- Vehicule → Reparation

# Conclusion

Ce TP nous a permis de créer une application web complète avec Spring Boot en utilisant une base de données MySQL. Nous avons réalisé les opérations CRUD pour gérer les clients, les véhicules et les réparations, tout en appliquant l’architecture MVC.


