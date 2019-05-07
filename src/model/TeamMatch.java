package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeamMatch{
	
	private int teammatch_id;
	private int teamA_id;
	private int teamB_id;
	private int match_id;
	private int scoreA;
	private int scoreB;
	public TeamMatch() {
		
	}
	public TeamMatch(int a, int b, int c, int d, int e, int f) {
		teammatch_id = a;
		teamA_id = b;
		teamB_id = c;
		match_id = d;
		scoreA = e;
		scoreB = f;
	}
	public int getTeammatch_id() {
		return teammatch_id;
	}
	public void setTeammatch_id(int teammatch_id) {
		this.teammatch_id = teammatch_id;
	}
	public int getTeamA_id() {
		return teamA_id;
	}
	public void setTeamA_id(int teamA_id) {
		this.teamA_id = teamA_id;
	}
	public int getTeamB_id() {
		return teamB_id;
	}
	public void setTeamB_id(int teamB_id) {
		this.teamB_id = teamB_id;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getScoreA() {
		return scoreA;
	}
	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}
	public int getScoreB() {
		return scoreB;
	}
	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}
	
	/*teammatch_id int AUTO_INCREMENT,
	teamA_id int,
	teamB_id int,
	match_id int,
	scoreA int,
	scoreB int,
	constraint fk_teammatch_teamA foreign key(teamA_id) references team(team_id),
	constraint fk_teammatch_teamB foreign key(teamB_id) references team(team_id),
	constraint fk_teammatch_match foreign key(match_id) references football_match(match_id),
	primary key(teammatch_id)*/
}
