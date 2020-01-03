package com.marco.service;

import com.marco.model.AvgRating;
import com.marco.model.LegoSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Service
public class ReportService {

    @Autowired
    private MongoTemplate mongoTemplate; // for the data projection this kind of advance feature, we need to use MongoTemplate rather than MongoRepository tool.

    public List<AvgRating> getAvgRatingReport() {

        /* construct a aggregation/projection query statement as below
            db.legosets.aggregate([{
                    $project : {
                legoSetName : "$name",
                        avgRating : {$avg : "$reviews.rating"}
            }
            }])
        note: in the pure mongodb query language - left is the result to output, right is the data source and it's logic for projection calculation.*/

        ProjectionOperation projectToMatchModel = project()   // this is a static factory method from ProjectionOperation class
                .andExpression("name").as("productName")
                .andExpression("{$avg : '$reviews.rating'}").as("avgRating");
        Aggregation avgRatingAggregation = newAggregation(LegoSet.class, projectToMatchModel);

        List<AvgRating> result = mongoTemplate
                .aggregate(avgRatingAggregation, LegoSet.class, AvgRating.class)
                .getMappedResults();

        return result;
    }
}
