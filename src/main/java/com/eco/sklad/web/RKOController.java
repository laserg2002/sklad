package com.eco.sklad.web;

import com.eco.sklad.domain.*;
import com.eco.sklad.service.ContragentService;
import com.eco.sklad.service.RKOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/rko")
public class RKOController {

    @Autowired
    RKOService rkoService;

    @Autowired
    ContragentService contragentService;

    @ModelAttribute("contragentlist")
    public List<Contragent> allContragentList() {
        return contragentService.findAll();
    }

    @ModelAttribute("paymentoperationlist")
    public List<PaymentOperation> allPaymOp() {
        return  Arrays.asList(PaymentOperation.values());
    }

    @ModelAttribute("paymenttypelist")
    public List<PaymentType> allPaymTypes() {
        return  Arrays.asList(PaymentType.values());
    }

    @GetMapping
    public String showAllRkos(Model model) {
        model.addAttribute("rkolist", rkoService.findAllDesc());
        return "rko/rkolist";
    }

    @GetMapping("/selectbymanager")
    public String showAllManagerRkos(Rko rko, Model model) {
        model.addAttribute("rkolist", rkoService.findAllByManager());
        return "rko/rkolist";
    }


//        @GetMapping("/selectcontragent")
//        public String selectSupplier( ModelMap model) {
//            model.addAttribute("contragent", new Contragent());
//            return "rko/selectcontragent";
//        }

    @RequestMapping("/edit/{id}")
    public String showRkoForm(@PathVariable("id") Integer id, ModelMap model) {
        Rko rko = rkoService.findOne(id);
        rko.setRkoid(rko.getId());
        System.out.println("hhhhhhhhhhhh"+rko);
        model.addAttribute("rko", rko);
        return "rko/rkoform";
    }


    @RequestMapping("/new")
    public String addRkoForm(ModelMap model) {
        Rko rko = new Rko();
        rko.setManagerName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("rko", rko);
        return "rko/rkoform";
    }

    @RequestMapping(value="/add")
    public String addRkoPost(ModelMap model,
                             @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
                             @RequestParam("payment") String payment,
                             @RequestParam("cassa") String cassa,
                             @ModelAttribute Rko rko,
                             BindingResult bindingResult) {

        PaymentType paymentType = PaymentType.fromString(payment);

        PaymentOperation paymentOperation = PaymentOperation.fromString(cassa);
        rko.setId(rko.getRkoid());
        rko.setPaymentType(paymentType);
        rko.setPaymentOperation(paymentOperation);
        rko.setRkoDate(oDate);
        System.out.println("jjjjjjjjjjjjjjjjjjj"+rko);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "rko/rkoform";
        }
        rkoService.saveRko(rko);

        return "redirect:/rko";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, ModelMap model) {
        rkoService.delete(id);
        return "rеdirect:/rko";
    }

}
