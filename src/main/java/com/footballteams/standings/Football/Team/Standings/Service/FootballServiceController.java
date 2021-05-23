package com.footballteams.standings.Football.Team.Standings.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballServiceController {
	
	@Value("${BaseUrl}")
	String baseUrl;
	
	@Value("${ApiKey}")
	String apiKey;

	@GetMapping("/standings")
	public FootballBean getStandings(
			@RequestParam(name = "countryName") String countryName,
			@RequestParam(name = "leagueName") String leagueName,
			@RequestParam(name = "teamName") String teamName) {
		
		FootballBean fb = new FootballBean(countryName, leagueName, teamName);
		
		GetAndParseData gapd = new GetAndParseData();
		ReturnValues retLeague = gapd.getLeagueInfo(baseUrl, apiKey, leagueName, countryName, fb);
		
		if(retLeague == ReturnValues.FAILURE) {
			gapd.setInvalid(fb);
			return fb;
		}
		
		ReturnValues retStanding = gapd.getStandingInfo(baseUrl, apiKey, fb.getLeagueId(), 
				countryName, leagueName, teamName, fb);
		
		if(retStanding == ReturnValues.FAILURE) {
			gapd.setInvalid(fb);
			return fb;
		}
		
		return fb;
	}
	
	
}
