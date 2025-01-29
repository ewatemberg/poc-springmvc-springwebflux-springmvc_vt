CREATE TABLE users_test_mid
(
    id BIGSERIAL PRIMARY KEY,
    customer_id       VARCHAR(255),
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    company           VARCHAR(255),
    city              VARCHAR(255),
    country           VARCHAR(255),
    phone1            VARCHAR(255),
    phone2            VARCHAR(255),
    email             VARCHAR(255),
    subscription_date DATE,
    website           VARCHAR(255)
);
