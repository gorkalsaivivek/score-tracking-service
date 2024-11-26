package com.cricket.scoretrackingservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.scoretrackingservice.dto.ScoreTrackerDTO;
import com.cricket.scoretrackingservice.entity.ScoreTrackerEntity;
import com.cricket.scoretrackingservice.service.ScoreTrackerService;

@RestController
public class ScoreTrackerController {
	
	@Autowired
	ScoreTrackerService scoreTrackerService;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping(path = "/addScore")
	public ScoreTrackerDTO addScore(@RequestBody ScoreTrackerDTO scoreTrackerDTO) {
		scoreTrackerDTO.setId(null); 
		ScoreTrackerEntity scoreTrackerEntity=mapper.map(scoreTrackerDTO, ScoreTrackerEntity.class);
		scoreTrackerService.saveScore(scoreTrackerEntity);
		return scoreTrackerDTO;
		
	}
	
	@PutMapping(path = "/editScore")
	public ScoreTrackerDTO editScore(@RequestBody ScoreTrackerDTO scoreTrackerDTO) {
		scoreTrackerDTO.setId(null); 
		//ScoreTrackerEntity scoreTrackerEntity=mapper.map(scoreTrackerDTO, ScoreTrackerEntity.class);
		ScoreTrackerEntity scoreTrackerEntity=scoreTrackerService.findByMagicIdAndOpponentsAndDateOfMatch(scoreTrackerDTO.getMagicId(),scoreTrackerDTO.getOpponents(),scoreTrackerDTO.getDateOfMatch());
		
		if(scoreTrackerDTO.getIsPlayerNotOut()!=null) {
			scoreTrackerEntity.setPlayerNotOut(scoreTrackerDTO.getIsPlayerNotOut());
		}
		scoreTrackerService.saveScore(scoreTrackerEntity);
		return scoreTrackerDTO;
		
	}
	@GetMapping("/getScore/{magicId}")
	public ScoreTrackerDTO getPlayerByMagicId (@PathVariable String  magicId) {
		ScoreTrackerEntity scoreTrackerEntity=scoreTrackerService.findByMagicID(magicId);
		return mapper.map(scoreTrackerEntity, ScoreTrackerDTO.class);
	}

}
