package com.footballteams.standings.Football.Team.Standings.Service;

public class FootballBean {
	private int countryId;
	private String countryName;
	
	private int leagueId;
	private String leagueName;
	
	private int teamId;
	private String teamName;

	private int leaguePosition;

	/**
	 * @param countryName
	 * @param leagueName
	 * @param teamName
	 */
	public FootballBean(String countryName, String leagueName, String teamName) {
		super();
		this.countryName = countryName;
		this.leagueName = leagueName;
		this.teamName = teamName;
	}

	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the leagueId
	 */
	public int getLeagueId() {
		return leagueId;
	}

	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * @return the leagueName
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @param leagueName the leagueName to set
	 */
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the leaguePosition
	 */
	public int getLeaguePosition() {
		return leaguePosition;
	}

	/**
	 * @param leaguePosition the leaguePosition to set
	 */
	public void setLeaguePosition(int leaguePosition) {
		this.leaguePosition = leaguePosition;
	}
	
	
	@Override
	public String toString() {
		return String.format("countryId=%d, countryName=%s, leagueId=%d, leagueName=%s, teamId=%d, teamName=%s, leaguePosition=%d", 
				countryId, countryName, leagueId, leagueName, teamId, teamName, leaguePosition);
	}
}
