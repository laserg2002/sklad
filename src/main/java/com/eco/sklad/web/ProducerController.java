package com.eco.sklad.web;

import com.eco.sklad.domain.Country;
import com.eco.sklad.domain.Producer;
import com.eco.sklad.repository.CountryRepository;
import com.eco.sklad.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

//@Controller
@RestController
public class ProducerController {
    @Autowired
    ProducerRepository proRepo;
    @Autowired
    CountryRepository couRepo;
    ModelAndView modelEdit = new ModelAndView("produceredit");
//    @ModelAttribute
//    List<Country> countryList = couRepo.findAll() ;

    @RequestMapping(value = "/producers", method = GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("producerlist");
        modelAndView.addObject("producerlist", proRepo.findAll());
        return modelAndView;
    }

    @RequestMapping(path = "producers/edit/{idPr}")
    public ModelAndView editProducerForm( @PathVariable int idPr,
//                                         ModelAndView modelAndView,
                                 @ModelAttribute Country country ) {
//        ModelAndView modelEdit = new ModelAndView("produceredit");
//        modelAndView.setViewName("produceredit");
        Producer producer = proRepo.findByIdPr(idPr);
        modelEdit.addObject("producer", producer);
        modelEdit.addObject("countrylist",couRepo.findAll() );
//        System.out.println(producer);
        return modelEdit;
    }
//
    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView producerEditPost(@Valid @ModelAttribute Producer producer, BindingResult bindingResult, @ModelAttribute Country country) {
//        System.out.println(producer);
        producer.setCountry(country);

//        int a = producer.getCountry().getId();
//        String b = producer.getCategoryProducer();
//        int c = producer.getIdPr();

        if (bindingResult.hasErrors()) {

            System.out.println(producer);
            System.out.println(bindingResult);
            modelEdit.addObject("bindingresult", bindingResult);
            return modelEdit;
        }
//        System.out.println("category"+b);
//        System.out.println("country"+a);
//        System.out.println("id"+c);
        proRepo.updateProducer(producer.getIdPr(),producer.getCategoryProducer(),producer.getCountry().getId());
        return new ModelAndView("redirect:/producers/");
    }

    @RequestMapping( value = "/producers/add")
    public ModelAndView producerNew(ModelAndView modelAndView, @ModelAttribute Country country) {
        modelAndView.setViewName("produceradd");
        modelAndView.addObject(new Producer());
        modelAndView.addObject("countrylist",couRepo.findAll() );
        return modelAndView;
    }
    @RequestMapping( method = RequestMethod.POST, value = "/producers/new")
    public ModelAndView producerNewPost(@ModelAttribute Producer producer, @ModelAttribute Country country ) {
        producer.setCountry(country);
        System.out.println(producer);
        proRepo.addProducer( producer.getFullName(),producer.getCategoryProducer(),country.getId());
        return new ModelAndView("redirect:/producers/");
    }

    //    public String greetingForm(ModelAndView modelAndView) {
//    @RequestMapping(value = "/greeting2", method = GET)
//        modelAndView.setViewName("greeting2");
//        modelAndView.addObject(new Producer());
//        return "greeting";
//    }

//    public Producer findById(Integer id) {
//        return proRepo.findById(id);
//    }


 }

