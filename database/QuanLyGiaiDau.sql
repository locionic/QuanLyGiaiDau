create database QuanLyGiaiDau collate utf8_bin;

use QuanLyGiaiDau;

create table account(
	username varchar(10),
	password varchar(10)
);

create table league(
	league_id int primary key,
	league_name varchar(20)
);

create table football_match(
	league_id int,
	match_id int primary key,
	match_name varchar(20),
	constraint fk_match_league foreign key(league_id) references league(league_id)
);

create table team(
	team_name varchar(20) primary key,
	coach_name varchar(20)
);

create table player(
	player_id int primary key,
	team_name varchar(20),
	player_name varchar(20),
	position varchar(20),
	constraint fk_player_team foreign key(team_name) references team(team_name)
);

create table player_match(
	player_id int,
	match_id int,
	goals_scored int,
	yellow_card int,
	red_card int,
	primary key(player_id, match_id),
	constraint fk_playermatch_match foreign key(match_id) references football_match(match_id),
	constraint fk_playermatch_player foreign key(player_id) references player(player_id)
);

/*
create table team_match(
	team_name varchar(20),
	match_id int,
	score int,
	constraint fk_teammatch_team foreign key(team_name) references team(team_name),
	constraint fk_teammatch_match foreign key(match_id) references football_match(match_id),
	primary key(team_name, match_id)
);
*/
