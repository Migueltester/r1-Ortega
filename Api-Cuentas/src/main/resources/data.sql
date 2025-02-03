-- Creacion de la tabla cuenta

Create table if not exists cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Cliente VARCHAR(100) NOT NULL,
    numero_Cuenta VARCHAR(13) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL,
    estado boolean NOT NULL
   
);
--
INSERT INTO cuenta (nombre_Cliente, numero_Cuenta, saldo, estado)
VALUES 
    ('Miguel Ortega', '040434565403', 1000.0, true),
    ('Cristal Almanza', '030434565403', 2000.0, true);

