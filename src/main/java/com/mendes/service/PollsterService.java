package com.mendes.service;

import com.mendes.model.entity.Pollster;
import com.mendes.repository.PollsterRepository;
import org.springframework.stereotype.Service;

/**
 * @author mendes
 */

@Service
public class PollsterService {

    private final PollsterRepository pollsterRepository;

    public PollsterService(PollsterRepository pollsterRepository) {
        this.pollsterRepository = pollsterRepository;
    }

    public void save(Pollster model) {
        pollsterRepository.save(model);
    }
}
