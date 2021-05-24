package com.mendes.service;

import com.mendes.model.LifeSurvey;
import com.mendes.repository.LifeSurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author mendes
 */

@Service
public class LifeSurveyService {

    private LifeSurveyRepository lifeSurveyRepository;
    private PollsterService pollsterService;

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

    public LifeSurvey save(LifeSurvey lifeSurveyModel) throws Exception {

        if ((lifeSurveyModel.getGender() == 0 || lifeSurveyModel.getGender() == 1)
                && (lifeSurveyModel.getHappinessRate() >= 1 && lifeSurveyModel.getHappinessRate() <= 10)) {
            pollsterService.save(lifeSurveyModel.getPollster());
            lifeSurveyModel = lifeSurveyRepository.save(lifeSurveyModel);
        } else {
            throw new Exception("cinsiyet kız için 0 erkek için 1 olmalıdır ve mutluluk oranı 1 ile 10 arasında olmalı..");
        }

        return lifeSurveyModel;
    }

    public List<LifeSurvey> list() {
        List<LifeSurvey> lifeSurveys = lifeSurveyRepository.findAll();
        return lifeSurveys;
    }

    public LifeSurvey update(LifeSurvey lifeSurveyModel) throws Exception {

        LifeSurvey lifeSurvey = findById(lifeSurveyModel.getId());

        if (lifeSurvey == null) {
            throw new Exception("İd bulunamadı..");
        }

        if (lifeSurveyModel.getGender() == 0 || lifeSurveyModel.getGender() == 1
                || lifeSurveyModel.getHappinessRate() >= 1 || lifeSurveyModel.getHappinessRate() <= 10) {
            pollsterService.save(lifeSurveyModel.getPollster());
            lifeSurveyRepository.save(lifeSurveyModel);
        } else {
            throw new Exception("cinsiyet kız için 0 erkek için 1 olmalıdır ve mutluluk oranı 1 ile 10 arasında olmalı..");
        }

        return lifeSurveyModel;
    }

    public void delete(Long id) {
        LifeSurvey lifeSurvey = findById(id);
        lifeSurveyRepository.delete(lifeSurvey);
    }
}
