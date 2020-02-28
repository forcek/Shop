CREATE TABLE product(
	
	id IDENTITY,
	name VARCHAR(50),
	code VARCHAR(20),
	description VARCHAR(255),
	image_URL VARCHAR(50),
	price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id)


);


INSERT INTO product (name, description, code, image_URL, price,quantity, is_active)VALUES('Fan','Second hand usha fan in working condition.','PRDABC123DEFX','fan.jpg',700,1,true);
INSERT INTO product (name, description, code, image_URL, price,quantity, is_active)VALUES('Cooler','Second hand cooler in working condition.','PRDDEF123DEFX','cooler.jpg',3000,1,true);
INSERT INTO product (name, description, code, image_URL, price,quantity, is_active)VALUES('Single Bed','Single Bed of size 6x3 in good condition.','PRDGHI123DEFX','bed.jpg',4000,1,true);
INSERT INTO product (name, description, code, image_URL, price,quantity, is_active)VALUES('TV','Second hand LG TV 32 inches in working condition.','PRDJKL123DEFX','TV.jpg',6000,1,true);
INSERT INTO product (name, description, code, image_URL, price,quantity, is_active)VALUES('TV','Second hand LG TV 42 inches in working condition.','PRDJKL123DEFX','TV.jpg',11000,0,true);



CREATE TABLE user_detail(
	
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(50),
	contact_number(50),
	
	CONSTRAINT pk_user_id PRIMARY KEY(id),


);























