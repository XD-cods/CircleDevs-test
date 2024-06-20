CREATE TABLE bank (
                      bank_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      bank_title VARCHAR NOT NULL
);

CREATE TABLE customer (
                          customer_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          first_name VARCHAR NOT NULL,
                          last_name VARCHAR NOT NULL,
                          bank_id INTEGER REFERENCES bank(bank_id)
);

CREATE TABLE account (
                         account_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         username VARCHAR NOT NULL,
                         password VARCHAR NOT NULL,
                         cash_amount BIGINT,
                         customer_id INTEGER REFERENCES customer(customer_id)
);
