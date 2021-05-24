package com.mendes.repository;

import com.mendes.model.Pollster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */

@Repository
public interface PollsterRepository extends JpaRepository<Pollster, Long> {
}
