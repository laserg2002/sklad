package com.eco.sklad.web;

import com.eco.sklad.domain.*;
import com.eco.sklad.service.ContragentService;
import com.eco.sklad.service.PKOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/pko")
public class PKOController {

        @Autowired
        PKOService pkoService;

        @Autowired
        ContragentService contragentService;

        @ModelAttribute("contragentlist")
        public List<Contragent> allContragentList() {
            return contragentService.findAll();
        }

        @ModelAttribute("cassaoperationlist")
        public List<CassaOperation> allCassaOp() {
            return  Arrays.asList(CassaOperation.values());
        }

        @ModelAttribute("paymenttypelist")
        public List<PaymentType> allPaymTypes() {
            return  Arrays.asList(PaymentType.values());
        }

        @GetMapping
        public String showAllPkos(Pko pko, Model model) {
            model.addAttribute("pkolist", pkoService.findAllDesc());
            return "pko/pkolist";
        }

        @GetMapping("/selectbymanager")
         public String showAllManagerPkos(Pko pko, Model model) {
         model.addAttribute("pkolist", pkoService.findAllByManager());
            return "pko/pkolist";
        }


//        @GetMapping("/selectcontragent")
//        public String selectSupplier( ModelMap model) {
//            model.addAttribute("contragent", new Contragent());
//            return "pko/selectcontragent";
//        }

        @RequestMapping("/edit/{id}")
        public String showPkoForm(@PathVariable("id") Integer id, ModelMap model) {
            Pko pko = pkoService.findOne(id);
            pko.setPkoid(pko.getId());
            System.out.println("hhhhhhhhhhhh"+pko);
            model.addAttribute("pko", pko);
            return "pko/pkoform";
        }


        @GetMapping("/new")
        public String addPkoForm(ModelMap model) {
            Pko pko = new Pko();
            pko.setManagerName(SecurityContextHolder.getContext().getAuthentication().getName());
            model.addAttribute("pko", pko);
            return "pko/pkoform";
        }

        @RequestMapping(value="/add")
        public String addPkoPost(ModelMap model,
                                 @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
                                 @RequestParam("payment") String payment,
                                 @RequestParam("cassa") String cassa,
                                 @ModelAttribute Pko pko,
                                 BindingResult bindingResult) {

            PaymentType paymentType = PaymentType.fromString(payment);

            CassaOperation cassaOperation = CassaOperation.fromString(cassa);
            pko.setId(pko.getPkoid());
            pko.setPaymentType(paymentType);
            pko.setCassaOperation(cassaOperation);
            pko.setPkoDate(oDate);
            System.out.println("jjjjjjjjjjjjjjjjjjj"+pko);

            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult);
                return "pko/pkoform";
            }
            pkoService.savePko(pko);

            return "redirect:/pko";
        }

        @RequestMapping(value = "/delete/{id}")
        public String delete(@PathVariable int id, ModelMap model) {
            pkoService.delete(id);
            return "rеdirect:/pko";
        }

    }


