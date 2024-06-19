БД - PostgreSQL

**Для создания БД**

```sql
CREATE TABLE bank (
    bank_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    bank_title VARCHAR NOT NULL,
    address VARCHAR NOT NULL
);

CREATE TABLE customer (
    customer_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    bank_id INTEGER REFERENCES bank(bank_id)
);

CREATE TABLE account (
    account_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY OVERRIDING SYSTEM VALUE,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    cash_amount BIGINT,
    customer_id INTEGER REFERENCES customer(customer_id)
);
```

**Для заполнения БД**
```sql

INSERT INTO bank (bank_title, address) VALUES
                                           ('Bank of America', '123 Main St, New York, NY'),
                                           ('Chase Bank', '456 Oak Ave, Los Angeles, CA'),
                                           ('Wells Fargo', '789 Elm St, Chicago, IL'),
                                           ('Citibank', '567 Pine Ave, Houston, TX'),
                                           ('TD Bank', '890 Maple Rd, Miami, FL'),
                                           ('PNC Bank', '234 Birch St, San Francisco, CA'),
                                           ('US Bank', '321 Cedar Ave, Boston, MA'),
                                           ('SunTrust Bank', '876 Walnut St, Seattle, WA'),
                                           ('Capital One', '543 Chestnut Ave, Denver, CO'),
                                           ('HSBC', '654 Oakwood Blvd, Dallas, TX');

INSERT INTO customer (first_name, last_name, bank_id) VALUES
                                                          ('Emily', 'Johnson', 2),
                                                          ('Michael', 'Williams', 3),
                                                          ('Jessica', 'Jones', 4),
                                                          ('Daniel', 'Brown', 5),
                                                          ('Sarah', 'Davis', 6),
                                                          ('Christopher', 'Miller', 7),
                                                          ('Jennifer', 'Wilson', 8),
                                                          ('SergioGonzalez', 'Moore', 9),
                                                          ('MiraTu', 'PaulaHarris', 9),
                                                          ('VijaySharma', 'MamadouAslam', 9),
                                                          ('MarthaCampos', 'MichaelZhao', 9);


INSERT INTO account (username, password, cash_amount, customer_id) VALUES
                                                                       ('jsmith', 'password1', 50000, 1),
                                                                       ('ejohnson', 'password2', 75000, 2),
                                                                       ('mwilliams', 'password3', 100000, 3),
                                                                       ('jjones', 'password4', 25000, 4),
                                                                       ('dbrown', 'password5', 30000, 5),
                                                                       ('sdavis', 'password6', 60000, 6),
                                                                       ('cmiller', 'password7', 80000, 7),
                                                                       ('jwilson', 'password8', 45000, 8),
                                                                       ('dmoore', 'password9', 55000, 9)


```
