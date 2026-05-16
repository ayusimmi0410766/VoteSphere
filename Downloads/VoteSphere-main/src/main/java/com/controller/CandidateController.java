package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Candidate;
import com.model.User;
import com.service.CandidateService;
import com.service.UserService;

@Controller
public class CandidateController {

	@Autowired
	private CandidateService canServ;

	@Autowired
	private UserService userServ;

	@PostMapping("/addcandidate") // vote
	public String addCandidate(@RequestParam("candidate") String candidate,
			Principal p,
			Model model,
			HttpSession session) {

		String email = p.getName();

		User user = userServ.getUserByEmail(email);

		// user already voted check
		if (user.getStatus() == null) {

			try {

				// fetch selected candidate
				Candidate selectedCan = canServ.getCandidateByCandidate(candidate);

				// NULL CHECK FIX
				if (selectedCan == null) {

					session.setAttribute("vmsg",
							"Candidate not found...");

					return "redirect:/user/";
				}

				// increase vote
				selectedCan.setVotes(
						selectedCan.getVotes() + 1);

				// save updated candidate
				canServ.addCandidate(selectedCan);

				// update user status
				user.setStatus("Voted");

				userServ.addUser(user);

				session.setAttribute("vmsg",
						"Successfully Voted...");

			}

			catch (Exception e) {

				session.setAttribute("vmsg",
						"Something went wrong...");

				e.printStackTrace();

				return "redirect:/user/";
			}

		}

		else {

			session.setAttribute("vmsg",
					"You have already voted...");
		}

		return "redirect:/user/";
	}

}