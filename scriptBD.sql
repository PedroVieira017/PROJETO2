-- Criação da base de dados
CREATE DATABASE HotelDB;
USE HotelDB;

-- Tabela de Hóspedes
CREATE TABLE Hospedes (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          nome VARCHAR(100) NOT NULL,
                          documento_identificacao VARCHAR(20) UNIQUE NOT NULL,
                          telefone VARCHAR(15),
                          email VARCHAR(100)
);

-- Tabela de Quartos
CREATE TABLE Quartos (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         numero INT UNIQUE NOT NULL,
                         tipo VARCHAR(50),
                         preco DECIMAL(10,2),
                         estado ENUM('Disponível', 'Ocupado') DEFAULT 'Disponível'
);

-- Tabela de Reservas
CREATE TABLE Reservas (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          id_hospede INT,
                          id_quarto INT,
                          data_checkin DATE,
                          data_checkout DATE,
                          FOREIGN KEY (id_hospede) REFERENCES Hospedes(id),
                          FOREIGN KEY (id_quarto) REFERENCES Quartos(id)
);

-- Tabela de Faturas
CREATE TABLE Faturas (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         id_reserva INT,
                         data_emissao DATE,
                         valor_total DECIMAL(10,2),
                         FOREIGN KEY (id_reserva) REFERENCES Reservas(id)
);
