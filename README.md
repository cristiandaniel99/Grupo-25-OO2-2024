PASOS PARA INCIAR EL SISTEMA:

1- CREAR LA BASE DE DATOS => CREATE DATABASE sistemastock;
2- GENERAR LAS VARIABLES DE ENTORNO (DB_URL, DB_USER, DB_PASS)
3- INCIAR EL PROYECTO PARA QUE SE GENEREN LAS TABLAS
4- EJECUTAR EL SIGUIENTE SCRIPT EN MYSQL WORKBENCH:

USE sistemastock;
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Av. Innovación 123', 'Apple Inc.', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Calle del Futuro 456', 'Microsoft Corporation', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Paseo Digital 789', 'Google LLC', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Calle de la Red 101', 'Amazon Web Services', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Avenida Silicon 202', 'Intel Corporation', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Calle Byte 303', 'Cisco Systems', 'Tecnología');
INSERT INTO proveedor (direccion, nombre, rubro) VALUES ('Camino del Chip 404', 'IBM Corporation', 'Tecnología');

INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('TV001', 300, 'Televisor LED de 42 pulgadas con resolución 4K', 'Samsung 42" 4K TV', 450);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('PC001', 700, 'PC de escritorio con procesador Intel i5, 8GB RAM, 256GB SSD', 'HP Desktop PC', 950);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('LPT001', 800, 'Laptop con procesador AMD Ryzen 7, 16GB RAM, 512GB SSD', 'Dell Inspiron Laptop', 1100);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('PHN001', 400, 'Smartphone con pantalla de 6.1 pulgadas, 128GB de almacenamiento', 'iPhone 12', 600);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('TBL001', 350, 'Tablet con pantalla de 10 pulgadas, 64GB de almacenamiento', 'Samsung Galaxy Tab', 500);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('HD001', 60, 'Disco duro externo de 1TB con conexión USB 3.0', 'Western Digital 1TB HDD', 100);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('MNT001', 150, 'Monitor LED de 24 pulgadas con resolución Full HD', 'LG 24" Monitor', 200);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('PRN001', 90, 'Impresora multifunción con conexión WiFi', 'Canon PIXMA Printer', 150);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('SPK001', 70, 'Parlante Bluetooth portátil con 10 horas de autonomía', 'JBL Flip 5', 120);
INSERT INTO producto (codigo, costo, descripcion, nombre, precio_de_venta) VALUES ('WCH001', 100, 'Reloj inteligente con monitor de frecuencia cardíaca y GPS', 'Apple Watch SE', 180);

INSERT INTO user (id, enabled, password, username) VALUES (1, true, "$2a$10$UK/FVxq0Op2W5b/cyR56kO1y8OvF8RMrfBmaYdM4EDBbutM1o.xcq", "administrador");
INSERT INTO user (id, enabled, password, username) VALUES (2, true, "$2a$10$zWtuGJddGNg11p5cAjrUtu2OAliG2XsO/bVG4Puyh/n6lT69kWPPu", "usuario");

INSERT INTO user_role (role, user_id) VALUES ("ROLE_ADMIN", 1);
INSERT INTO user_role (role, user_id) VALUES ("ROLE_USER", 2);

INSERT INTO stock_producto (cantidad, minima_stock, producto_id) VALUES (10, 2, 1);
INSERT INTO stock_producto (cantidad, minima_stock, producto_id) VALUES (30, 10, 2);
INSERT INTO stock_producto (cantidad, minima_stock, producto_id) VALUES (5, 2, 4);
INSERT INTO stock_producto (cantidad, minima_stock, producto_id) VALUES (15, 5, 5);


5- Una vez ejecutada la carga incial se puede dar ingreso al sistema, iniciando nuevamente el proyecto.
Credenciales de acceso: 

Username: usuario --> Password: user

Username: administrador --> Password: admin












