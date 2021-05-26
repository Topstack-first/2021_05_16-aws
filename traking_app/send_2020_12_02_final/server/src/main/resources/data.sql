/*Demonstration Script*/

/*Insertion in the table PAKAGE*/
INSERT INTO PAKAGE VALUES(1,'true','false',10,20,1,'CAS20',10,'CD1236598',30,2,15,10);
INSERT INTO PAKAGE VALUES(2,'true','false',20,30,1,'CAS30',10,'9658FF56',40,2,15,20);
INSERT INTO PAKAGE VALUES(3,'true','false',30,30,2,'M3',10,'36JJ369',40,2,15,20);

/*Insertion in the table COUNTRIES*/
INSERT INTO COUNTRIES VALUES(1,'+32','Belgium','BE');
INSERT INTO COUNTRIES VALUES(2,'+33','France','FR');
INSERT INTO COUNTRIES VALUES(3,'+31','Netherlands','NL');

/*Insertion in the DELIVERY_ADDRESS*/
INSERT INTO DELIVERY_ADDRESS VALUES(1,'boulevard maurice lemonnier 13','','brussels','','2020-11-02 22:10:00','Olivier','Goossens','','045896525875','1000','2020-01-07 22:10:00',1);
INSERT INTO DELIVERY_ADDRESS VALUES(2,'1 Rue Henry Giffard','','Montigny-le-Bretonneux','Johnson Controls','2020-11-02 22:10:00','Kamal','Chadi','','06000025000','78180','2020-01-07 22:10:00',2);

/*Insertion in the table SHIPMENT*/
INSERT INTO SHIPMENT VALUES(1,'false','true',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149912&lc=fr-BE','8296149912','2020-11-02 22:10:00',100,'true',1,1,3,10235,'false','false',1,'OH9632589658',12,14,'2020-01-07 22:10:00',250,1,1);
INSERT INTO SHIPMENT VALUES(2,'false','true',0.3,'Colisprive','https://www.colisprive.com/moncolis/pages/detailColis.aspx?numColis=W5000051554859430','W5000051554859430','2020-11-02 22:10:00',100,'true',1,1,1,10239,'false','false',1,'OH1236549875',12,14,'2020-01-07 22:10:00',500,2,2);
INSERT INTO SHIPMENT VALUES(3,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,2,10239,'false','false',1,'OH0002325623',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(4,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,2,10239,'false','false',1,'OH0002320000',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(5,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,3,10239,'false','false',1,'OH0002320011',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(6,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,3,10239,'false','false',1,'OH0002311499',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(7,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,1,10239,'false','false',1,'OH9999999999',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(8,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,1,10239,'false','false',1,'OH1111111111',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(9,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,1,10239,'false','false',1,'OH2222222222',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(10,'false','false',0.3,'DHL','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,1,10239,'false','false',1,'OH3333333333',12,14,'2020-01-07 22:10:00',300,2,2);
INSERT INTO SHIPMENT VALUES(11,'false','false',0.3,'UPS','https://www.dhlparcel.be/fr/particuliers/suivre-un-colis?tc=8296149002&lc=fr-BE','8296149002','2020-11-02 22:10:00',0,'true',1,1,1,10239,'false','false',1,'OH4444444444',12,14,'2020-01-07 22:10:00',300,2,2);
/*Insertion in the table STATUS*/
INSERT INTO STATUS VALUES(1,'false','Colis en cours de préparation',null);
INSERT INTO STATUS VALUES(2,'true','Il y''a eu un problème avec votre envoi avant sa remise au transporteur partenaire. X vous en informe en temps réels par e-mail',null);
INSERT INTO STATUS VALUES(3,'true','Adresse incorrecte',2);
INSERT INTO STATUS VALUES(4,'true','Contenu reçu endommagé',2);
INSERT INTO STATUS VALUES(5,'true','Contenus hors format',2);
INSERT INTO STATUS VALUES(6,'false','Colis prêt à être pris en charge par',null);
INSERT INTO STATUS VALUES(7,'false','Le colis a été expédié par X',null);
INSERT INTO STATUS VALUES(8,'false','En cours d''acheminement',null);
INSERT INTO STATUS VALUES(9,'false','Votre colis est arrivé sur son site de distribution',null);
INSERT INTO STATUS VALUES(10,'false','Votre colis est prêt à être livré et en attente de livraison',null);
INSERT INTO STATUS VALUES(11,'true','Il y a un problème durant l''acheminement du colis',null);
INSERT INTO STATUS VALUES(12,'true','Adresse erronée/incomplète',11);
INSERT INTO STATUS VALUES(13,'true','Colis endommagé',11);
INSERT INTO STATUS VALUES(14,'true','Demande de retour émise',11);
INSERT INTO STATUS VALUES(15,'true','Documents de douanes manquants',11);
INSERT INTO STATUS VALUES(16,'false','En cours de livraison',null);
INSERT INTO STATUS VALUES(17,'false','Votre colis est disponible en point de retrait. Retrouvez son adresse dans votre suivi transporteur',null);
INSERT INTO STATUS VALUES(18,'true','La livraison au destinataire a échoué',null);
INSERT INTO STATUS VALUES(19,'true','L''adresse est incorrecte/inaccessible',18);
INSERT INTO STATUS VALUES(20,'true','Le destinataire est absent',18);
INSERT INTO STATUS VALUES(21,'true','Aucune mention du nom du destinataire n''est faite à l''adresse indiquée',18);
INSERT INTO STATUS VALUES(22,'false','livré',null);

/*Insertion in the table SHIPMENT_STATUS*/
/*if (ourTrackingNumber : OH9632589658)*/
INSERT INTO SHIPMENT_STATUS VALUES(1,'2020-11-02 22:10:00',1,1);
INSERT INTO SHIPMENT_STATUS VALUES(2,'2020-11-02 22:10:00',1,6);
INSERT INTO SHIPMENT_STATUS VALUES(3,'2020-11-03 22:10:00',1,7);
/*if (ourTrackingNumber : OH1236549875)*/
INSERT INTO SHIPMENT_STATUS VALUES(4,'2020-11-03 22:10:00',2,1);
INSERT INTO SHIPMENT_STATUS VALUES(5,'2020-11-04 22:10:00',2,6);
INSERT INTO SHIPMENT_STATUS VALUES(6,'2020-11-04 22:10:00',2,7);
INSERT INTO SHIPMENT_STATUS VALUES(7,'2020-11-04 22:10:00',2,8);
/*if (ourTrackingNumber : OH0002325623)*/
INSERT INTO SHIPMENT_STATUS VALUES(8,'2020-11-02 22:10:00',3,1);
INSERT INTO SHIPMENT_STATUS VALUES(9,'2020-11-02 22:10:00',3,6);
INSERT INTO SHIPMENT_STATUS VALUES(10,'2020-11-03 22:10:00',3,7);
INSERT INTO SHIPMENT_STATUS VALUES(11,'2020-11-04 22:10:00',3,8);
INSERT INTO SHIPMENT_STATUS VALUES(12,'2020-11-05 22:10:00',3,9);
INSERT INTO SHIPMENT_STATUS VALUES(13,'2020-11-06 22:10:00',3,10);
/*if (ourTrackingNumber : OH0002320000)*/
INSERT INTO SHIPMENT_STATUS VALUES(14,'2020-11-02 22:10:00',4,1);
INSERT INTO SHIPMENT_STATUS VALUES(15,'2020-11-02 22:10:00',4,6);
INSERT INTO SHIPMENT_STATUS VALUES(16,'2020-11-03 22:10:00',4,7);
INSERT INTO SHIPMENT_STATUS VALUES(17,'2020-11-03 22:10:00',4,8);
INSERT INTO SHIPMENT_STATUS VALUES(18,'2020-11-03 22:10:00',4,9);
INSERT INTO SHIPMENT_STATUS VALUES(19,'2020-11-03 22:10:00',4,10);
INSERT INTO SHIPMENT_STATUS VALUES(20,'2020-11-05 22:10:00',4,16);
/*if (ourTrackingNumber : OH0002320011)*/
INSERT INTO SHIPMENT_STATUS VALUES(21,'2020-11-02 22:10:00',5,1);
INSERT INTO SHIPMENT_STATUS VALUES(22,'2020-11-02 22:10:00',5,6);
INSERT INTO SHIPMENT_STATUS VALUES(23,'2020-11-02 22:10:00',5,7);
INSERT INTO SHIPMENT_STATUS VALUES(24,'2020-11-02 22:10:00',5,8);
INSERT INTO SHIPMENT_STATUS VALUES(25,'2020-11-02 22:10:00',5,9);
INSERT INTO SHIPMENT_STATUS VALUES(26,'2020-11-02 22:10:00',5,10);
INSERT INTO SHIPMENT_STATUS VALUES(27,'2020-11-02 22:10:00',5,17);
/*if (ourTrackingNumber : OH0002311499)*/
INSERT INTO SHIPMENT_STATUS VALUES(28,'2020-11-02 22:10:00',6,1);
INSERT INTO SHIPMENT_STATUS VALUES(29,'2020-11-02 22:10:00',6,6);
INSERT INTO SHIPMENT_STATUS VALUES(30,'2020-11-02 22:10:00',6,7);
INSERT INTO SHIPMENT_STATUS VALUES(31,'2020-11-02 22:10:00',6,8);
INSERT INTO SHIPMENT_STATUS VALUES(32,'2020-11-02 22:10:00',6,9);
INSERT INTO SHIPMENT_STATUS VALUES(33,'2020-11-03 22:10:00',6,10);
INSERT INTO SHIPMENT_STATUS VALUES(34,'2020-11-03 22:10:00',6,17);
INSERT INTO SHIPMENT_STATUS VALUES(35,'2020-11-04 22:10:00',6,22);
/*if (ourTrackingNumber : OH9999999999)*/
INSERT INTO SHIPMENT_STATUS VALUES(36,'2020-11-02 22:10:00',7,1);
INSERT INTO SHIPMENT_STATUS VALUES(37,'2020-11-02 22:10:00',7,6);
INSERT INTO SHIPMENT_STATUS VALUES(38,'2020-11-03 22:10:00',7,7);
INSERT INTO SHIPMENT_STATUS VALUES(39,'2020-11-03 22:10:00',7,8);
INSERT INTO SHIPMENT_STATUS VALUES(40,'2020-11-03 22:10:00',7,9);
INSERT INTO SHIPMENT_STATUS VALUES(41,'2020-11-03 22:10:00',7,10);
INSERT INTO SHIPMENT_STATUS VALUES(42,'2020-11-03 22:10:00',7,16);
INSERT INTO SHIPMENT_STATUS VALUES(43,'2020-11-05 22:10:00',7,22);
/*if (ourTrackingNumber : OH1111111111)*/
INSERT INTO SHIPMENT_STATUS VALUES(44,'2020-11-02 22:10:00',8,1);
INSERT INTO SHIPMENT_STATUS VALUES(45,'2020-11-02 22:10:00',8,1);
INSERT INTO SHIPMENT_STATUS VALUES(46,'2020-11-02 22:10:00',8,2);
INSERT INTO SHIPMENT_STATUS VALUES(47,'2020-11-02 22:10:00',8,3);
INSERT INTO SHIPMENT_STATUS VALUES(48,'2020-11-02 22:10:00',8,3);
/*if (ourTrackingNumber : OH2222222222)*/
INSERT INTO SHIPMENT_STATUS VALUES(50,'2020-11-02 22:10:00',9,1);
INSERT INTO SHIPMENT_STATUS VALUES(51,'2020-11-02 22:10:00',9,2);
INSERT INTO SHIPMENT_STATUS VALUES(52,'2020-11-02 22:10:00',9,3);
INSERT INTO SHIPMENT_STATUS VALUES(53,'2020-11-02 22:10:00',9,6);
INSERT INTO SHIPMENT_STATUS VALUES(54,'2020-11-05 22:10:00',9,7);
INSERT INTO SHIPMENT_STATUS VALUES(55,'2020-11-05 22:10:00',9,8);
INSERT INTO SHIPMENT_STATUS VALUES(56,'2020-11-05 22:10:00',9,9);
INSERT INTO SHIPMENT_STATUS VALUES(57,'2020-11-05 22:10:00',9,10);
INSERT INTO SHIPMENT_STATUS VALUES(58,'2020-11-05 22:10:00',9,11);
INSERT INTO SHIPMENT_STATUS VALUES(59,'2020-11-07 22:10:00',9,15);
/*if (ourTrackingNumber : OH3333333333)*/
INSERT INTO SHIPMENT_STATUS VALUES(60,'2020-11-02 22:10:00',10,1);
INSERT INTO SHIPMENT_STATUS VALUES(61,'2020-11-02 22:10:00',10,2);
INSERT INTO SHIPMENT_STATUS VALUES(62,'2020-11-02 22:10:00',10,3);
INSERT INTO SHIPMENT_STATUS VALUES(63,'2020-11-02 22:10:00',10,6);
INSERT INTO SHIPMENT_STATUS VALUES(64,'2020-11-02 22:10:00',10,7);
INSERT INTO SHIPMENT_STATUS VALUES(65,'2020-11-02 22:10:00',10,8);
INSERT INTO SHIPMENT_STATUS VALUES(66,'2020-11-06 22:10:00',10,9);
INSERT INTO SHIPMENT_STATUS VALUES(67,'2020-11-02 22:10:00',10,10);
INSERT INTO SHIPMENT_STATUS VALUES(68,'2020-11-02 22:10:00',10,11);
INSERT INTO SHIPMENT_STATUS VALUES(69,'2020-11-02 22:10:00',10,15);
INSERT INTO SHIPMENT_STATUS VALUES(70,'2020-11-07 22:10:00',10,15);
INSERT INTO SHIPMENT_STATUS VALUES(71,'2020-11-08 22:10:00',10,15);
/*if (ourTrackingNumber : OH4444444444)
INSERT INTO SHIPMENT_STATUS VALUES(72,'2020-11-02 22:10:00',11,1);
INSERT INTO SHIPMENT_STATUS VALUES(73,'2020-11-02 22:11:00',11,2);
INSERT INTO SHIPMENT_STATUS VALUES(74,'2020-11-03 22:12:00',11,3);
INSERT INTO SHIPMENT_STATUS VALUES(75,'2020-11-03 22:13:00',11,6);
INSERT INTO SHIPMENT_STATUS VALUES(76,'2020-11-03 22:14:00',11,7);
INSERT INTO SHIPMENT_STATUS VALUES(77,'2020-11-03 22:15:00',11,8);
INSERT INTO SHIPMENT_STATUS VALUES(78,'2020-11-03 22:16:00',11,9);
INSERT INTO SHIPMENT_STATUS VALUES(79,'2020-11-03 22:17:00',11,10);
INSERT INTO SHIPMENT_STATUS VALUES(80,'2020-11-03 22:18:00',11,11);
INSERT INTO SHIPMENT_STATUS VALUES(81,'2020-11-03 22:19:00',11,15);
INSERT INTO SHIPMENT_STATUS VALUES(82,'2020-11-04 22:20:00',11,15);
INSERT INTO SHIPMENT_STATUS VALUES(83,'2020-11-04 22:21:00',11,15);
INSERT INTO SHIPMENT_STATUS VALUES(84,'2020-11-04 22:22:00',11,16);
INSERT INTO SHIPMENT_STATUS VALUES(85,'2020-11-04 22:23:00',11,22);
*/
INSERT INTO SHIPMENT_STATUS VALUES(72,'2020-11-02 22:10:00',11,1);
INSERT INTO SHIPMENT_STATUS VALUES(73,'2020-11-02 22:11:00',11,2);
INSERT INTO SHIPMENT_STATUS VALUES(74,'2020-11-03 22:12:00',11,3);
INSERT INTO SHIPMENT_STATUS VALUES(75,'2020-11-03 22:13:00',11,6);
INSERT INTO SHIPMENT_STATUS VALUES(76,'2020-11-03 22:14:00',11,7);
INSERT INTO SHIPMENT_STATUS VALUES(77,'2020-11-03 22:15:00',11,8);
INSERT INTO SHIPMENT_STATUS VALUES(78,'2020-11-03 22:16:00',11,9);
INSERT INTO SHIPMENT_STATUS VALUES(79,'2020-11-03 22:17:00',11,10);
INSERT INTO SHIPMENT_STATUS VALUES(80,'2020-11-03 22:18:00',11,11);
INSERT INTO SHIPMENT_STATUS VALUES(81,'2020-11-03 22:18:00',11,12);
INSERT INTO SHIPMENT_STATUS VALUES(82,'2020-11-03 22:18:00',11,13);
INSERT INTO SHIPMENT_STATUS VALUES(83,'2020-11-03 22:18:00',11,14);
INSERT INTO SHIPMENT_STATUS VALUES(84,'2020-11-03 22:18:00',11,15);
INSERT INTO SHIPMENT_STATUS VALUES(85,'2020-11-03 22:18:00',11,16);
INSERT INTO SHIPMENT_STATUS VALUES(86,'2020-11-03 22:18:00',11,17);
INSERT INTO SHIPMENT_STATUS VALUES(87,'2020-11-03 22:18:00',11,18);
INSERT INTO SHIPMENT_STATUS VALUES(88,'2020-11-03 22:18:00',11,19);
INSERT INTO SHIPMENT_STATUS VALUES(89,'2020-11-03 22:18:00',11,20);
INSERT INTO SHIPMENT_STATUS VALUES(90,'2020-11-03 22:18:00',11,21);
INSERT INTO SHIPMENT_STATUS VALUES(91,'2020-11-03 22:18:00',11,22);