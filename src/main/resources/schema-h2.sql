CREATE TABLE guest(email VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255), phone VARCHAR(20), register_date DATETIME);

CREATE TABLE hotel(id VARCHAR(255) PRIMARY KEY,
                   name VARCHAR(255), stars INT);

CREATE TABLE room(hotel VARCHAR(255), room_number INT, room_type VARCHAR(50), cost_per_night LONG,
                    reservation_id INT, primary key (hotel, room_number));

CREATE TABLE reservation(id INT PRIMARY KEY AUTO_INCREMENT, guest VARCHAR(255),
                  hotel VARCHAR(255), room INT, check_in_date DATE, check_out_date DATE);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 2 INCREMENT BY 1;

INSERT INTO guest(name, email, phone) VALUES('Andika', 'andika@gmail.com', '+62123567');
INSERT INTO guest(name, email, phone) VALUES('Messi', 'messi@gmail.com', '+60123567');
INSERT INTO guest(name, email, phone) VALUES('Zidane', 'zidane@gmail.com', '+02123567');

INSERT INTO hotel(id, name, stars) VALUES('HiltonKL', 'Hilton Kuala Lumpur', 5);
INSERT INTO hotel(id, name, stars) VALUES('DorsettKL', 'Dorsett Kuala Lumpur', 4);

INSERT INTO room(hotel, room_number, room_type, cost_per_night, reservation_id) VALUES('HiltonKL', 111, 'Suite', 100, 1);
INSERT INTO room(hotel, room_number, room_type, cost_per_night) VALUES('HiltonKL', 121, 'Single', 30);
INSERT INTO room(hotel, room_number, room_type, cost_per_night) VALUES('HiltonKL', 131, 'Double', 30);

INSERT INTO reservation(guest, hotel, room, check_in_date, check_out_date) VALUES('andika@gmail.com','HiltonKL', '111', parsedatetime('20200101','yyyyMMdd'), parsedatetime('20200102','yyyyMMdd'));
