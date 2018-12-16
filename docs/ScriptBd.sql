CREATE TABLE `persistableUser` (
  `userId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
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

CREATE TABLE `language` (
	`languageId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	CONSTRAINT languageId_pk PRIMARY KEY(languageId)
) ENGINE = InnoDB;

CREATE TABLE `category` (
	`categoryId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	CONSTRAINT categoryId_pk PRIMARY KEY(categoryId)
) ENGINE = InnoDB;

CREATE TABLE `order` (
	`orderId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`userId` int(255) UNSIGNED NOT NULL,
	`creationDate` Date NOT NULL,
	`isPaid` tinyint(1) UNSIGNED NOT NULL,
	CONSTRAINT orderId_pk PRIMARY KEY(orderId),
	CONSTRAINT userId_fk FOREIGN KEY (userId) REFERENCES persistableUser(userId)
) ENGINE = InnoDB;

CREATE TABLE `product` (
	`productId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`categoryId` int(255) UNSIGNED NOT NULL,
	`unitPrice`  decimal(65,2) NOT NULL,
	`vatRate` decimal(5,2) NOT NULL,
	`isSparkling` tinyint(1),
	`isSpicy` tinyint(1),
	`isSweet` tinyint(1),
	CONSTRAINT productId_pk PRIMARY KEY(productId),
	CONSTRAINT categoryId_pk FOREIGN KEY (categoryId) REFERENCES category(categoryId)
) ENGINE = InnoDB;

CREATE TABLE `orderLine` (
	`orderLineId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`productId` int(255) UNSIGNED NOT NULL,
	`orderId` int(255) UNSIGNED NOT NULL,
	`unitPrice` decimal(65,2) NOT NULL,
	`quantity` int(100) NOT NULL,
	CONSTRAINT orderLineId_pk PRIMARY KEY(orderLineId),
	CONSTRAINT orderId_fk FOREIGN KEY (orderId) REFERENCES `order`(orderId),
	CONSTRAINT productId_fk FOREIGN KEY (productId) REFERENCES product(productId)
) ENGINE = InnoDB;

CREATE TABLE `promotion` (
	`promotionId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`starDate` datetime NOT NULL,
	`endDate` datetime NOT NULL,
	`typeChoosenItem` varchar(100) NOT NULL,
	`categoryId` int(255) UNSIGNED,
	`productId` int(255) UNSIGNED,
	`typeReduction` varchar(100) NOT NULL,
	`amountReduction` decimal(65,2) NOT NULL,
	CONSTRAINT promotionId PRIMARY KEY(promotionId),
	CONSTRAINT promotion_productId_fk FOREIGN KEY (productId) REFERENCES product(productId),
	CONSTRAINT promotion_categoryId_fk FOREIGN KEY (categoryId) REFERENCES category(categoryId)
) ENGINE = InnoDB;

CREATE TABLE `translationCategory` (
	`translationId` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
	`categoryId` int(255) UNSIGNED NOT NULL,
	`languageId` int(255) UNSIGNED NOT NULL,
	`content` varchar(200) NOT NULL,
	CONSTRAINT translationId PRIMARY KEY(translationId),
	CONSTRAINT translationCategory_categoryId_fk FOREIGN KEY (categoryId) REFERENCES category(categoryId),
	CONSTRAINT translationCategory_languageId_fk FOREIGN KEY (languageId) REFERENCES language(languageId)
) ENGINE = InnoDB;

INSERT INTO `persistableUser` (`username`, `password`, `authorities`, `nonExpired`, `nonLocked`, `credentialsNonExpired`, `enabled`, `email`, `firstName`, `name`, `addressStreetName`, `addressNumber`, `addressLocality`, `addressPostalCode`, `phoneNumber`, `sexe`)
	VALUES ('Romain', '$2a$10$wLOkmVQNUE.BBKWIPfB94ubutR0yyzq.GepE632M6u6XJgEEuzR9e', 'ROLE_ADMIN', '1', '1', '1', '1', 'contact@rm.be', 'Romain', 'Marbaix', 'Rue du nord', '50', 'Ath', '5000', '0123456789', 'M');


INSERT INTO `language` (`name`)	VALUES ('fr'); #id= 1
INSERT INTO `language` (`name`)	VALUES ('en'); #id= 2

INSERT INTO `category` (`categoryId`) VALUES ('1');
INSERT INTO `category` (`categoryId`) VALUES ('2');
INSERT INTO `category` (`categoryId`) VALUES ('3');
INSERT INTO `category` (`categoryId`) VALUES ('4');
INSERT INTO `category` (`categoryId`) VALUES ('5');
INSERT INTO `category` (`categoryId`) VALUES ('6');

INSERT INTO `translationCategory` (`categoryId`, `languageId`, `content`)
	VALUES
	(1, 1, "Poulet"),
	(1, 2, "Chicken"),
	(2, 1, "Boeuf"),
	(2, 2, "Beef"),
	(3, 1, "Poisson"),
	(3, 2, "Fish"),
	(4, 1, "Vegetarien"),
	(4, 2, "Veggie"),
	(5, 1, "Boissons"),
	(5, 2, "Drinks"),
	(6, 1, "Sauce"),
	(6, 2, "sauce");

INSERT INTO `product` (`categoryId`,`name`, `unitPrice`, `vatRate`,`isSparkling`,`isSpicy`,`isSweet`)
	VALUES
	(1,'Chicken Burger',5.00,12.00,0,0,0),
	(1,'Spicytender Burger',6.00,12.00,0,0,1),
	(1,'Birdy Burger',5.00,12.00,0,0,0),
	(2,'Classic Burger',2.00,12.00,0,0,0),
	(2,'Tiny Burger',0.50,12.00,0,0,0),
	(2,'Spicy Burger',3.00,12.00,0,0,1),
	(3,'Fish Burger',5.00,12.00,0,0,0),
	(3,'Flipper Burger',4.00,12.00,0,0,0),
	(3,'Goldfish Burger',2.00,12.00,0,0,0),
	(4,'Forest Burger',4.00,12.00,0,0,0),
	(4,'Jungle Burger',5.00,12.00,0,0,0),
	(4,'Savana Burger',6.00,12.00,0,0,1),
	(5,'Water',0.60,6.00,0,0,0),
	(5,'Soda',1.00,6.00,1,0,0),
	(5,'Cola',1.50,6.00,1,0,0),
	(5,'Fanta',1.50,6.00,1,0,0),
	(5,'Sprite',1.50,6.00,1,0,0),
	(5,'Limonade',1.30,6.00,1,0,0),
	(5,'Iced Tea',1.50,6.00,0,0,0),
	(6,'Mayonnaise',0.30,6.00,0,0,0),
	(6,'Ketchup',0.30,6.00,0,0,1),
	(6,'Andalouse',0.30,6.00,0,1,0),
	(6,'Samourai',0.30,6.00,0,1,0),
	(6,'Curry',0.30,6.00,0,0,1),
	(6,'Coktail',0.30,6.00,0,0,1),
	(6,'Burger',0.30,6.00,0,0,0);

