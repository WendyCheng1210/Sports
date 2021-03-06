
DROP TABLE IF EXISTS games cascade;
DROP TABLE IF EXISTS players cascade;
DROP TABLE IF EXISTS teams cascade;

CREATE TABLE teams (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    name            VARCHAR(30) not null unique,
    abbreviation    VARCHAR(10),
    formed_year     INTEGER
);

CREATE TABLE games (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    name            VARCHAR(30) NOT null UNIQUE,
    team1           BIGSERIAL NOT NULL,
    team2           BIGSERIAL NOT NULL,
    location        VARCHAR (100),
    FOREIGN KEY (team1) references teams(id),
    FOREIGN KEY (team2) references teams(id)
);

CREATE TABLE players (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    name            VARCHAR(30),
    role_type       VARCHAR(30),
    salary          NUMERIC(10, 2),
    hired_year      INTEGER ,
    team_id         BIGSERIAL NOT NULL,
	FOREIGN KEY (team_id) REFERENCES teams (id)
);

