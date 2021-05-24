package com.mendes.service;

import com.mendes.model.FootballSurvey;
import com.mendes.repository.FootballSurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author mendes
 */

@Service
public class FootballSurveyService {

    private FootballSurveyRepository footballSurveyRepository;
    private PollsterService pollsterService;

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

    public FootballSurvey save(FootballSurvey footballSurveyModel) throws Exception {

        if (footballSurveyModel.getGender() == 0 || footballSurveyModel.getGender() == 1) {
            pollsterService.save(footballSurveyModel.getPollster());
            footballSurveyModel = footballSurveyRepository.save(footballSurveyModel);
        } else {
            throw new Exception("cinsiyet kız için 0 erkek için 1 olmalıdır..");
        }

        return footballSurveyModel;
    }

    public List<FootballSurvey> list() {
        List<FootballSurvey> footballSurveys = footballSurveyRepository.findAll();
        return footballSurveys;
    }

    public FootballSurvey update(FootballSurvey footballSurveyModel) throws Exception {

        FootballSurvey footballSurvey = findById(footballSurveyModel.getId());

        if (footballSurvey == null) {
            throw new Exception("İd bulunamadı..");
        }

        if (footballSurveyModel.getGender() == 0 || footballSurveyModel.getGender() == 1) {
            pollsterService.save(footballSurveyModel.getPollster());
            footballSurveyRepository.save(footballSurveyModel);
        } else {
            throw new Exception("cinsiyet kız için 0 erkek için 1 olmalıdır..");
        }

        return footballSurveyModel;
    }

    public void delete(Long id) {
        FootballSurvey footballSurvey = findById(id);
        footballSurveyRepository.delete(footballSurvey);
    }
}
