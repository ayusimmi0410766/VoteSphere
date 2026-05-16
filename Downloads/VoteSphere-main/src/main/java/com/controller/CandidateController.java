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

		try {

			// logged in user email
			String email = p.getName();

			User user = userServ.getUserByEmail(email);

			// USER NULL CHECK
			if (user == null) {

				session.setAttribute("vmsg",
						"User not found...");

				return "redirect:/signin";
			}

			// already voted check
			if (user.getStatus() != null) {

				session.setAttribute("vmsg",
						"You have already voted...");

				return "redirect:/user/";
			}

			// remove extra spaces
			candidate = candidate.trim();

			System.out.println("Selected Candidate : " + candidate);

			// fetch candidate from database
			Candidate selectedCan = canServ.getCandidateByCandidate(candidate);

			// CANDIDATE NULL CHECK
			if (selectedCan == null) {

				session.setAttribute("vmsg",
						"Candidate not found in database...");

				return "redirect:/user/";
			}

			// increment vote
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

			e.printStackTrace();

			session.setAttribute("vmsg",
					"Something went wrong...");
		}

		return "redirect:/user/";
	}

}