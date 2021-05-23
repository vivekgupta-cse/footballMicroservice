package com.footballteams.standings.Football.Team.Standings.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:footballmatch.properties")
public class FootballTeamStandingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballTeamStandingsServiceApplication.class, args);
	}
}
