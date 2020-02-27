CREATE TABLE product(
	
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_URL VARCHAR(50),
	price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id)


);


INSERT INTO product (name, description, image_URL, price,quantity, is_active)VALUES('Fan','Second hand usha fan in working condition.','fan.png',700,1,true);

