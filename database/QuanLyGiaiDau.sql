create database QuanLyGiaiDau collate utf8_bin;;

use QuanLyGiaiDau;

create table account(
	username varchar(10) primary key,
	password varchar(10)
);

create table league(
	league_id int primary key,
	league_name varchar(20),
	userid varchar(10),
	constraint fk_league_account foreign key(userid) references account(username)
);

create table football_match(
	league_id int,
	match_id int primary key,
	match_name varchar(20),
	constraint fk_match_league foreign key(league_id) references league(league_id)
);

create table team(
	team_id int AUTO_INCREMENT primary key,
	team_name varchar(20),
	coach_name varchar(20)
);

create table player(
	player_id int primary key,
	team_id int,
	player_name varchar(20),
	position varchar(20),
	goals_scored int,
	yellow_card int,
	red_card int,
	constraint fk_player_team foreign key(team_id) references team(team_id)
);
/*
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
*/
create table team_match(
	teammatch_id int AUTO_INCREMENT,
	teamA_id int,
	teamB_id int,
	match_id int,
	scoreA int,
	scoreB int,
	constraint fk_teammatch_teamA foreign key(teamA_id) references team(team_id),
	constraint fk_teammatch_teamB foreign key(teamB_id) references team(team_id),
	constraint fk_teammatch_match foreign key(match_id) references football_match(match_id),
	primary key(teammatch_id)
);

