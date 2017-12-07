package com.eco.sklad.web;

import com.eco.sklad.DTO.InvoiceDTO;
import com.eco.sklad.DTO.InvoiceLineDTO;
import com.eco.sklad.domain.*;
import com.eco.sklad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

//    @ModelAttribute("invoicedto")
    InvoiceDTO invoiceDTO = new InvoiceDTO();

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
//        model.addAttribute("contragent", new Contragent());
        return "invoice/supplieslist";
    }
    @GetMapping("/selectsupplier")
    public String selectSupplier( ModelMap model) {
        model.addAttribute("contragent", new Contragent());
        return "supply/selectsupplier";
    }
    @GetMapping("/supplier/")
    public String selectSupplierPost( @RequestParam("id") Integer id, ModelMap model) {
//        InvoiceDTO invoiceDTO = new InvoiceDTO(id);
        invoiceDTO.setContragentId(id);
        invoiceDTO.setContragentName(contragentService.findOne(id).getBalansName());
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", new InvoiceLineDTO());
        return "supply/selectproduct";
    }

    @GetMapping("/product")
    public String selectProduct(@RequestParam("id") Integer id, ModelMap model){
        InvoiceLineDTO invoiceLineDTO = new InvoiceLineDTO();
        invoiceLineDTO.setProductId(id);
        ///////////////
        System.out.println(invoiceDTO.getInvoiceLinesDTOList().toString());
        System.out.println("JJJJJJJJJJJJJJ");
        invoiceLineDTO.setProductName(productService.findOne(id).getShortName());
//    HARDCODE!!!!!!!    /////////////////////////
        invoiceLineDTO.setPrice(new BigDecimal(10));
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelineslist", invoiceDTO.getInvoiceLinesDTOList());
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        return "supply/invoice";
    }

    @GetMapping("/newinvoice")
    public String newInvoice( ModelMap model) {
        model.addAttribute("invoiceline", new InvoiceLineDTO());
        return "redirect:/supply/newinvoice";
    }

    @PostMapping(value="/addline")
    public String addInvoiceLine(@Valid @ModelAttribute InvoiceDTO invoiceDTO, @ModelAttribute("invoicelinedto") InvoiceLineDTO invoiceLineDTO, Model model, BindingResult bindingResult) {
        ////////////////////////
        System.out.println(invoiceLineDTO);
        invoiceDTO.addInvoiceLineDTO(invoiceLineDTO);
        System.out.println(invoiceDTO.getInvoiceLinesDTOList().toString());
        System.out.println("ddddddd");
        model.addAttribute("invoicedto", invoiceDTO);
        return "supply/selectproduct";
    }

    @RequestMapping("/editline/{id}")
    public String editLine(@PathVariable("id") int id, Model model,  @ModelAttribute InvoiceDTO invoiceDTO) {
//        model.addAttribute("product", product);
        return "invoice/invoice";
    }

    @RequestMapping(value="/addinvoice", method = RequestMethod.POST)
    public String addInvoicePost(@Valid @ModelAttribute InvoiceDTO invoiceDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "invoice/invoice";
        }

//        SuppliesService.addInvoice(invoiceDTO);
        return "invoice/invoicelist";
    }


    @RequestMapping(value = "/deleteline/{id}", method = RequestMethod.GET)
    public String deleteInvoiceLine(@PathVariable int id, Model model, @ModelAttribute InvoiceDTO invoiceDTO) {
        List<InvoiceLineDTO> invoiceLinesDTO = invoiceDTO.getInvoiceLinesDTOList();
        invoiceLinesDTO.remove(id);
        invoiceDTO.setInvoiceLinesDTOList(invoiceLinesDTO);
        return "invoice/invoice";
    }
}
