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
  

	   @Autowired
    private UserRepository userRe

	   @Autowired
    private CandidateRepository canRepo;

    @Override
    public void run(String... args) throws Exceptio

		      // Admin
        if (!userRepo.existsById(1)) {

            User admin = new User();

            admin.setEmail("admin@gmail.com");
            admin.setName("Admin");
            admin.setPassword("admin123");
            admin.setPhone(1234567890L);
            admin.setRo

		
            userRepo.save(admin);
        }

        // Candidate 1

		
            Candidate c1 = new Candidate();
            c1.setCandidate("Candidate 1");


		      }

        // Candidate 2
        if (!canRepo.exists

		          Candidate c2 = new Candidate();
            c2.setCandidate("Candidate 2");

            canRepo.save(c2

	

            Candidate c3 = new Candidate();
            c3.setCandidate("Candidate 3");

            canRepo.save(c3);
        }

        // Candidate 4
        if (!canRepo.existsById(4)) {

            Candidate c4 = new Candidate();
            c4.setCandidate("Candidate 4");

            canRepo.save(c4);
        }
    }
}