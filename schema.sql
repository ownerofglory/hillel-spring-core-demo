 CREATE TABLE t_school (
 	id INT PRIMARY KEY AUTO_INCREMENT,
 	name VARCHAR(128)
 );

 CREATE TABLE t_student (
 	id INT PRIMARY KEY AUTO_INCREMENT,
 	first_name VARCHAR(64) NOT NULL,
 	last_name VARCHAR(64) NOT NULL,
 	school_id INT,
 	FOREIGN KEY (school_id) REFERENCES t_school(id)
 );