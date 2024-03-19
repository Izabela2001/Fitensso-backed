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

INSERT INTO user (first_name, last_name, email, login, password, phone, account_type_id)
VALUES
    ('Ola', 'Poneta', 'Ola@wp.pl', 'Ola', '$2a$10$Utol7CQ4xsUVR8dIP34lA.rZ8BFVSRtp.HSRgIPoo9BZOHaKlmfHi', '456789123', 2),
    ('Olga', 'Sadokierska', 'Olga@wp.pl', 'Olga', '$2a$10$1IBxHrDWJFQB0MW9L/1cN.VxDgnZwfxI.OGADl0QBtEeUa4ZAWsHi', '147852369', 2),
    ('Iza', 'Najder', 'iza@wp.pl', 'Iza', '$2a$10$qEM4jofX2wYJTT.rljTq.ekftbquXLSLz.PojwnFtPMUngzUW9eDi', '123456789', 2),
    ('Jan', 'Kowalski', 'jan.kowalski@gamil.com', 'jan.kowalski', '$2a$10$sB4twg9dtgQTd9hcfWnQtOG8k3YIWdPTRqqBW5lmZz54VAMwI6Yhy', '123456789', 3),
    ('Anna', 'Nowak', 'anna.nowak@gamil.com', 'anna.nowak', '$2a$10$Zg0qtxfWdutZYiF1U0/XD.ZLLWvLkve7rqqR/X.rNSOcWCMiWMd5y', '987654321', 3),
    ('Piotr', 'Wiśniewski', 'piotr.wisniewski@gmail.com', 'piotr.wisniewski', '$2a$10$SDoaS8RTb2IB/YMcqtGzpO0Cw7/peLUWIu7iQLCUUgGXWkIk8PL4O', '555666777', 3),
    ('Alicja', 'Dąbrowska', 'alicja.dabrowska@gmail.com', 'alicja.dabrowska', '$2a$10$.gbjkNegdLvsxsrajWmh/u9NHZOikM0hMIcErck2PclvaPHBjbXuC', '999888777', 3),
    ('Marcin', 'Lewandowski', 'marcin.lewandowski@gmail.com', 'marcin.lewandowski', '$2a$10$yYdPrJNY5DUFLtGY2oqXnOEoSaWusg90xQnDOE0W9MzlOX54UQeNS', '111223344', 3),
    ('Karolina', 'Wójcik', 'karolina.wojcik@example.com', 'karolina.wojcik', '$2a$10$idAj10/1J9UndneNPpumNeV8Bw1TTrGCjF4k9YRBvGafA4sf7fE02', '555666999', 3),
    ('Michał', 'Kamiński', 'michal.kaminski@example.com', 'michal.kaminski', '$2a$10$ZMZ5HptwK0xiYL7fdjnctuI0ih.TIxcZB.SZ/RLqNFhC80ObFTn3u', '777888999', 3),
    ('Magdalena', 'Jankowska', 'magdalena.jankowska@example.com', 'magdalena.jankowska', '$2a$10$O1.HbxbcOnz1Dp3NjjG/3erQPrGvJOpZb/TodWMZK.UE1Uor8APt.', '111222333', 1),
    ('Artur', 'Szymański', 'artur.szymanski@example.com', 'artur.szymanski', '$2a$10$fBcpZdTwz9l0z5nsSzHWMe3qC/YJ5ummmmPiRqBRvpVsli9vJDwY2', '444555666', 1),
    ('Dominika', 'Witkowska', 'dominika.witkowska@example.com', 'dominika.witkowska', '$2a$10$7bqGLkfm9vaAbF4LjbL81eOKFMKnqcnG8G/27IeqWBfNQSP0LeRBi', '999888777', 1),
    ('Kamil', 'Kowalczyk', 'kamil.kowalczyk@example.com', 'kamil.kowalczyk', '$2a$10$GPJVeFDDSqnOx7Bbx.q3nOUg.peJGMsTzMrtgmWtJJXq3yoMUFYp6', '333222111', 1),
    ('Natalia', 'Mazur', 'natalia.mazur@example.com', 'natalia.mazur', '$2a$10$GPJVeFDDSqnOx7Bbx.q3nOUg.peJGMsTzMrtgmWtJJXq3yoMUFYp6', '666555444', 1),
    ('Bogdan' ,'Marek','bogda@wp.pl','Bogan','Bogdan','789456123',1);


INSERT INTO fitness_class (number_class, fitness_type_class, start_date, end_date, active_place, max_place, user_id)
VALUES (1, 1, '2024-03-06T10:00:00', '2024-03-06T11:30:00', 20, 30, 4),
       (2, 2, '2024-03-07T15:00:00', '2024-03-07T16:30:00', 15, 25, 5),
       (3, 3, '2024-03-08T09:30:00', '2024-03-08T11:00:00', 25, 35, 6),
       (4, 4, '2024-03-09T17:30:00', '2024-03-09T19:00:00', 18, 28, 7),
       (5, 5, '2024-03-10T08:00:00', '2024-03-10T09:30:00', 22, 32, 8);


INSERT INTO reservation (data_reservation, user_id, fitness_class_id, is_accepted)
VALUES ('2024-03-06T13:45:00', 11, 1, false),
       ('2024-03-07T14:30:00', 12, 2, false),
       ('2024-03-08T10:15:00', 13, 3, false),
       ('2024-03-09T16:00:00', 14, 4, false),
       ('2024-03-10T11:45:00', 15, 5, false);


