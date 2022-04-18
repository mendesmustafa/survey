package com.mendes.service;

import com.mendes.model.dto.LifeSurveyDto;
import com.mendes.model.dto.PollsterDto;
import com.mendes.model.entity.LifeSurvey;
import com.mendes.model.entity.Pollster;
import com.mendes.repository.LifeSurveyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mendes
 */

@Service
public class LifeSurveyService {

    private final LifeSurveyRepository lifeSurveyRepository;
    private final PollsterService pollsterService;

    public LifeSurveyService(LifeSurveyRepository lifeSurveyRepository, PollsterService pollsterService) {
        this.lifeSurveyRepository = lifeSurveyRepository;
        this.pollsterService = pollsterService;
    }

    public LifeSurvey findById(Long id) {
        LifeSurvey lifeSurvey = null;
        Optional<LifeSurvey> optionalLifeSurvey = lifeSurveyRepository.findById(id);
        if (optionalLifeSurvey.isPresent()) {
            lifeSurvey = optionalLifeSurvey.get();
        }
        return lifeSurvey;
    }

    public LifeSurveyDto getById(Long id) {
        LifeSurveyDto lifeSurveyDto = null;
        LifeSurvey lifeSurvey = findById(id);
        if (lifeSurvey != null) {
            lifeSurveyDto = fillLifeSurveyDto(lifeSurvey);
        }
        return lifeSurveyDto;
    }

    private LifeSurveyDto fillLifeSurveyDto(LifeSurvey lifeSurvey) {
        LifeSurveyDto lifeSurveyDto = new LifeSurveyDto();
        lifeSurveyDto.setId(lifeSurvey.getId());
        lifeSurveyDto.setName(lifeSurvey.getName());
        lifeSurveyDto.setSurname(lifeSurvey.getSurname());
        lifeSurveyDto.setGender(lifeSurvey.getGender());
        lifeSurveyDto.setDateOfBirth(lifeSurvey.getDateOfBirth());
        lifeSurveyDto.setDescription(lifeSurvey.getDescription());
        lifeSurveyDto.setHappinessRate(lifeSurvey.getHappinessRate());
        lifeSurveyDto.setHappyThing(lifeSurvey.getHappyThing());
        lifeSurveyDto.setUnhappyThing(lifeSurvey.getUnhappyThing());
        PollsterDto pollsterDto = new PollsterDto();
        pollsterDto.setId(lifeSurvey.getPollster().getId());
        pollsterDto.setName(lifeSurvey.getPollster().getName());
        pollsterDto.setSurname(lifeSurvey.getPollster().getSurname());
        lifeSurveyDto.setPollster(pollsterDto);
        return lifeSurveyDto;
    }

    private LifeSurvey fillLifeSurvey(LifeSurveyDto lifeSurveyDto, LifeSurvey lifeSurvey) {
        lifeSurvey.setName(lifeSurveyDto.getName());
        lifeSurvey.setSurname(lifeSurveyDto.getSurname());
        lifeSurvey.setGender(lifeSurveyDto.getGender());
        lifeSurvey.setDateOfBirth(lifeSurveyDto.getDateOfBirth());
        lifeSurvey.setDescription(lifeSurveyDto.getDescription());
        lifeSurvey.setHappinessRate(lifeSurveyDto.getHappinessRate());
        lifeSurvey.setHappyThing(lifeSurveyDto.getHappyThing());
        lifeSurvey.setUnhappyThing(lifeSurveyDto.getUnhappyThing());
        Pollster pollster = new Pollster();
        pollster.setName(lifeSurveyDto.getPollster().getName());
        pollster.setSurname(lifeSurveyDto.getPollster().getSurname());
        lifeSurvey.setPollster(pollster);
        return lifeSurvey;
    }

    @Transactional
    public LifeSurveyDto save(LifeSurveyDto lifeSurveyDto) {
        if ((lifeSurveyDto.getGender() == 0 || lifeSurveyDto.getGender() == 1)
                && (lifeSurveyDto.getHappinessRate() >= 1 && lifeSurveyDto.getHappinessRate() <= 10)) {
            LifeSurvey lifeSurvey = new LifeSurvey();
            LifeSurvey returnLifeSurvey = fillLifeSurvey(lifeSurveyDto, lifeSurvey);
            pollsterService.save(returnLifeSurvey.getPollster());
            lifeSurveyRepository.save(returnLifeSurvey);
            lifeSurveyDto.setId(returnLifeSurvey.getId());
        }
        return lifeSurveyDto;
    }

    public List<LifeSurveyDto> list() {
        List<LifeSurveyDto> lifeSurveyDtos = new ArrayList<>();
        List<LifeSurvey> lifeSurveys = lifeSurveyRepository.findAll();
        lifeSurveys.forEach(lifeSurvey -> {
            LifeSurveyDto lifeSurveyDto = fillLifeSurveyDto(lifeSurvey);
            lifeSurveyDtos.add(lifeSurveyDto);
        });
        return lifeSurveyDtos;
    }

    @Transactional
    public LifeSurveyDto update(LifeSurveyDto lifeSurveyDto) {
        LifeSurvey lifeSurvey = findById(lifeSurveyDto.getId());
        if (lifeSurvey == null) {
            return null;
        }
        if (lifeSurveyDto.getGender() == 0 || lifeSurveyDto.getGender() == 1
                || lifeSurveyDto.getHappinessRate() >= 1 || lifeSurveyDto.getHappinessRate() <= 10) {
            LifeSurvey returnLifeSurvey = fillLifeSurvey(lifeSurveyDto, lifeSurvey);
            pollsterService.save(returnLifeSurvey.getPollster());
            lifeSurveyRepository.save(returnLifeSurvey);
        }
        return lifeSurveyDto;
    }

    public void delete(Long id) {
        LifeSurvey lifeSurvey = findById(id);
        lifeSurveyRepository.delete(lifeSurvey);
    }
}
