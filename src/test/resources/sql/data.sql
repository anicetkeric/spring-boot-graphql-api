-- init data
INSERT INTO author (id, firstname, lastname)
VALUES (1, 'Bree', 'Nasim'),
       (2, 'Kessie', 'Brenden');


INSERT INTO book (id, description, isbn, page, price, title, author_id)
VALUES (1, 'This book covers the basics of Spring Boot and graphQL', 'X4J-5H8', 416, 529, 'Demo Spring boot graphQL', 1),
       (2, 'mollis non,', 'M3Q 4G1', 15, 668, 'Nullam ut', 2);

