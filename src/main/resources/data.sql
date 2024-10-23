DROP TABLE IF EXISTS fake_user;

CREATE TABLE fake_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

INSERT INTO fake_user (username, password, role) VALUES
    ('user',
    '$2y$10$0HIG6lxJkcv1wqDlK9Lj3u0C2IiiR/WjuMJV4hdKDlTBLa2sasgZy',
    'USER'),
    ('admin',
    '$2y$10$RkMEdwg2Hx1pZUevMtqK1OEcksV04batveuE4cQ36zwTxttXjSLMW',
    'ADMIN');