package com.cricket.scoretrackingservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.scoretrackingservice.entity.ScoreTrackerEntity;
import com.cricket.scoretrackingservice.repository.ScoreTrackerRepository;
@Service
public class ScoreTrackerService {
	
	@Autowired
	ScoreTrackerRepository scoreTrackerRepository;

	public void saveScore(ScoreTrackerEntity scoreTrackerEntity) {
		scoreTrackerRepository.save(scoreTrackerEntity);
		
	}
	
	public ScoreTrackerEntity findByMagicIdAndOpponentsAndDateOfMatch(String magicId,String opponents,LocalDate dateOfMatch) {
		ScoreTrackerEntity scoreTrackerEntity=scoreTrackerRepository.findByMagicIdAndOpponentsAndDateOfMatch(magicId, opponents, dateOfMatch);
		return scoreTrackerEntity;
	}

	public ScoreTrackerEntity findByMagicID(String magicId) {
		return scoreTrackerRepository.findByMagicId(magicId);
	}

}
