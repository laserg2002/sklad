package com.eco.sklad.web;

import com.eco.sklad.domain.*;
import com.eco.sklad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/journal")
public class JournalController {

        @Autowired
        JournalService journalService;

        @Autowired
        PKOService pkoService;

        @Autowired
        SuppliesService suppliesService;

        @Autowired
        RKOService rkoService;

        @Autowired
        OrderService orderService;

        @Autowired
        ContragentService contragentService;

        @GetMapping
        public String showJournal(Journal journal, Model model) {
            model.addAttribute("journallist", journalService.findAll());
            return "journal/journal";
        }

        @GetMapping (value="/showpko/{id}")
        @ResponseBody
         public Pko showPko(@PathVariable int id) {
            return pkoService.findOne(id);
        }

        @GetMapping (value="/showrko/{id}")
        @ResponseBody
        public Rko showRko(@PathVariable int id) {
            return rkoService.findOne(id);
        }

        @GetMapping (value="/showii/{id}")
        @ResponseBody
        public Supplies showInvoice(@PathVariable int id) {
            return suppliesService.findOne(id);
        }

        @GetMapping (value="/showoo/{id}")
        @ResponseBody
        public Order showOrder(@PathVariable int id) {
            return orderService.findOne(id);
        }










//        @GetMapping("/new")
//        public String addPkoForm(ModelMap model) {
//            Pko pko = new Pko();
//            pko.setManagerName(SecurityContextHolder.getContext().getAuthentication().getName());
//            model.addAttribute("pko", pko);
//            return "pko/pkoform";
//        }
//
//        @RequestMapping(value="/add")
//        public String addPkoPost(ModelMap model,
//                                 @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
//                                 @RequestParam("payment") String payment,
//                                 @RequestParam("cassa") String cassa,
//                                 @ModelAttribute Pko pko,
//                                 BindingResult bindingResult) {
//
//            PaymentType paymentType = PaymentType.fromString(payment);
//
//            CassaOperation cassaOperation = CassaOperation.fromString(cassa);
//            pko.setId(pko.getPkoid());
//            pko.setPaymentType(paymentType);
//            pko.setCassaOperation(cassaOperation);
//            pko.setPkoDate(oDate);
//            System.out.println("jjjjjjjjjjjjjjjjjjj"+pko);
//
//            if (bindingResult.hasErrors()) {
//                System.out.println(bindingResult);
//                return "pko/pkoform";
//            }
//            pkoService.savePko(pko);
//
//            return "redirect:/pko";
//        }
//
//        @RequestMapping(value = "/delete/{id}")
//        public String delete(@PathVariable int id, ModelMap model) {
//            pkoService.delete(id);
//            return "rеdirect:/pko";
//        }

    }


