Clinic - API - Sistema de agendamento de consultas 
---

🏥 Este é um projeto é um API REST robusto desenvolvida inteirmente em JAVA 24, projetada para garantir o fluxo de uma cliníca pensada para um cenário real.
O foco principal do projeto foi a aplicação rigorosa de POO, e alguns conceitos de SOLID que se encaixam no projeto, todas as classes e pacotes foram separadas por funcionalidades (PACKAGE BY FEATURES).

Principais tecnologias utilizadas no projeto
---
JAVA 24
Framework : Spring Boot.
Banco de Dados : PostGreSql 18.
Persistência de dados : Spring DATA Jpa - Hibernate.
Protocolo : Rest JSON.
Testes : Postman.

Arquitetura:
-----
**Clases:**
Doctor : identificado pelo crm,
Patient : identificado pelo cpf,
Nurse : identificado pelo coren.
Exam : O sistema central da aplicação, aqui as entidades são conectadas e formam um verdadeiro espelho do que seria um agendamento de consultas feito na vida real.

Diferenciais
----
1.**SOLID** : Cada classe tem uma funcionalidade evitando o super inflamento de classes e deixando o código mais modularizado e limpo.
2.**RELACIONAMENTOS BIDIRECIONAIS** : Utilizando JPA de forma eficiente o gerenciamento de comunicação entre as entidades se torna eficiente e responsivo. Ume exemplo disso é o relacionamento que um exame tem o doutor, o paciente e a enfermeira(o).
3.**LOGICA REALISTA** : Ao criar um Exam(POST) os campos doctor, patient e nurse instanciam como null, o que simula uma fila de espera, e consequentemente a disponibilidade de profissionais que trabalham nesta clinica, tal como o médico e a enfermeira.

Funcionalidades CRUD
---
Listagem : Visuliazação de todos os registros salvos, sejam eles doutor,exames, pacientes.
Criação : Criação de exames novos, profissionais novos e novos pacientes.
Alteração : Alteração de datas de exames, alteração da hora, alteração do email e números de funcionários e pacientes.
Remoção : Remoção de um exame, um paciente ,e das demais instâncias.

Status
---
O projeto ainda está em desenvolvimento, com foco atual em construir validações e tratar as exceções de maneira correta e limpa.

-----------------------------------------------------------------------

 Clinic API - Consultation Scheduling System
 ----
This is a robust REST API project developed entirely in Java 24, designed to manage the workflow of a medical clinic modeled after real-world scenarios. The core focus of this project is the rigorous application of Object-Oriented Programming (OOP) and SOLID principles. The architecture follows a Package by Feature organization to ensure modularity and scalability.

 Key Technologies
 ---
Language: Java 24
Framework: Spring Boot
Database: PostgreSQL 18
Data Persistence: Spring Data JPA / Hibernate
Protocol: REST (JSON)
Testing & Documentation: Postman

 Architecture & Entities
 -------
The system is built around four primary entities that mirror a real healthcare environment:
Doctor: Identified by their professional license (CRM).
Patient: Identified by their tax ID (CPF).
Nurse: Identified by their nursing license (COREN).
Exam: The core of the application. This entity connects all others, acting as a "mirror" of a real-life medical appointment schedule.

Key Features & Differentials
-------
1. **SOLID** Principles
Each class has a single, well-defined responsibility, preventing "bloated" classes and ensuring a clean, modular, and maintainable codebase.
2. **Bidirectional Relationships**
Using JPA efficiently, the communication between entities is both responsive and consistent. A primary example is the Exam entity, which maintains managed relationships with the Doctor, Patient, and Nurse.
3. **Realistic Business Logic**
When an Exam is created (POST), the fields for doctor, patient, and nurse are initialized as null. This simulates a real-world waiting list, where professional availability is checked before they are assigned to a specific appointment via subsequent updates.

 CRUD Functionalities
 -----
Read (List): View all saved records, including doctors, exams, and patients.
Create: Register new exams, healthcare professionals, and patients.
Update: Modify exam dates/times or update contact information (email and phone) for staff and patients.
Delete: Remove exams, patients, or other instances from the database.

 Project Status
 ------
This project is currently under development. The current focus is on implementing robust data validation and building a clean, centralized exception handling system.
