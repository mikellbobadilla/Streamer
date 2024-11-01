CREATE TABLE IF NOT EXISTS genres (
    id bigint primary key generated always as identity,
    name varchar(50) not null unique
);


CREATE TABLE IF NOT EXISTS series (
    id bigint primary key generated always as identity,
    title text not null,
    description text,
    poster_path text,
    path text,
    create_at timestamp with time zone default now()
);


CREATE TABLE IF NOT EXISTS seasons (
    id bigint primary key generated always as identity,
    serie_id bigint references series (id) on delete cascade,
    season_number int not null check (season_number > 0),
    title text,
    description text,
    path text,
    create_at timestamp with time zone default now()
);


CREATE TABLE IF NOT EXISTS episodes (
    id bigint primary key generated always as identity,
    season_id bigint references seasons(id) on delete cascade,
    title text not null,
    description text,
    episode_number int not null,
    file_path text,
    create_at timestamp with time zone default now()
);


CREATE TABLE serie_genres (
    serie_id bigint references series(id),
    genre_id bigint references genres(id),
    primary key (serie_id, genre_id)
);