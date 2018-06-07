DROP DATABASE IF EXISTS `db_eaicomeu`;
CREATE DATABASE db_eaicomeu;
USE db_eaicomeu;

DROP TABLE IF EXISTS `tbl_usuario`;
CREATE TABLE tbl_usuario(
	usuario_id INT NOT NULL AUTO_INCREMENT,
    usuario_cpf VARCHAR(20) NOT NULL UNIQUE,
	usuario_nome VARCHAR(30) NOT NULL,
	usuario_email VARCHAR(30) NOT NULL,
	usuario_celular VARCHAR(30) NOT NULL,
	usuario_uf CHAR(2) NOT NULL,
	usuario_cidade VARCHAR(30) NOT NULL,
	usuario_cep VARCHAR(20) NOT NULL,
	usuario_bairro VARCHAR(60) NOT NULL,
	usuario_endereco VARCHAR(60) NOT NULL,
	usuario_logradouro VARCHAR(10) NOT NULL,	
	usuario_complemento VARCHAR(60),
	PRIMARY KEY(usuario_id)
);

INSERT INTO tbl_usuario(usuario_cpf, usuario_nome, usuario_email, usuario_celular, usuario_uf, usuario_cidade, usuario_cep, usuario_bairro, usuario_endereco, usuario_logradouro, usuario_complemento) VALUES
('488.727.448-30', 'William Filho', 'willpelicer@gmail.com', '19999967251', 'SP', 'Hortolândia', '13.186-203', 'Jardim Mirante', 'Rua Primeiro de Maio', '133', 'Sem complemento');

DROP TABLE IF EXISTS `tbl_entregador`;
CREATE TABLE tbl_entregador(
	entregador_id INT NOT NULL AUTO_INCREMENT,
	entregador_cnh VARCHAR(20) UNIQUE,	
	usuario_id INT NOT NULL,
	PRIMARY KEY(entregador_id),
	FOREIGN KEY(usuario_id) REFERENCES tbl_usuario(usuario_id)
);

DROP TABLE IF EXISTS `tbl_restaurante`;
CREATE TABLE tbl_restaurante(
	restaurante_id INT NOT NULL AUTO_INCREMENT,
	restaurante_cnpj VARCHAR(30) NOT NULL UNIQUE,
	restaurante_razaoSocial VARCHAR(60) NOT NULL,
    restaurante_email VARCHAR(30) NOT NULL,
    restaurante_telefone VARCHAR(20) NOT NULL,
    restaurante_celular VARCHAR(20),
	restaurante_uf CHAR(2) NOT NULL,
	restaurante_cidade VARCHAR(30) NOT NULL,
	restaurante_cep VARCHAR(20) NOT NULL,
	restaurante_bairro VARCHAR(60) NOT NULL,
	restaurante_endereco VARCHAR(60) NOT NULL,
	restaurante_logradouro VARCHAR(10) NOT NULL,	
	restaurante_complemento VARCHAR(60) NOT NULL,
	restaurante_thumbnail VARCHAR(60) NOT NULL,
	PRIMARY KEY(restaurante_id)
);

INSERT INTO `tbl_restaurante`( `restaurante_cnpj`, `restaurante_razaoSocial`, `restaurante_email`, `restaurante_telefone`,`restaurante_celular`, `restaurante_uf`, `restaurante_cidade`, `restaurante_cep`, `restaurante_bairro`, `restaurante_endereco`, `restaurante_logradouro`, `restaurante_complemento`, `restaurante_thumbnail`) VALUES 
('55.457.438/0001-95','Papa tudo lanches ME','papatudolanches@hotmail.com','3965-5506','3965-5506','SP','Hortolandia',' 13186-054','Jardim Santa Rita de Cassia','R. dos Estudantes', '132','Trailer','/img/perfil/restaurante/papatudo.png'),
('43.341.433/0001-13','MC Donalds ME' ,'mcdonaldslanche@mcdonalds.com','3819-5577','3819-5577','SP','Campinas',' 13184-210','Parque Ortolândia','Av. Santana','970','Drive Thru','/img/perfil/restaurante/mcdonalds.png'),
('77.441.422/0001-27','Subway Alimentos ME', 'subwayalimentos@subway.com', '3116-1137', '3116-1137','SP','Americana',' 13184-210',' Parque Ortolândia','Av. Santana','847','','/img/perfil/restaurante/subway.png'),
('55.666.438/0001-95','Burger King','bk@hotmail.com','3965-5506','3965-5506','SP','Hortolandia',' 13186-054','Jardim Santa Rita de Cassia','R. dos Estudantes', '132','Trailer','/img/perfil/restaurante/burgerking.png'),
('25.666.438/0001-95','Turbinado Lanches','turbinado-lanches@hotmail.com','3965-5506','3965-5506','SP','Hortolandia',' 13186-054','Jardim Santa Rita de Cassia','R. dos Estudantes', '132','Trailer','/img/perfil/restaurante/turbinado.png'),
('56.623.138/0001-15','Pizza Hut','contato@pizzahut.com','3965-5506','3965-2506','SP','Campinas',' 13156-054','Jardim Mirante','R. Tancredo Neves', '524','Hamburgueria','/img/perfil/restaurante/pizzahut.png'),
('92.126.238/0001-26','Hot Dog Express','express@yahoo.com','3965-5506','3965-4306','SP','Sumaré',' 14186-054','Emancipação','R. Emancipação', '6356','Trailer','/img/perfil/restaurante/hotdogexpress.png'),
('74.567.358/0001-32','China in Box','sac@chinainbox.com','3965-5506','3965-5234','SP','Monte-Mor',' 16186-054','Cambuí','R. Moraes Sales', '134','','/img/perfil/restaurante/chinainbox.png'),
('49.837.445/0001-78','Kanibal Burger','kanibal-burger@gmail.com','3965-2137','3965-5506','SP','Hortolandia',' 13186-054','Jardim Oswaldo','R. dos Estudantes', '654','Trailer','/img/perfil/restaurante/kanibalburger.png');

DROP TABLE IF EXISTS `tbl_login`;
CREATE TABLE tbl_login(
	login_nome VARCHAR(30) NOT NULL,
	login_senha VARCHAR(12) NOT NULL,
    login_email VARCHAR(30) NOT NULL,
	usuario_id INT,
	restaurante_id INT,
	FOREIGN KEY(usuario_id) REFERENCES tbl_usuario(usuario_id),
	FOREIGN KEY(restaurante_id) REFERENCES tbl_restaurante(restaurante_id)
);

INSERT INTO tbl_login(login_nome, login_senha, login_email, usuario_id, restaurante_id) VALUES 
('admin', 'admin', 'willpelicer@gmail', 1, null);

DROP TABLE IF EXISTS `tbl_tipo`;
CREATE TABLE tbl_tipo(
	tipo_id INT NOT NULL AUTO_INCREMENT,
	tipo_descricao VARCHAR(30),
	PRIMARY KEY(tipo_id)
);

INSERT INTO tbl_tipo (tipo_descricao) VALUES
('Bebidas'),
('Caldos'),
('Combos'),
('Escondidinhos'),
('Hamburgueres'),
('Lanches'),
('Porções'),
('Pratos'),
('Sobremesas'),
('Pizzas'),
('Chinesas'),
('Japonesas');

DROP TABLE IF EXISTS `tbl_produto`;
CREATE TABLE tbl_produto(
	produto_id INT NOT NULL AUTO_INCREMENT,
	produto_nome VARCHAR(30) NOT NULL,
	produto_descricao VARCHAR(300),
	produto_valor DECIMAL(5,2) NOT NULL,
	produto_thumbnail VARCHAR(60),
	tipo_id INT NOT NULL,
	restaurante_id INT NOT NULL,
	PRIMARY KEY(produto_id),
	FOREIGN KEY(tipo_id) REFERENCES tbl_tipo(tipo_id),
	FOREIGN KEY(restaurante_id) REFERENCES tbl_restaurante(restaurante_id)
);

INSERT INTO tbl_produto (produto_nome,produto_descricao,produto_valor,produto_thumbnail,tipo_id,restaurante_id) VALUES
('X-salada','Pão, Hambúrguer, Queijo, Alface e Tomate.',10.0,'/img/products/restaurant/papatudo/x-salada.png',5,1),
('Big Mac','Dois hambúrgueres, alface, queijo e molho especial, cebola e picles num pão com gergelim.',15.0,'/img/products/restaurant/mcdonalds/bigmac.png',5,2),
('Carne e queijo','Fatias de carne bovina magra em uma combinação perfeita com vegetais e molhos. A escolha perfeita.',8.9,'/img/products/restaurant/subway/carne_e_queijo.png',5,3),
('Cheeseburguer','Pão com gergelim, um saboroso hambúrguer de pura carne bovina, uma fatia de queijo derretido, duas fatias de picles, ketchup e mostarda. Imagem meramente ilustrativa.',10.0,'/img/products/restaurant/burgerking/cheeseburguer.png',5,4),
('Corn&Bacon - 8 fatias','Mussarela, bacon e milho.',35.00,'/img/products/restaurant/pizzahut/corn_bacon.png',10,6),
('Corn&Bacon - 12 fatias','Mussarela, bacon e milho.',42.00,'/img/products/restaurant/pizzahut/corn_bacon.png',10,6),
('Tradicional','Pão, salsicha, vinagrete, milho, ketchup, mostarda, batata-palha, purê, maionese e queijo ralado.',8.0,'/img/products/restaurant/hotdogexpress/tradicional.png',6,7),
('Yakissoba clássico - grande','Macarrão com carne, frango, legumes e champignons.',39.30,'/img/products/restaurant/chinainbox/yakissoba_classico.png',11,8),
('Yakissoba clássico - pequeno','Macarrão com carne, frango, legumes e champignons.',29.50,'/img/products/restaurant/chinainbox/yakissoba_classico.png',11,8),
('Hamburguer 150g','Picanha, queijo, creamcheese, cebola, bacon e molho especial.',23.9,'/img/products/restaurant/kanibalburger/hamburguer_150.png',5,9);

DROP TABLE IF EXISTS `tbl_ingrediente`;
CREATE TABLE tbl_ingrediente(
	ingrediente_id INT NOT NULL AUTO_INCREMENT,
	ingrediente_descricao VARCHAR(30),
	ingrediente_valor DECIMAL(4,2),
	PRIMARY KEY(ingrediente_id)	
);

INSERT INTO tbl_ingrediente (ingrediente_descricao,ingrediente_valor) VALUES
('Pão de hamburguer',0.0),
('Pão de hot-dog',0.0),
('Carne bovina',1.0),
('Queijo',0.5),
('Alface',1.5),
('Tomate',1.0),
('Ovo',1.5),
('Bacon',2.0),
('Cebola',0.5),
('Picles',0.1),
('Molho especial',0.0),
('Ketchup',0.0),
('Mostarda',0.0),
('Milho',0.5),
('Vinagrete',0.5),
('Maionese',0.0),
('Batata-palha',0.0),
('Purê de batata',0.0),
('Salsicha',1.5),
('Carne de ave',1.0),
('Macarrão com carne',2.5),
('Legumes',1.5),
('Champignon',2.0),
('Picanha',3.0),
('Creamcheese',1.5);

DROP TABLE IF EXISTS `tbl_produtoingrediente`;
CREATE TABLE tbl_produtoingrediente(
	produto_id INT NOT NULL,
	ingrediente_id INT NOT NULL,
	quantidade INT NOT NULL,
	FOREIGN KEY(produto_id) REFERENCES tbl_produto(produto_id),
	FOREIGN KEY(ingrediente_id) REFERENCES tbl_ingrediente(ingrediente_id)
);

INSERT INTO tbl_produtoingrediente (produto_id,ingrediente_id,quantidade) VALUES
(1,1,1),
(1,3,1),
(1,4,1),
(1,5,1),
(1,6,1),
(2,3,2),
(2,5,1),
(2,4,1),
(2,11,1),
(2,9,1),
(2,10,1),
(2,1,1),
(3,3,1),
(3,5,1),
(3,6,1),
(3,11,1),
(4,1,1),
(4,3,1),
(4,4,1),
(4,10,2),
(4,12,1),
(4,13,1),
(5,4,1),
(5,8,1),
(5,14,1),
(6,4,1),
(6,8,1),
(6,14,1),
(7,2,1),
(7,19,1),
(7,15,1),
(7,14,1),
(7,12,1),
(7,13,1),
(7,17,1),
(7,18,1),
(7,16,1),
(7,4,1),
(8,21,1),
(8,20,1),
(8,22,1),
(8,23,1),
(9,21,1),
(9,20,1),
(9,22,1),
(9,23,1),
(10,24,1),
(10,4,1),
(10,25,1),
(10,9,1),
(10,8,1),
(10,11,1);

DROP TABLE IF EXISTS `tbl_status`;
CREATE TABLE tbl_status(
	status_id INT NOT NULL,
    status_descricao VARCHAR(30),
    PRIMARY KEY(status_id)
);

INSERT INTO tbl_status(status_id, status_descricao) VALUES 
(1, 'Aguardando Pagamento'), 
(2, 'Realizado'), 
(3, 'Confirmado'), 
(4, 'Em preparo'), 
(5, 'Saiu para entrega'),
(6, 'Entregue');

DROP TABLE IF EXISTS `tbl_pedido`;
CREATE TABLE tbl_pedido(
	pedido_id INT NOT NULL AUTO_INCREMENT,
	pedido_data DATE,
    pedido_valorTotal DECIMAL(5, 2) NOT NULL,
	pedido_enderecoEntrega VARCHAR(200),
	entrega_id INT,
	pagamento_id INT,
	usuario_id INT NOT NULL,
    status_id INT NOT NULL,
	PRIMARY KEY(pedido_id),
	FOREIGN KEY(usuario_id) REFERENCES tbl_usuario(usuario_id)
);

DROP TABLE IF EXISTS `tbl_itensPedido`;
CREATE TABLE tbl_itensPedido(
	itensPedido_id INT NOT NULL AUTO_INCREMENT,
	itensPedido_adicionais VARCHAR(500),
	itensPedido_observacao VARCHAR(500),
	pedido_id INT,
	produto_id INT NOT NULL,
    PRIMARY KEY (itensPedido_id), 
	FOREIGN KEY(pedido_id) REFERENCES tbl_pedido(pedido_id),
	FOREIGN KEY(produto_id) REFERENCES tbl_produto(produto_id)
);

DROP TABLE IF EXISTS `tbl_feedback`; 
CREATE TABLE tbl_feedback(
	feedback_id INT NOT NULL AUTO_INCREMENT,
	feedback_notaProduto INT(5) NOT NULL,
	feedback_notaEmbalagem INT(5) NOT NULL,
	feedback_notaEntrega INT(5) NOT NULL,
	feedback_notaAtendimento INT(5) NOT NULL,
	feedback_notaPreco INT(5) NOT NULL,	
	feedback_descricao VARCHAR(300),
	pedido_id INT NOT NULL,
	PRIMARY KEY(feedback_id),
	FOREIGN KEY(pedido_id) REFERENCES tbl_pedido(pedido_id)
);	

DROP TABLE IF EXISTS `tbl_entrega`;
CREATE TABLE tbl_entrega(
	entrega_id INT NOT NULL, 
	entrega_tipo VARCHAR(30),
	PRIMARY KEY(entrega_id)
);

INSERT INTO tbl_entrega(entrega_id, entrega_tipo) VALUES
(1, 'Retirada'),
(2, 'Entrega'),
(3, 'Motoboy');

DROP TABLE IF EXISTS `tbl_formaPagamento`;
CREATE TABLE tbl_formaPagamento(
	formaPagamento_id INT NOT NULL,
	formaPagamento_descricao VARCHAR(30),
	formaPagamento_bandeira VARCHAR(60),
	PRIMARY KEY (formaPagamento_id)
);

INSERT INTO tbl_formaPagamento VALUES 
(0, '', ''),
(1,'band_diners','/img/icon/payment/band_diners.png'),
(2,'band_elo','/img/icon/payment/band_elo.png'),
(3,'band_master','/img/icon/payment/band_master.png'),
(4,'band_visa','/img/icon/payment/band_visa.png'),
(5,'dinheiro','/img/icon/payment/money.png');

DROP TABLE IF EXISTS `tbl_restaurantePagamento`;
CREATE TABLE tbl_restaurantePagamento(
	formaPagamento_id INT NOT NULL,
	restaurante_id INT NOT NULL,
	FOREIGN KEY (formaPagamento_id) REFERENCES tbl_formaPagamento (formaPagamento_id),
	FOREIGN KEY (restaurante_id) REFERENCES tbl_restaurante (restaurante_id)
);

INSERT INTO tbl_restaurantePagamento(formaPagamento_id, restaurante_id) VALUES
(1, 1),
(3, 1),
(5, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(1, 4),
(2, 4),
(3, 4),
(4, 4),
(5, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5),
(1, 6),
(2, 6),
(3, 6),
(4, 6),
(5, 6),
(1, 7),
(2, 7),
(3, 7),
(4, 7),
(5, 7),
(1, 8),
(2, 8),
(3, 8),
(4, 8),
(5, 8),
(1, 9),
(2, 9),
(3, 9),
(4, 9),
(5, 9);
