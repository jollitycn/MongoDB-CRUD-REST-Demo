package com.marco.service;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.marco.model.LegoSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeLog(order = "001")
public class DataMigrations {

    @ChangeSet(order = "001", author = "marco", id = "update nb parts")
    public void updateNbParts(MongoTemplate mongoTemplate) {
        String targetField = "nbParts";
        int value = 562;
        Criteria criteria = new Criteria()
                .orOperator(
                      Criteria.where(targetField).is(0),
                      Criteria.where(targetField).is(null)
                );
        mongoTemplate.updateMulti(
                new Query(criteria),
                Update.update(targetField, value),
                LegoSet.class
        );

        System.out.println("Applied changeset 001");
    }
}
