--v0.1 start--
create database process_template;


--create tables start--
---process table---
CREATE TABLE process (
    idprocess varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT uk_process UNIQUE (name),
	CONSTRAINT pk_process primary key (idprocess)
);

--line_no---
CREATE TABLE line_no (
    idline_no varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT uk_line_no UNIQUE (name),
	CONSTRAINT pk_line_no primary key (idline_no)
);

---machine_name---
CREATE TABLE machine_name (
    idmachine_name varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT uk_machine_name UNIQUE (name),
	CONSTRAINT pk_machine_name primary key (idmachine_name)
);

--machine_drawing--
CREATE TABLE wcommon.machine_drawing (
    idmachine_drawing varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT uk_machine_drawing UNIQUE (name),
	CONSTRAINT pk_machine_drawing primary key (idmachine_drawing)
);

---sub_folder---
CREATE TABLE wcommon.sub_folder (
    idsub_folder varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT uk_sub_folder UNIQUE (name),
	CONSTRAINT pk_sub_folder primary key (idsub_folder)
);

---j_process_line_no--
CREATE TABLE wcommon.j_process_line_no (
    idj_process_line_no varchar(50) NOT NULL,
    process varchar(50), 
    line_no varchar(50),
	CONSTRAINT pk_j_process_line_no primary key (idj_process_line_no),
    CONSTRAINT fk1_j_process_line_no FOREIGN KEY (process)
    REFERENCES process(idprocess),
	CONSTRAINT fk2_j_process_line_no FOREIGN KEY (line_no)
    REFERENCES line_no(idline_no)
);

---j_process_line_no_machine_name--
CREATE TABLE j_process_line_no_machine_name (
    idj_process_line_no_machine_name varchar(50) NOT NULL,
    process varchar(50), 
    line_no varchar(50),
    machine_name varchar(50),
	CONSTRAINT pk_j_process_line_no_machine_name primary key (idj_process_line_no_machine_name),
    CONSTRAINT fk1_j_process_line_no_machine_name FOREIGN KEY (process)
    REFERENCES process(idprocess),
	CONSTRAINT fk2_j_process_line_no_machine_name FOREIGN KEY (line_no)
    REFERENCES line_no(idline_no),
    CONSTRAINT fk3_j_process_line_no_machine_name FOREIGN KEY (machine_name)
    REFERENCES machine_name(idmachine_name)
);

---j_process_line_no_machine_name_drawing--
CREATE TABLE wcommon.j_process_line_no_machine_name_drawing (
    idj_process_line_no_machine_name_drawing varchar(50) NOT NULL,
    process varchar(50), 
    line_no varchar(50),
    machine_name varchar(50),
    machine_drawing varchar(50),
	CONSTRAINT pk_j_process_line_no_machine_name_drawing primary key (idj_process_line_no_machine_name_drawing),
    CONSTRAINT fk1_j_process_line_no_machine_name_drawing FOREIGN KEY (process)
    REFERENCES process(idprocess),
	CONSTRAINT fk2_j_process_line_no_machine_name_drawing FOREIGN KEY (line_no)
    REFERENCES line_no(idline_no),
    CONSTRAINT fk3_j_process_line_no_machine_name_drawing FOREIGN KEY (machine_name)
    REFERENCES machine_name(idmachine_name),
    CONSTRAINT fk4_j_process_line_no_machine_name_drawing FOREIGN KEY (machine_drawing)
    REFERENCES machine_drawing(idmachine_drawing)
);

--j_process_line_no_machine_name_drawing_sub_folder--
CREATE TABLE wcommon.j_process_line_no_machine_name_drawing_sub_folder (
    idj_process_line_no_machine_name_drawing_sub_folder varchar(50) NOT NULL,
    process varchar(50), 
    line_no varchar(50),
    machine_name varchar(50),
    machine_drawing varchar(50),
    sub_folder varchar(50),
	CONSTRAINT pk_j_process_line_no_machine_name_drawing_sub_folder primary key (idj_process_line_no_machine_name_drawing_sub_folder),
    CONSTRAINT fk1_j_process_line_no_machine_name_drawing_sub_folder FOREIGN KEY (process)
    REFERENCES process(idprocess),
	CONSTRAINT fk2_j_process_line_no_machine_name_drawing_sub_folder FOREIGN KEY (line_no)
    REFERENCES line_no(idline_no),
    CONSTRAINT fk3_j_process_line_no_machine_name_drawing_sub_folder FOREIGN KEY (machine_name)
    REFERENCES machine_name(idmachine_name),
    CONSTRAINT fk4_j_process_line_no_machine_name_drawing_sub_folder FOREIGN KEY (machine_drawing)
    REFERENCES machine_drawing(idmachine_drawing),
    CONSTRAINT fk5_j_process_line_no_machine_name_drawing_sub_folder FOREIGN KEY (sub_folder)
    REFERENCES sub_folder(idsub_folder)
);
--create tables end--
--v0.1 end--