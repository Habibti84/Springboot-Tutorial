CREATE TABLE IF NOT EXISTS Content (
        id INTEGER AUTO_INCREMENT,
        title varchar(255) NOT NULL,
        description text,
        status VARCHAR(20) NOT NULL,
        type VARCHAR(50) NOT NULL,
        created TIMESTAMP NOT NULL,
        updated TIMESTAMP,
        url VARCHAR(255),
        primary key (id)
);

INSERT INTO CONTENT(title, description, status, type, created)
VALUES('Spring Tutorial', 'My first Spring Tutorial ive ever visited. Until now, its great', 'IN_PROGRESS', 'COURSE', CURRENT_TIMESTAMP)