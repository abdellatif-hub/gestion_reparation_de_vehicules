CREATE DATABASE IF NOT EXISTS gestion_reparation
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE gestion_reparation;

CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS vehicule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marque VARCHAR(255) NOT NULL,
    modele VARCHAR(255) NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_vehicule_client
        FOREIGN KEY (client_id)
        REFERENCES client(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS reparation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicule_id BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_reparation DATE NOT NULL,
    CONSTRAINT fk_reparation_vehicule
        FOREIGN KEY (vehicule_id)
        REFERENCES vehicule(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;
