package com.transferObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "Player_bolte")

public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	@Column(nullable = false, name = "name")
	private String playerName;
	
//	@OneToOne
//	private Team team;
	
	@OneToMany
	 List<Team> teamList = new ArrayList<>();
  	private int age;
	
	public Player() {
		
	}
	
	

//	public Player(int playerId, String playerName, Team team, int age) {
//		super();
//		this.playerId = playerId;
//		this.playerName = playerName;
//		this.team = team;
//		this.age = age;
//	}



//	public Team getTeam() {
//		return team;
//	}



	public List<Team> getTeamList() {
		return teamList;
	}



	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}



//	public void setTeam(Team team) {
//		this.team = team;
//	}



	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

//	public String getTeamName() {
//		return teamName;
//	}
//
//	public void setTeamName(String teamName) {
//		this.teamName = teamName;
//	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", teamDetails=" + teamList + ", age=" + age
				+ ", getPlayerId()=" + getPlayerId() + ", getPlayerName()=" + getPlayerName() + ", getteam()="
				+ getTeamList() + ", getAge()=" + getAge() + "]";
	}

//	public Player(String playerName, Team team
//			, int age) {
//		super();
//		this.playerId = playerId;
//		this.playerName = playerName;
//		this.team = team;
//		this.age = age;
//	}
//	
	
	
	
}
