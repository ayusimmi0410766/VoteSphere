package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.CandidateService;

@Controller
public class AdminController {

	@Autowired
	private CandidateService canServ;

	@GetMapping("/admin")
	public String dashboard(Model m,
							Principal p)
	{

		// TOTAL VOTES

		int c1 =
				canServ.getNumOfVotes("Candidate 1");

		int c2 =
				canServ.getNumOfVotes("Candidate 2");

		int c3 =
				canServ.getNumOfVotes("Candidate 3");

		int c4 =
				canServ.getNumOfVotes("Candidate 4");

		// TOTAL

		int totalVotes =
				c1 + c2 + c3 + c4;

		// WINNER

		String winner = "No Votes Yet";

		int maxVotes =
				Math.max(
						Math.max(c1, c2),
						Math.max(c3, c4)
				);

		if(maxVotes > 0)
		{

			if(maxVotes == c1)
			{
				winner = "Candidate 1";
			}

			else if(maxVotes == c2)
			{
				winner = "Candidate 2";
			}

			else if(maxVotes == c3)
			{
				winner = "Candidate 3";
			}

			else
			{
				winner = "Candidate 4";
			}

		}

		// SEND DATA

		m.addAttribute("c1", c1);

		m.addAttribute("c2", c2);

		m.addAttribute("c3", c3);

		m.addAttribute("c4", c4);

		m.addAttribute("totalVotes",
				totalVotes);

		m.addAttribute("winner",
				winner);

		m.addAttribute("title",
				"DASHBOARD");

		return "admin/dashboard";

	}

}