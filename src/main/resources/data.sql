-- Création de la table
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
     id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
     firstname VARCHAR(50) NOT NULL,
     lastname VARCHAR(50) NOT NULL,
     email VARCHAR(50) NOT NULL,
     password VARCHAR(255) NOT NULL
);

-- Ajout d'enregistements
INSERT INTO `user` (firstname, lastname, email, password) VALUES
   ('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
   ('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
   ('Marie', 'Durand', 'mariedurand@mail.com', '1234');


-- Exemple création d'un compte :
CREATE USER test PASSWORD '1234' ADMIN;



-- Création de la table
DROP TABLE IF EXISTS book;

CREATE TABLE book (
      id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
      titre VARCHAR(50) UNIQUE NOT NULL,
      description VARCHAR(255) NOT NULL,
      datePublication DATE NOT NULL
);

-- Ajout d'enregistements
INSERT INTO book (titre, description, datePublication) VALUES
    ('Le savant', 'Histoire d un gars', 10/12/2012),
    ('Le roi', 'Histoire d un roi', 18/02/2012),
    ('Le pouilleux', 'Histoire d un pouilleux', 10/12/2015)


