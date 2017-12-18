package com.dyankova.userfeatures.service;

import com.dyankova.userfeatures.model.Feature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dilyanayankova on 12/16/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeatureServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FeatureService featureService;

    @Test
    public void whenGetAllFeatures_thenReturnFeatures(){

        Feature feature = new Feature(1, "ad-free", true);
        entityManager.persist(feature);
        entityManager.flush();

       List<Feature> list =  FeatureService.getAllFeatures();

       assertThat(list.size()).isEqualTo(1);


    }






}
