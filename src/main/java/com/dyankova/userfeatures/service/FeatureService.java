package com.dyankova.userfeatures.service;


import com.dyankova.userfeatures.model.Feature;
import com.dyankova.userfeatures.model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dilyanayankova on 12/8/17.
 */
public class FeatureService {

    public static List<Feature> getAllFeatures() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Feature");

        return (ArrayList<Feature>) query.list();
    }


    public static List<Feature> getFeaturesForUser(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery(" select f.id, f.name, uf.enabled FROM Feature as f" +
                " join UserFeature as uf on f.id = uf.featureId" +
                " where uf.userId = :userId");
        query.setParameter("userId", userId);

        List<Object[]> queryResults = query.list();
        List<Feature> features = new ArrayList<Feature>();

        for (Object[] row : queryResults) {
            Feature feature = new Feature((Long) row[0], (String) row[1], (Boolean) row[2]);
            features.add(feature);
        }

        return features;
    }

    public static List<Feature> getAllFeaturesForUser(Long userId) {
        List<Feature> allFeatures = (ArrayList<Feature>) getAllFeatures();
        List<Feature> userFeatures = (ArrayList<Feature>) getFeaturesForUser(userId);

        int indexOfFeature = -1;
        for (Feature feature : userFeatures) {

            indexOfFeature = allFeatures.indexOf(feature);
            if (indexOfFeature != -1) {
                allFeatures.get(indexOfFeature).setEnabled(feature.getEnabled());
            }
        }
        return allFeatures;
    }


}