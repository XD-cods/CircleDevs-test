
INSERT INTO bank (bank_title) VALUES
                                  ('Bank of America'),
                                           ('Chase Bank'),
                                           ('Wells Fargo'),
                                           ('Citibank'),
                                           ('TD Bank'),
                                           ('PNC Bank'),
                                           ('US Bank'),
                                           ('SunTrust Bank'),
                                           ('Capital One'),
                                           ('HSBC');

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

