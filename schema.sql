create table if not EXISTS t_mangas (
	id serial primary key not null,
	title VARCHAR(255) not null,
	description text,
	cover_img VARCHAR(255),
	release_date TIMESTAMP,
	is_finished BOOLEAN,
	chapter int,
	avg_rating FLOAT,
	view_count int,
	last_update TIMESTAMP,
	writer VARCHAR(255),
	slug VARCHAR(255),
	genre_id INT,
    temp_genre VARCHAR(30)
);

create table if not exists t_genres (
	id serial primary key not null,
	name VARCHAR(255) not null,
	slug VARCHAR(255)
);
create table if not exists t_manga_genres (
	manga_id int not null,
	genre_id int not null,
	primary KEY(manga_id, genre_id),
	foreign KEY(manga_id) references t_mangas (id),
	foreign KEY(genre_id) references t_genres (id)
);