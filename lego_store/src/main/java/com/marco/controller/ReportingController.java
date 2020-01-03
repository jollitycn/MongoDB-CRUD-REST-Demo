package com.marco.controller;

import com.marco.model.AvgRating;
import com.marco.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "legostore/api/report")
public class ReportingController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/avgRating", method = RequestMethod.GET)
    public List<AvgRating> getAvgRating() {
        return reportService.getAvgRatingReport();
    }

}
