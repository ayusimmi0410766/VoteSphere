package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Candidate;
import com.model.User;
import com.repository.CandidateRepository;
import com.repository.UserRepository;

@SpringBootApplication
public class VoteSphereApplication implements CommandLineRunner   {

	public static void main(String[] args) {
		SpringApplication.run(VoteSphereApplication.class, args);
	}

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CandidateRepository canRepo;

	@Override
	public void run(String... args) throws Exception {

		// Admin
		User admin = new User();

		admin.setEmail("admin");
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setPhone(1234);
		admin.setRole("ROLE_ADMIN");
		admin.setStatus("admin");


		
		// Candidate 1
		Candidate candidate1 = new Candidate();

		candidate1.setCandidate("

		canRepo.save(candidate1);

		// Candidate 2
		Candidate candidate2 = ne

		candidate2.setCandidate("candidate2");

		canRepo.save(candidate2);


		Candidate candidate3 = new Candidate();

		candidate3.setCandidate("candidate3");


	

		candidate4.setCandidate("candidate4");

		canRepo.save(candidate4);
	}
}
	