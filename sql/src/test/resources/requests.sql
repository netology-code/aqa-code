INSERT INTO users (id, login, password)
VALUES (1, "vasya", "password");

INSERT INTO users (id, login, password)
VALUES (2, "petya", "password");

INSERT INTO cards (id, user_id, number, balance_in_kopecks)
VALUES (1, 1, "5559000000000001", 1000000),
       (2, 1, "5559000000000002", 1000000);

INSERT INTO card_transactions (source, target, amount_in_kopecks)
VALUES ("5559000000000001", "5559000000000002", 10000);

UPDATE cards
SET balance_in_kopecks = balance_in_kopecks - 10000
WHERE number = "5559000000000001";

UPDATE cards
SET balance_in_kopecks = balance_in_kopecks + 10000
WHERE number = "5559000000000002";

DELETE FROM auth_codes WHERE created < NOW() - INTERVAL 5 MINUTE;

-- выборка всех столбцов и всех строк из таблицы users (будьте осторожны на больших таблицах)
SELECT * FROM users;
-- выборка только определённых столбцов
SELECT id, login FROM users;
-- выборка по условию
SELECT balance_in_kopecks FROM cards WHERE number = "5559000000000002";
-- вычисляемые столбцы
SELECT balance_in_kopecks / 100 AS balance_in_rub FROM cards WHERE number = "5559000000000002";

SELECT max(cards.balance_in_kopecks) FROM cards;

SELECT sum(balance_in_kopecks) FROM cards WHERE user_id = 1;

SELECT count(*), user_id FROM cards GROUP BY user_id;