DROP TABLE IF EXISTS CART;
DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS COMMENTS;



CREATE TABLE COMMENTS (
	Id INTEGER PRIMARY KEY IDENTITY,
	Words VARCHAR(200)
);


CREATE TABLE BOOK (
	Id INTEGER PRIMARY KEY IDENTITY,
	Title VARCHAR(50),
	Category VARCHAR (20),
	Author VARCHAR(20),
	Publisher VARCHAR(20),
	Edition INTEGER,
	Year INTEGER,
	ISBN INTEGER,
	Price INTEGER
);


CREATE TABLE USERS (
	Username VARCHAR(20) PRIMARY KEY,
	Password VARCHAR(20),
	Enabled BOOLEAN
);


CREATE TABLE USER_ROLES (
	Username VARCHAR(20),
	Role VARCHAR(20)
);


CREATE TABLE CART (
	Cart_Id INTEGER IDENTITY PRIMARY KEY,
	Price INTEGER,
	Book_Id INTEGER,
	Username VARCHAR(20),
	FOREIGN KEY (Book_Id) REFERENCES BOOK(Id)
);





INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('Harry Potter and the Philosopher´s Stone', 'Fantasy', 1, 'J. K. Rowling', 'Bloomsbury', 1997, 109, 50);

INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('Harry Potter and the Chamber of Secrets', 'Fantasy', 1, 'J. K. Rowling', 'Bloomsbury', 1998, 100, 50);

INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('Easy Mathematics', 'Fantasy', 1, 'Eduardo Espinoza', 'McGraw-Hill', 2002, 100, 100);

INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('Headache', 'Medicine', 1, 'Dr. Rowling', 'MedicalHill', 1999, 110, 60);

INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('Headache 2', 'Medicine', 1, 'Dr. Rowling Jr.', 'MedicalHill', 2000, 109, 70);

INSERT INTO BOOK (Title, Category, Edition, Author, Publisher, Year, ISBN, Price)
VALUES ('7 habits of highly effective teens', 'Humanities', 1, 'Sean Covey', 'Bloomsbury', 2002, 110, 20);



INSERT INTO COMMENTS (Words)
VALUES ('Good page. The best website to buy books!')

INSERT INTO COMMENTS (Words)
VALUES ('Excellent!')



INSERT INTO USERS (Username, Password, Enabled) 
VALUES ('softtek', '1234', true);

INSERT INTO USERS (Username, Password, Enabled) 
VALUES ('collaborator', '1234', true);

INSERT INTO USERS (Username, Password, Enabled) 
VALUES ('guy', '1234', true);



INSERT INTO USER_ROLES (Username, Role) 
VALUES ('softtek', 'ROLE_ADMIN');

INSERT INTO USER_ROLES (Username, Role) 
VALUES ('collaborator', 'ROLE_USER');

INSERT INTO USER_ROLES (Username, Role) 
VALUES ('guy', 'ROLE_USER');

