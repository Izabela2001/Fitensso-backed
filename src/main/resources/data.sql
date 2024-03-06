INSERT INTO account_types (name_type) VALUES
   ('customer'),
    ('admin'),
    ('worker');
INSERT INTO fitness_type_class (name_type_fitness) VALUES
    ('Joga'),
    ('ABS'),
    ('Workaut leg'),
    ('Strech'),
    ('Kickboxing');
INSERT INTO account (login, password, account_type_id)
VALUES
    ('Ola','Ola',2),
    ('Iza','Iza',2),
    ('Bogadna15','Password',3),
    ('Jola15','Password1',3),
    ('Kacper2','Password3',3),
    ('Waldek','zaza',1),
    ('Miahcał','ppp',1);
INSERT INTO user (first_name, last_name, email, phone, account_id)
VALUES ('Aleksandra', 'Poneta', 'Ola@wp.pl', null, 1),
       ('Izabela', 'Najder', 'iza@example.com', null, 2),
       ('Bogdan', 'Bogdan', 'bogdan@wp.pl', null, 3);

INSERT INTO fitness_class (number_class, fitness_type_class, start_date, end_date, active_place, max_place, id_account)
VALUES (1, 1, '2024-03-06T10:00:00', '2024-03-06T11:30:00', 20, 30, 3),
       (2, 2, '2024-03-07T15:00:00', '2024-03-07T16:30:00', 15, 25, 4),
       (3, 1, '2024-03-08T09:30:00', '2024-03-08T11:00:00', 25, 35, 5),
       (4, 3, '2024-03-09T17:30:00', '2024-03-09T19:00:00', 18, 28, 5),
       (5, 2, '2024-03-10T08:00:00', '2024-03-10T09:30:00', 22, 32, 5);


INSERT INTO reservation (data_reservation, account_id, fitness_class_id, is_accepted)
VALUES ('2024-03-06T13:45:00', 1, 1, false),
       ('2024-03-07T14:30:00', 2, 2, false),
       ('2024-03-08T10:15:00', 3, 3, false),
       ('2024-03-09T16:00:00', 4, 4, false),
       ('2024-03-10T11:45:00', 5, 5, false);


