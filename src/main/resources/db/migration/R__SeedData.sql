INSERT INTO USERS(name) VALUES
('User 1'),
('User 2'),
('User 3'),
('User 4');

INSERT INTO BOOKS(title, author, return_date, user_id) VALUES
('Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert C. Martin', DATEADD(DAY, 14, CURRENT_DATE()), 1),
('Domain-Driven Design: Tackling Complexity in the Heart of Software', 'Eric Evans', DATEADD(DAY, 15, CURRENT_DATE()), 1),
('Fundamentals of Software Architecture: An Engineering Approach', 'Mark Richards', DATEADD(DAY, 5, CURRENT_DATE()), 2),
('Patterns of Enterprise Application Architecture', 'Martin Fowler',  DATEADD(DAY, -15, CURRENT_DATE()), 2), -- overdue
('Effective Java', 'Joshua Bloch', null, null),
('Continuous Delivery: Reliable Software Releases through Build, Test, and Deployment Automation', 'Jez Humble', null, null),
('Site Reliability Engineering: How Google Runs Production Systems', 'Betsy Beyer', null, null),
('Refactoring: Improving the Design of Existing Code', 'Martin Fowler', null, null),
('Team Topologies: Organizing Business and Technology Teams for Fast Flow', 'Matthew Skelton', null, null),
('Building Microservices: Designing Fine-Grained Systems', 'Sam Newman', null, null);
