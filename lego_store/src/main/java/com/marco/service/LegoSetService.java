package com.marco.service;

import com.marco.dao.LegoSetRepository;
import com.marco.model.LegoDifficulty;
import com.marco.model.LegoSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LegoSetService {

    @Autowired
    private LegoSetRepository legoSetRepository;

    public Collection<LegoSet> getAll() {
        Sort themeSort = Sort.by("theme").ascending();
        Collection<LegoSet> result = legoSetRepository.findAll(themeSort);
        return result;
    }

    public Collection<LegoSet> getByTheme(String theme) {
        Sort themeSort = Sort.by("theme").ascending();
        Collection<LegoSet> result = legoSetRepository.findAllByThemeContains(theme, themeSort);
        return result;
    }

    public Collection<LegoSet> getByDifficulty(String level) {
        Collection<LegoSet> result = legoSetRepository.findAllByDifficultyEquals(level.toUpperCase());
        return result;
    }
    public LegoSet get(String id) {
        LegoSet result = legoSetRepository.findById(id).orElse(null);
        return result;
    }

    public void add(LegoSet legoSet) {
        legoSetRepository.insert(legoSet);
    }

    public void update(LegoSet legoSet) {
        legoSetRepository.save(legoSet);
    }

    public void delete(String id) {
        legoSetRepository.deleteById(id);
    }


    public Collection<LegoSet> getByDifficultyAndNameContains(LegoDifficulty hard, String name) {
        Collection<LegoSet> result = legoSetRepository.findAllByDifficultyAndNameStartingWith(hard, name);
        return result;
    }

    public Collection<LegoSet> getByDeliveryFeeLessThan(int price) {
        Collection<LegoSet> result = legoSetRepository.findByDeliveryFeeLessThan(price);
        return result;
    }

    public Collection<LegoSet> getByReviewsRatingGreaterEqualThan(int rating) {
        Collection<LegoSet> result = legoSetRepository.findByReviewRatingGreaterEqualThan(rating);
        return result;
    }
}
