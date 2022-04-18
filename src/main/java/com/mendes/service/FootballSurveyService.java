package com.mendes.service;

import com.mendes.model.dto.FootballSurveyDto;
import com.mendes.model.dto.PollsterDto;
import com.mendes.model.entity.FootballSurvey;
import com.mendes.model.entity.Pollster;
import com.mendes.repository.FootballSurveyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mendes
 */

@Service
public class FootballSurveyService {

    private final FootballSurveyRepository footballSurveyRepository;
    private final PollsterService pollsterService;

    public FootballSurveyService(FootballSurveyRepository footballSurveyRepository, PollsterService pollsterService) {
        this.footballSurveyRepository = footballSurveyRepository;
        this.pollsterService = pollsterService;
    }

    public FootballSurvey findById(Long id) {
        FootballSurvey footballSurvey = null;
        Optional<FootballSurvey> optionalFootballSurvey = footballSurveyRepository.findById(id);
        if (optionalFootballSurvey.isPresent()) {
            footballSurvey = optionalFootballSurvey.get();
        }
        return footballSurvey;
    }

    public FootballSurveyDto getById(Long id) {
        FootballSurveyDto footballSurveyDto = null;
        FootballSurvey footballSurvey = findById(id);
        if (footballSurvey != null) {
            footballSurveyDto = fillFootballSurveyDto(footballSurvey);
        }
        return footballSurveyDto;
    }

    private FootballSurveyDto fillFootballSurveyDto(FootballSurvey footballSurvey) {
        FootballSurveyDto footballSurveyDto = new FootballSurveyDto();
        footballSurveyDto.setId(footballSurvey.getId());
        footballSurveyDto.setName(footballSurvey.getName());
        footballSurveyDto.setSurname(footballSurvey.getSurname());
        footballSurveyDto.setGender(footballSurvey.getGender());
        footballSurveyDto.setDateOfBirth(footballSurvey.getDateOfBirth());
        footballSurveyDto.setFavoriteFootballTeam(footballSurvey.getFavoriteFootballTeam());
        footballSurveyDto.setDescription(footballSurvey.getDescription());
        PollsterDto pollsterDto = new PollsterDto();
        pollsterDto.setId(footballSurvey.getPollster().getId());
        pollsterDto.setName(footballSurvey.getPollster().getName());
        pollsterDto.setSurname(footballSurvey.getPollster().getSurname());
        footballSurveyDto.setPollster(pollsterDto);
        return footballSurveyDto;
    }

    private FootballSurvey fillFootballSurvey(FootballSurveyDto footballSurveyDto, FootballSurvey footballSurvey) {
        footballSurvey.setName(footballSurveyDto.getName());
        footballSurvey.setSurname(footballSurveyDto.getSurname());
        footballSurvey.setGender(footballSurveyDto.getGender());
        footballSurvey.setDateOfBirth(footballSurveyDto.getDateOfBirth());
        footballSurvey.setFavoriteFootballTeam(footballSurveyDto.getFavoriteFootballTeam());
        footballSurvey.setDescription(footballSurveyDto.getDescription());
        Pollster pollster = new Pollster();
        pollster.setName(footballSurveyDto.getPollster().getName());
        pollster.setSurname(footballSurveyDto.getPollster().getSurname());
        footballSurvey.setPollster(pollster);
        return footballSurvey;
    }

    @Transactional
    public FootballSurveyDto save(FootballSurveyDto footballSurveyDto) {
        if (footballSurveyDto.getGender() == 0 || footballSurveyDto.getGender() == 1) {
            FootballSurvey footballSurvey = new FootballSurvey();
            FootballSurvey returnFootballSurvey = fillFootballSurvey(footballSurveyDto, footballSurvey);
            pollsterService.save(returnFootballSurvey.getPollster());
            footballSurveyRepository.save(returnFootballSurvey);
            footballSurveyDto.setId(returnFootballSurvey.getId());
        }
        return footballSurveyDto;
    }

    public List<FootballSurveyDto> list() {
        List<FootballSurveyDto> footballSurveyDtos = new ArrayList<>();
        List<FootballSurvey> footballSurveys = footballSurveyRepository.findAll();
        footballSurveys.forEach(footballSurvey -> {
            FootballSurveyDto footballSurveyDto = fillFootballSurveyDto(footballSurvey);
            footballSurveyDtos.add(footballSurveyDto);
        });
        return footballSurveyDtos;
    }

    @Transactional
    public FootballSurveyDto update(FootballSurveyDto footballSurveyDto) {
        FootballSurvey footballSurvey = findById(footballSurveyDto.getId());
        if (footballSurvey == null) {
            return null;
        }
        if (footballSurveyDto.getGender() == 0 || footballSurveyDto.getGender() == 1) {
            FootballSurvey returnFootballSurvey = fillFootballSurvey(footballSurveyDto, footballSurvey);
            pollsterService.save(returnFootballSurvey.getPollster());
            footballSurveyRepository.save(returnFootballSurvey);
        }
        return footballSurveyDto;
    }

    public void delete(Long id) {
        FootballSurvey footballSurvey = findById(id);
        footballSurveyRepository.delete(footballSurvey);
    }
}
