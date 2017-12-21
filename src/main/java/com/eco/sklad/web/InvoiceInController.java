package com.eco.sklad.web;

import com.eco.sklad.DTO.InvoiceDTO;
import com.eco.sklad.DTO.InvoiceLineDTO;
import com.eco.sklad.domain.*;
import com.eco.sklad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value="/supply")
public class InvoiceInController {


    @Autowired
    ProductService productService;

    @Autowired
    SuppliesService suppliesService;

    @Autowired
    SupplyLinesService supplyLinesService;

    @Autowired
    ContragentService contragentService;

    InvoiceDTO invoiceDTO = new InvoiceDTO();

    ArrayList<InvoiceLineDTO> invoiceLineDTOS = new ArrayList<>();

    @ModelAttribute("productlist")
    public List<Product> allProductsList() {
            return productService.findAll();
        }

    @ModelAttribute("contragentlist")
    public List<Contragent> allContragents() {
            return  contragentService.findAll();
        }

    @GetMapping
    public String showAllSupplies(Supplies supplies, Model model) {

        return "invoice/supplieslist";
    }

    @GetMapping("/selectsupplier")
    public String selectSupplier( ModelMap model) {
        model.addAttribute("contragent", new Contragent());
        model.addAttribute("invoicedto", invoiceDTO);
        return "supply/selectsupplier";
    }

    @GetMapping("/supplier/")
    public String selectSupplierPost(@RequestParam("contragentId") Integer id,
                                     @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate, ModelMap model) {
        invoiceDTO.setContragentId(id);
        invoiceDTO.setOrderDate(oDate);
        invoiceDTO.setContragentName(contragentService.findOne(id).getBalansName());
        invoiceLineDTOS.clear();
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", new InvoiceLineDTO());
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        return "supply/selectproduct";
    }

    @GetMapping("/product")
    public String selectProduct(@RequestParam(value = "id", required = false) Integer id, @ModelAttribute InvoiceLineDTO invoiceLineDTO, ModelMap model){
        if (id!=null){
            invoiceLineDTO.setProductId(id);
            invoiceLineDTO.setItemTotal(invoiceLineDTO.getPrice().multiply(new BigDecimal(invoiceLineDTO.getQuantity())));
            invoiceLineDTO.setProductName(productService.findOne(id).getShortName());
            System.out.println(invoiceLineDTO);

            invoiceLineDTOS.add(invoiceLineDTO);
            Set<InvoiceLineDTO> dtosSet = new HashSet<>(invoiceLineDTOS);
            invoiceLineDTOS=new ArrayList<>(dtosSet);
            System.out.println(invoiceLineDTOS);
            System.out.println("JJJJJJJJJJJJJJ");
        }
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        return "supply/invoice";
    }


    @RequestMapping(value="/addline")
    public String addInvoiceLine(@Valid @ModelAttribute InvoiceDTO invoiceDTO, @ModelAttribute("invoicelinedto") InvoiceLineDTO invoiceLineDTO, Model model, BindingResult bindingResult) {
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        return "supply/selectproduct";
    }

    @RequestMapping(value = "/invoiceline/delete/{id}")
    public String deleteInvoiceLine(@PathVariable int id, @ModelAttribute InvoiceDTO invoiceDTO, @ModelAttribute("invoicelinedto") InvoiceLineDTO invoiceLineDTO, ModelMap model) {
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        invoiceLineDTOS.remove(id-1);
        return "redirect:/supply/product";
    }

    @RequestMapping(value = "/clear")
    public String clearInvoice (@ModelAttribute InvoiceDTO invoiceDTO, ModelMap model){
        invoiceLineDTOS.clear();
        return "redirect:/supply/product";
    }

    @RequestMapping("/invoiceline/edit/{id}")
    public String editLine(@PathVariable("id") int id, @ModelAttribute InvoiceDTO invoiceDTO, @ModelAttribute("invoicelinedto") InvoiceLineDTO invoiceLineDTO, ModelMap model) {
        invoiceLineDTO=invoiceLineDTOS.get(id-1);
        invoiceLineDTOS.remove(id-1);
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        return "supply/selectproduct";
    }

    @RequestMapping(value="/addinvoice", method = RequestMethod.POST)
    public String addInvoicePost(ModelMap model) {

//        if (bindingResult.hasErrors()) {
//            return "invoice/invoice";
//        }
        System.out.println(invoiceDTO);

        suppliesService.addSupply(invoiceDTO, invoiceLineDTOS);
        return "/index";
    }



}
