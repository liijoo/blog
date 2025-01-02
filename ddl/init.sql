CREATE TABLE m_blog (
    id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT,
    title VARCHAR(255),
    description TEXT,
    content TEXT,
    created DATETIME,
    status INT
);

CREATE TABLE m_user (
    id BIGINT NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    avatar_location VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    status INT,
    created DATETIME,
    last_login DATETIME
);
