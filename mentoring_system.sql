CREATE DATABASE mentoring_system;
  
CREATE TABLE tb_class (
  idt_class SERIAL PRIMARY KEY,
  desc_mentoring_period VARCHAR(50)
);

CREATE TABLE tb_mentor (
  idt_mentor SERIAL PRIMARY KEY,
  desc_cpf VARCHAR(14) NOT NULL UNIQUE,
  desc_name VARCHAR(255) NOT NULL,
  desc_adress VARCHAR(255), 
  desc_email VARCHAR(255)
);

CREATE TABLE tb_student (
  idt_student SERIAL PRIMARY KEY,
  desc_cpf VARCHAR(14) NOT NULL UNIQUE,
  desc_name VARCHAR(255) NOT NULL,
  desc_adress VARCHAR(255), 
  desc_email VARCHAR(255)
);

CREATE TABLE tb_mentoring(
  idt_mentoring SERIAL PRIMARY KEY,
  desc_mentoring_type VARCHAR(255),
  fk_class INT,
  fk_student INT UNIQUE,
  fk_mentor INT UNIQUE,
  CONSTRAINT fk_class FOREIGN KEY (fk_class)
  REFERENCES tb_class (idt_class),
  CONSTRAINT fk_student FOREIGN KEY (fk_student)
  REFERENCES tb_student (idt_student), 
  CONSTRAINT fk_mentor FOREIGN KEY (fk_mentor) 
  REFERENCES tb_mentor (idt_mentor)
);
