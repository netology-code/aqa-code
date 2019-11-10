DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    login    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

DROP TABLE IF EXISTS cards;
CREATE TABLE cards
(
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    user_id            INT NOT NULL,
    number             VARCHAR(19) UNIQUE NOT NULL,
    balance_in_kopecks INT                NOT NULL DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS auth_codes;
CREATE TABLE auth_codes
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    code    VARCHAR(6) NOT NULL,
    created TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS card_transactions;
CREATE TABLE card_transactions
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    source            VARCHAR(19) NOT NULL,
    target            VARCHAR(19) NOT NULL,
    amount_in_kopecks INT         NOT NULL,
    created           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);
