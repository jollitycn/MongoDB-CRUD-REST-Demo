package com.marco.controller;

import com.marco.model.LegoDifficulty;
import com.marco.model.LegoSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.marco.service.LegoSetService;

import java.util.Collection;

@RestController
@RequestMapping("legostore/api")
public class LegoStoreController {

    @Autowired
    private LegoSetService legoSetService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<LegoSet> getAll() {
        return legoSetService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LegoSet get(@PathVariable String id) {
        return legoSetService.get(id);
    }

    @RequestMapping(value = "/byTheme/{theme}", method = RequestMethod.GET)
    public Collection<LegoSet> getByTheme(@PathVariable String theme) {
        return legoSetService.getByTheme(theme);
    }

    @RequestMapping(value = "/byLevel/{level}", method = RequestMethod.GET)
    public Collection<LegoSet> getByLevel(@PathVariable String level) {
        return legoSetService.getByDifficulty(level);
    }

    @RequestMapping(value = "/hardAndNameStartWith/{name}", method = RequestMethod.GET)
    public Collection<LegoSet> getHardLevelAndNameStartWith(@PathVariable String name) {
        return legoSetService.getByDifficultyAndNameContains(LegoDifficulty.HARD, name);
    }

    @RequestMapping(value = "/byDeliveryFeeLessThan/{price}", method =  RequestMethod.GET)
    public Collection<LegoSet> getByDeliveryFeeLessThan(@PathVariable int price) {
        return legoSetService.getByDeliveryFeeLessThan(price);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody LegoSet legoSet) {
        legoSetService.add(legoSet);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody LegoSet legoSet) {
        legoSetService.update(legoSet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        legoSetService.delete(id);
    }
}
