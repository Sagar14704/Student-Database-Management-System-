
CREATE DATABASE student_management;


USE student_management;


CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(100),
    fees_balance DECIMAL(10, 2),
    marks DECIMAL(5, 2)
);


INSERT INTO students (name, age, course, fees_balance, marks) VALUES
('John Doe', 20, 'Computer Science', 5000.00, 88.50),
('Jane Smith', 22, 'Mechanical Engineering', 2000.00, 91.00),
('Mike Johnson', 19, 'Electrical Engineering', 0.00, 75.00);
