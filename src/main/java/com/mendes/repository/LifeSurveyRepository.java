package com.mendes.repository;

import com.mendes.model.entity.LifeSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */

@Repository
public interface LifeSurveyRepository extends JpaRepository<LifeSurvey, Long> {
}
