CREATE TABLE user(
user_id varchar(50) PRIMARY KEY,
first_name varchar(30) NOT NULL,
last_name varchar(30),
contact varchar(25) NOT NULL,
city varchar(30),
pass varchar(50) NOT NULL);

INSERT INTO user values("shivam@gmail.com", "Shivam", "Singh", "7505528469", "Delhi", "pass1");
INSERT INTO user values("pratham@gmail.com", "Pratham", "Singh", "7505528470", "Noida", "pass2");
INSERT INTO user values("akash@gmail.com", "Akash", "Singh", "7505528471", "Varanasi", "pass3");


CREATE TABLE property(
prop_id int PRIMARY KEY, 
prop_price varchar(15) NOT NULL, 
prop_description varchar(100),
prop_type varchar(15) NOT NULL,
house_no varchar(20) NOT NULL,
district varchar(20) NOT NULL,
pin varchar(6) NOT NULL,
city varchar(15) NOT NULL,
state varchar(15) NOT NULL,
prop_landmark varchar(20),
owner_contact varchar(25) NOT NULL);

INSERT INTO property VALUES(1, "20000", "A House available for RENT.", "HOUSE", "D23/64", "Varanasi", "221010", "Varanasi", "UP", "Near Durga Temple", "900784239");

CREATE TABLE interest_log(
timestamp  datetime PRIMARY KEY,
user_id varchar(50) NOT NULL,
intrested_city varchar(40) NOT NULL,
prop_id int(10) NOT NULL);

