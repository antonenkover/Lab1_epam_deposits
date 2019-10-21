use deposit_db;

INSERT INTO bank VALUES (NULL, 'Privat Bank');
INSERT INTO bank VALUES (NULL, 'Mono Bank');
INSERT INTO bank VALUES (NULL, 'Alpha Bank');

INSERT INTO deposit_type VALUES (NULL, 'Taxed deposit');
INSERT INTO deposit_type VALUES (NULL, 'Auto prolongated deposit');
INSERT INTO deposit_type VALUES (NULL, 'Frequency strict deposit');

INSERT INTO deposit VALUES(NULL, 1, 'StandartPB', 150, 0, 1, 16, 1);
INSERT INTO deposit VALUES(NULL, 2, 'Strict9PB', 1000, 0, 0, 27, 1);
INSERT INTO deposit VALUES(NULL, 3, 'NiceDepositPB', 15000, 1, 1, 6, 1);

INSERT INTO deposit VALUES(NULL, 1, 'StandartMB', 200, 0, 1, 12, 2);
INSERT INTO deposit VALUES(NULL, 2, 'StrictMB', 2000, 0, 1, 24, 2);
INSERT INTO deposit VALUES(NULL, 3, 'NiceDepositMB', 500, 0, 1, 36, 2);

INSERT INTO deposit VALUES(NULL, 1, 'StandartAB', 3000, 0, 0, 6, 3);
INSERT INTO deposit VALUES(NULL, 2, 'StrictAB', 10000, 0, 0, 9, 3);
INSERT INTO deposit VALUES(NULL, 3, 'NiceDepositAB', 1000, 0, 13, 16, 3);

INSERT INTO taxed_deposit VALUES (1, 1, 3);
INSERT INTO taxed_deposit VALUES (4, 1, 5);
INSERT INTO taxed_deposit VALUES (7, 1, 7);

INSERT INTO auto_prolonged_deposit VALUES (2, 2, 1);
INSERT INTO auto_prolonged_deposit VALUES (5, 2, 0);
INSERT INTO auto_prolonged_deposit VALUES (8, 2, 0);

INSERT INTO frequency_strict_deposit VALUES (3, 3, 9);
INSERT INTO frequency_strict_deposit VALUES (6, 3, 3);
INSERT INTO frequency_strict_deposit VALUES (9, 3, 6);