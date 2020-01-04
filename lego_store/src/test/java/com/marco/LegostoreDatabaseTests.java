package com.marco;

import com.marco.dao.LegoSetRepository;
import com.marco.model.DeliveryInfo;
import com.marco.model.LegoDifficulty;
import com.marco.model.LegoSet;
import com.marco.model.ProductReview;
import com.marco.service.LegoSetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class LegostoreDatabaseTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private LegoSetRepository legoSetRepository;

    @Before
    public void before() {
        legoSetRepository.deleteAll();
        prePopulateTestValues();
    }

    private void prePopulateTestValues() {
        LegoSet milleniumFalcon = new LegoSet(
                "Millennium Falcon",
                "Star Wars",
                LegoDifficulty.HARD,
                new DeliveryInfo(LocalDate.now().plusDays(1), 30, true),
                Arrays.asList(
                        new ProductReview("Dan", 7),
                        new ProductReview("Anna", 10),
                        new ProductReview("John", 8)
                )/*,
                creditCardPayment*/);

        LegoSet skyPolice = new LegoSet(
                "Sky Police Air Base",
                "City",
                LegoDifficulty.MEDIUM,
                new DeliveryInfo(LocalDate.now().plusDays(3), 50, true),
                Arrays.asList(
                        new ProductReview("Dan", 5),
                        new ProductReview("Andrew", 8)
                )/*,
                creditCardPayment*/);

        legoSetRepository.insert(milleniumFalcon);
        legoSetRepository.insert(skyPolice);
    }

    @Test
    public void findAllGreatReviews() {
        List<LegoSet> result = (List<LegoSet>) legoSetRepository.findByReviewRatingGreaterEqualThan(10);

        assertEquals(1, result.size());
        assertEquals("Millennium Falcon", result.get(0).getName());
    }

    @Test
    public void findByDeliveryFeeLessThan_51() {
        List<LegoSet> result = (List<LegoSet>) legoSetRepository.findByDeliveryFeeLessThan(51);

        assertEquals(2, result.size());
        assertEquals("Sky Police Air Base", result.get(1).getName());
    }

}
