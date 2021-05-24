package com.mendes.service;

import com.mendes.model.Pollster;
import com.mendes.repository.PollsterRepository;
import org.springframework.stereotype.Service;

/**
 * @author mendes
 */

@Service
public class PollsterService {

    private PollsterRepository pollsterRepository;

    public PollsterService(PollsterRepository pollsterRepository) {
        this.pollsterRepository = pollsterRepository;
    }

    public Pollster save(Pollster model) {
        Pollster pollster = pollsterRepository.save(model);
        return pollster;
    }
}
