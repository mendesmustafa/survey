package com.mendes.repository;

import com.mendes.model.entity.Pollster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */

@Repository
public interface PollsterRepository extends JpaRepository<Pollster, Long> {
}
