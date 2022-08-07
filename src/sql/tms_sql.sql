CREATE DATABASE TMS;

USE TMS;

CREATE TABLE building (
b_id INT AUTO_INCREMENT, 
b_name VARCHAR (50) NOT NULL, 
num_of_apt INT NOT NULL, 
location TEXT NOT NULL,
PRIMARY KEY(b_id)
);

CREATE TABLE apartment (
apt_id INT AUTO_INCREMENT,
apt_name VARCHAR(50) NOT NULL,
b_id INT NOT NULL,
rent NUMERIC(12,2) NOT NULL,
available VARCHAR (25) NOT NULL,
PRIMARY KEY(apt_id),
FOREIGN KEY (b_id) REFERENCES building(b_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE tenant (
nid BIGINT,
full_name VARCHAR(255) NOT NULL,
age INT NOT NULL,
gender VARCHAR(50) NOT NULL,
religion VARCHAR(50) NOT NULL,
nationality VARCHAR(50) NOT NULL,
profession VARCHAR(255) NOT NULL,
mobile BIGINT NOT NULL,
email VARCHAR(255) NOT NULL,
permanant_address TEXT NOT NULL,
photo MEDIUMBLOB NOT NULL,
total_member INT NOT NULL,
apt_id INT NOT NULL,
security_deposit  NUMERIC(12,2) NOT NULL,
starting_month VARCHAR(50) NOT NULL,
t_status VARCHAR(25) NOT NULL,
ending_month VARCHAR(50),
PRIMARY KEY(nid),
FOREIGN KEY(apt_id) REFERENCES apartment(apt_id) ON DELETE CASCADE ON UPDATE CASCADE                    
);

CREATE TABLE transactions(
tr_id INT AUTO_INCREMENT,
tr_type VARCHAR (25) NOT NULL,
tr_amount NUMERIC (12,2) NOT NULL,
tr_datetime DATETIME NOT NULL,
tr_purpose VARCHAR(255) NOT NULL,
t_nid BIGINT,
apt_id INT,
tr_payment_method VARCHAR(50) NOT NULL,
rent_month VARCHAR(50),
PRIMARY KEY(tr_id),
FOREIGN KEY(t_nid) REFERENCES tenant(nid) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(apt_id) REFERENCES apartment(apt_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE due (
due_id INT AUTO_INCREMENT,
t_nid BIGINT NOT NULL,
due_status VARCHAR(50) NOT NULL,
due_amount NUMERIC (12,2) NOT NULL,
due_month VARCHAR(50) NOT NULL,
PRIMARY KEY(due_id),
FOREIGN KEY (t_nid) REFERENCES tenant(nid) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE userinfo(
user_id INT AUTO_INCREMENT,
user_pass VARCHAR (255) NOT NULL,
rem_msg TEXT NOT NULL,
PRIMARY KEY(user_id)
);

INSERT INTO userinfo (user_pass,rem_msg) VALUES ('5WQ54DGS0DG','Please Pay your rent within next 7 days. Thank You!');

ALTER TABLE building AUTO_INCREMENT=101;

ALTER TABLE apartment AUTO_INCREMENT=201;

ALTER TABLE transactions AUTO_INCREMENT=1001;

ALTER TABLE due AUTO_INCREMENT=2001;