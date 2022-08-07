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
PRIMARY KEY(tr_id),
FOREIGN KEY(t_nid) REFERENCES tenant(nid) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(apt_id) REFERENCES apartment(apt_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO building ( b_id, b_name, num_of_apt, location ) VALUES (101,'Touch Masumas Mirror',0,'South Khulshi - Chittagong');
INSERT INTO apartment ( apt_id, apt_name,b_id,rent,available ) VALUES (201,'E1',101,18000,'YES');
INSERT INTO transactions (tr_id,tr_type,tr_amount,tr_datetime,tr_purpose,tr_payment_method) VALUES (1100,'DEBIT',1000,NOW(),'CLEAN','CASH');