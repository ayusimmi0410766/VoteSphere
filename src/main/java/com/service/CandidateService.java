package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Candidate;
import com.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository canRepo;

	// add or update candidate
	public Candidate addCandidate(Candidate can) {

		return this.canRepo.save(can);
	}

	// get all candidates
	public List<Candidate> getAllCandidates() {

		return this.canRepo.findAll();
	}

	// get candidate by id
	public Candidate getCandidateById(int id) {

		return this.canRepo.findById(id).orElse(null);
	}

	// delete candidate
	public void delelteCandidate(int id) {

		this.canRepo.deleteById(id);
	}

	// get number of votes
	public int getNumOfVotes(String candidate) {

		Integer votes = this.canRepo.getNumOfVotes(candidate);
		return votes != null ? votes : 0;
	}

	// get candidate by candidate name
	public Candidate getCandidateByCandidate(String candidate) {

		return this.canRepo.getCandidateByCandidate(candidate);
	}

}