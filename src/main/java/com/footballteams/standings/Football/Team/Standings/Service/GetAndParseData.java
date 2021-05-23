package com.footballteams.standings.Football.Team.Standings.Service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.web.client.RestTemplate;

public class GetAndParseData {
	
	JSONObject parseLeaguesDataJson(String jsonData, String leagueName) {
		JSONArray fieldNamesArray = (JSONArray) JSONValue.parse(jsonData);
		
		for(int i = 0; i < fieldNamesArray.size(); i++) {
			JSONObject jobj = (JSONObject)fieldNamesArray.get(i);
			String league_name = (String) jobj.get("league_name");
			if(league_name.equals(leagueName)) {
				return jobj;
			}
		}
		return null;
	}
	
	ReturnValues getLeagueInfo(String baseUrl, String apiKey, String leagueName, String countryName, FootballBean fb) {
		final String url = baseUrl + "/?action={action}&APIkey={APIkey}";
		
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("action", "get_leagues");
	    params.put("APIkey", apiKey);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class, params);
	    
		JSONObject jobj = parseLeaguesDataJson(result, leagueName);
		
		if(jobj != null) {
			String country_Name = (String) jobj.get("country_name");
			String country_Id = (String) jobj.get("country_id");
			String league_Id = (String) jobj.get("league_id");
			
			if((!country_Name.isEmpty()) && (!country_Name.toLowerCase().equals(countryName.toLowerCase()))) {
				return ReturnValues.FAILURE;
			}
			
			fb.setCountryName(countryName);
			fb.setCountryId(Integer.parseInt(country_Id));
			fb.setLeagueId(Integer.parseInt(league_Id));
			fb.setLeagueName(leagueName);
			return ReturnValues.SUCCESS;
		} else {
			return ReturnValues.FAILURE;
		}
	}
	
	JSONObject parseStandingDataJson(String jsonData, String teamName) {
		JSONArray fieldNamesArray = (JSONArray) JSONValue.parse(jsonData);
		
		for(int i = 0; i < fieldNamesArray.size(); i++) {
			JSONObject jobj = (JSONObject)fieldNamesArray.get(i);
			String team_name = (String) jobj.get("team_name");
			if(team_name.equals(teamName)) {
				return jobj;
			}
		}
		return null;
	}
	
	ReturnValues getStandingInfo(String baseUrl, String apiKey, int leagueId, 
			String countryName, String leagueName, String teamName, 
			FootballBean fb) {
		

		final String url = baseUrl + "/?action={action}&league_id={league_id}&APIkey={APIkey}";
		
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("action", "get_standings");
	    params.put("league_id", Integer.toString(leagueId));
	    params.put("APIkey", apiKey);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class, params);
	    

	    JSONObject jobj = parseStandingDataJson(result, teamName);
	    
	    if(jobj != null) {
			String country_Name = (String) jobj.get("country_name");
			String team_Name = (String) jobj.get("team_name");
			String team_Id = (String) jobj.get("team_id");
			String league_Name = (String) jobj.get("league_name");
			String league_Id = (String) jobj.get("league_id");
			String league_Position = (String) jobj.get("overall_league_position");
			
			if((!country_Name.isEmpty()) && (!country_Name.toLowerCase().equals(countryName.toLowerCase()))) {
				return ReturnValues.FAILURE;
			}
			
			if(!(team_Name.isEmpty()) && (!team_Name.toLowerCase().equals(team_Name.toLowerCase()))) {
				return ReturnValues.FAILURE;
			}
			
			if((!league_Name.isEmpty()) && (!league_Name.toLowerCase().equals(leagueName.toLowerCase()))) {
				return ReturnValues.FAILURE;
			}
			
			fb.setCountryName(countryName);
			fb.setTeamId(Integer.parseInt(team_Id));
			fb.setLeagueId(Integer.parseInt(league_Id));
			fb.setLeagueName(leagueName);
			fb.setTeamName(teamName);
			fb.setLeaguePosition(Integer.parseInt(league_Position));
			return ReturnValues.SUCCESS;
		} else {
			return ReturnValues.FAILURE;
		}
	}
	
	void setInvalid(FootballBean fb) {
		fb.setCountryName("INVALID DATA");
		fb.setLeagueName("INVALID DATA");
		fb.setTeamName("INVALID DATA");
		fb.setCountryId(0);
		fb.setLeagueId(0);
		fb.setTeamId(0);
		fb.setLeaguePosition(0);
	}
}
