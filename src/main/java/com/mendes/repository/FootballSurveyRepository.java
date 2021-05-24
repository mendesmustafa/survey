package com.mendes.repository;

import com.mendes.model.FootballSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */

@Repository
public interface FootballSurveyRepository extends JpaRepository<FootballSurvey, Long> {
}
