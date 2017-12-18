package com.dyankova.userfeatures.controller;

import com.dyankova.userfeatures.model.Feature;
import com.dyankova.userfeatures.service.FeatureService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dilyanayankova on 12/8/17.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)


    public ModelAndView homePage() {

        return new ModelAndView("pages/home");

    }

    @RequestMapping(value = "/features/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Feature> getFeatures(@PathVariable Long userId)  {

        ArrayList<Feature> features = (ArrayList<Feature>) FeatureService.getAllFeaturesForUser(userId);

        return features;

    }



}