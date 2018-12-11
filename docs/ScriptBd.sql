CREATE TABLE `persistableUser` (
  `userId` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `authorities` varchar(500) DEFAULT NULL,
  `nonExpired` tinyint(1) DEFAULT NULL,
  `nonLocked` tinyint(1) DEFAULT NULL,
  `credentialsNonExpired` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `addressStreetName` varchar(300) NOT NULL,
  `addressNumber` varchar(20) NOT NULL,
  `addressBox` varchar(20),
  `addressLocality` varchar(50) NOT NULL,
  `addressPostalCode` int(10) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `sexe` varchar(1),
  CONSTRAINT userId_pk PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE language
(	languageId int(255) NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	CONSTRAINT languageId_pk PRIMARY KEY(languageId)
)ENGINE = InnoDB;

CREATE TABLE category
(	categoryId int(255) NOT NULL AUTO_INCREMENT,
	CONSTRAINT categoryId_pk PRIMARY KEY(categoryId)
)ENGINE = InnoDB;

CREATE TABLE order
(	orderId int(255) NOT NULL AUTO_INCREMENT,
	userId int(255) NOT NULL,
	creationDate Date NOT NULL,
	isPaid tinyint(1) NOT NULL,
	CONSTRAINT orderId_pk PRIMARY KEY(orderId),
	CONSTRAINT userId_fk FOREIGN KEY (userId) REFERENCES persistableUser(userId)
)ENGINE = InnoDB;

CREATE TABLE product
(	productId int(255) NOT NULL AUTO_INCREMENT,
	categoryId int(255) NOT NULL,
	unitPrice  decimal(100,2) NOT NULL,
	vatRate int(100) NOT NULL,
	type varchar(100) NOT NULL,
	isSparkling tinyint(1),
	isSpicy tinyint(1),
	isSweet tinyint(1),
	CONSTRAINT productId_pk PRIMARY KEY(productId),
	CONSTRAINT categoryId_pk FOREIGN KEY (categoryId) REFERENCES category(categoryId)
)ENGINE = InnoDB;

CREATE TABLE orderLine
(	orderLineId int(255) NOT NULL AUTO_INCREMENT,
	productId int(255) NOT NULL,
	orderId int(255) NOT NULL,
	unitPrice  decimal(100,2) NOT NULL,
	quantity int(100) NOT NULL,
	CONSTRAINT orderLineId_pk PRIMARY KEY(orderLineId),
	CONSTRAINT orderId_fk FOREIGN KEY (orderId) REFERENCES order(orderId),
	CONSTRAINT productId_fk FOREIGN KEY (productId) REFERENCES product(productId)
)ENGINE = InnoDB;

CREATE TABLE promotion
(	promotionId int(255) NOT NULL AUTO_INCREMENT,
	starDate Date NOT NULL,
	endDate Date NOT NULL,
	typeChoosenItem varchar(100) NOT NULL,
	categoryId int(255),
	productId int(255),
	typeReduction varchar(100) NOT NULL,
	amountReduction decimal(100,2) NOT NULL,
	CONSTRAINT promotionId PRIMARY KEY(promotionId),
	CONSTRAINT productId_fk FOREIGN KEY (productId) REFERENCES product(productId),
	CONSTRAINT categoryId_fk FOREIGN KEY (categoryId) REFERENCES category(categoryId)
)ENGINE = InnoDB;

CREATE TABLE translationProduct
(	translationId int(255) NOT NULL AUTO_INCREMENT,
	productId int(255) NOT NULL,
	languageId int(255) NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(200) NOT NULL,
	CONSTRAINT translationId PRIMARY KEY(translationId),
	CONSTRAINT productId_fk FOREIGN KEY (productId) REFERENCES product(productId),
	CONSTRAINT languageId_fk FOREIGN KEY (languageId) REFERENCES language(languageId)
)ENGINE = InnoDB;

CREATE TABLE translationCategory
(	translationId int(255) NOT NULL AUTO_INCREMENT,
	categoryId int(255) NOT NULL,
	languageId int(255) NOT NULL,
	content varchar(200) NOT NULL,
	CONSTRAINT translationId PRIMARY KEY(translationId),
	CONSTRAINT categoryId_fk FOREIGN KEY (categoryId) REFERENCES category(categoryId),
	CONSTRAINT languageId_fk FOREIGN KEY (languageId) REFERENCES language(languageId)
)ENGINE = InnoDB;