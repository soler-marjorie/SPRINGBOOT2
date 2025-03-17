DROP TABLE IF EXISTS utilisateur;
DROP TABLE IF EXISTS livre;

CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE livre(
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_publication DATE NOT NULL
);

INSERT INTO utilisateur (firstname, lastname, email, password) VALUES
('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
('Marie', 'Durand', 'mariedurand@mail.com', '1234');

INSERT INTO livre (titre, description, date_publication) VALUES
('Le Petit Prince', 'Un conte poétique et philosophique', '1943-04-06'),
('1984', 'Un roman dystopique sur un futur totalitaire', '1949-06-08'),
('Le Meilleur des mondes', 'Un roman de science-fiction sur une société futuriste', '1932-08-31');

CREATE USER test PASSWORD '1234' ADMIN;