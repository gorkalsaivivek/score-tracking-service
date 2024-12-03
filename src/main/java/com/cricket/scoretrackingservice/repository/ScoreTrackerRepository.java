package com.cricket.scoretrackingservice.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.scoretrackingservice.entity.ScoreTrackerEntity;

public interface ScoreTrackerRepository extends JpaRepository<ScoreTrackerEntity, Long> {
	ScoreTrackerEntity findByMagicIdAndOpponentsAndDateOfMatch(String magicId,String opponents,LocalDate dateOfMatch);
	ScoreTrackerEntity findByMagicId(String magicId);
}
