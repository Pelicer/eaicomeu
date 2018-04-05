DROP DATABASE IF EXISTS `db_sea`;
CREATE DATABASE db_sea;
USE db_sea;

DROP TABLE IF EXISTS `tbl_usuario`;
CREATE TABLE tbl_usuario(
	usuario_id INT NOT NULL AUTO_INCREMENT,
    usuario_cpf VARCHAR(	20) NOT NULL UNIQUE,
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
    usuario_thumbnail VARCHAR(60),
	PRIMARY KEY(usuario_id)
);

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

DROP TABLE IF EXISTS `tbl_login`;
CREATE TABLE tbl_login(
	login_nome VARCHAR(30) NOT NULL,
	login_senha VARCHAR(12) NOT NULL,
	usuario_id INT,
	restaurante_id INT,
	FOREIGN KEY(usuario_id) REFERENCES tbl_usuario(usuario_id),
	FOREIGN KEY(restaurante_id) REFERENCES tbl_restaurante(restaurante_id)
);

DROP TABLE IF EXISTS `tbl_tipo`;
CREATE TABLE tbl_tipo(
	tipo_id INT NOT NULL AUTO_INCREMENT,
	tipo_descricao VARCHAR(30),
	PRIMARY KEY(tipo_id)
);

DROP TABLE IF EXISTS `tbl_produto`;
CREATE TABLE tbl_produto(
	produto_id INT NOT NULL AUTO_INCREMENT,
	produto_nome VARCHAR(30) NOT NULL,
	produto_descricao VARCHAR(120),
	produto_valor DECIMAL(5,2) NOT NULL,
	produto_thumbnail VARCHAR(60),
	tipo_id INT NOT NULL,
	restaurante_id INT NOT NULL,
	PRIMARY KEY(produto_id),
	FOREIGN KEY(tipo_id) REFERENCES tbl_tipo(tipo_id),
	FOREIGN KEY(restaurante_id) REFERENCES tbl_restaurante(restaurante_id)
);

DROP TABLE IF EXISTS `tbl_ingrediente`;
CREATE TABLE tbl_ingrediente(
	ingrediente_id INT NOT NULL AUTO_INCREMENT,
	ingrediente_descricao VARCHAR(30),
	ingrediente_valor DECIMAL(4,2),
	PRIMARY KEY(ingrediente_id)	
);

DROP TABLE IF EXISTS `tbl_produtoingrediente`;
CREATE TABLE tbl_produtoingrediente(
	produto_id INT NOT NULL,
	ingrediente_id INT NOT NULL,
	FOREIGN KEY(produto_id) REFERENCES tbl_produto(produto_id),
	FOREIGN KEY(ingrediente_id) REFERENCES tbl_ingrediente(ingrediente_id)
);

DROP TABLE IF EXISTS `tbl_pedido`;
CREATE TABLE tbl_pedido(
	pedido_id INT NOT NULL AUTO_INCREMENT,
	pedido_data DATETIME,
    pedido_valorTotal DECIMAL(5, 2) NOT NULL,
	usuario_id INT NOT NULL,
	PRIMARY KEY(pedido_id),
	FOREIGN KEY(usuario_id) REFERENCES tbl_usuario(usuario_id)
);

DROP TABLE IF EXISTS `tbl_itensPedido`;
CREATE TABLE tbl_itensPedido(
	pedido_id INT NOT NULL,
	produto_id INT NOT NULL,
	item_quantidade INT NOT NULL,
	ingrediente_id INT NOT NULL,
	FOREIGN KEY(pedido_id) REFERENCES tbl_pedido(pedido_id),
	FOREIGN KEY(produto_id) REFERENCES tbl_produto(produto_id),
	FOREIGN KEY(ingrediente_id) REFERENCES tbl_ingrediente(ingrediente_id)
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