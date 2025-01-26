CREATE DATABASE library_management;

\c library_management;

-- Table Books --
CREATE TABLE  IF NOT EXISTS "Books" (
    id_books VARCHAR(50) PRIMARY KEY,
    book_name VARCHAR(100) NOT NULL,
    author_id VARCHAR(50) NOT NULL,
    page_numbers INT NOT NULL,
    topic VARCHAR(200) NOT NULL,
    release_date DATE NOT NULL,
    FOREIGN KEY (author_id) REFERENCES "Authors"(author_id) ON DELETE CASCADE
);

-- Table Authors --
CREATE TABLE  IF NOT EXISTS "Authors" (
    author_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birthDate DATE NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')) NOT NULL
);

-- Table Students --
CREATE TABLE  IF NOT EXISTS "Students" (
    id_student VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')) NOT NULL,
    birth_date DATE NOT NULL,
    reference VARCHAR(100),
    group_name VARCHAR(100)
);

-- Table BorrowedBooks --
CREATE TABLE  IF NOT EXISTS "BorrowedBooks" (
    id_borrowed_book SERIAL PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    book_id VARCHAR(50) NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (student_id) REFERENCES "Students"(id_student) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES "Books"(id_books) ON DELETE CASCADE
);