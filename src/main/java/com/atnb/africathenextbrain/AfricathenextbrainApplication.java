package com.atnb.africathenextbrain;

import com.atnb.africathenextbrain.dao.ContributionRepository;
import com.atnb.africathenextbrain.entities.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AfricathenextbrainApplication implements CommandLineRunner {
	@Autowired
	private ContributionRepository contributionRepository;

	public static void main(String[] args) {
		SpringApplication.run(AfricathenextbrainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		contributionRepository.save(new Contribution(null,"je suis africa","ibou","agriculture",1));
        contributionRepository.save(new Contribution(null,"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt in culpa qui officia deserunt mollit anim id est laborum","ibou","agriculture",1));

		contributionRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("salut africa");

	}
}
