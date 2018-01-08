package com.eco.sklad.web;

import com.eco.sklad.DTO.InvoiceDTO;
import com.eco.sklad.DTO.InvoiceLineDTO;
import com.eco.sklad.domain.*;
import com.eco.sklad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping ("/supplies")
    public String showAllSupplies(Supplies supplies, ModelMap model) {
        model.addAttribute("supplieslist", suppliesService.findAll());
        return "supply/supplieslist";
    }

    @GetMapping("/selectsupplier")
    public String selectSupplier( ModelMap model) {
        model.addAttribute("contragent", new Contragent());
        model.addAttribute("invoicedto", invoiceDTO);
        return "supply/selectsupplier";
    }

    @GetMapping("/supplier/")
    public String selectSupplierPost(@RequestParam("contragentId") Integer id,
                                     @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
                                     ModelMap model) {
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
    public String selectProduct(@RequestParam(value = "id", required = false) Integer id,
                                @ModelAttribute InvoiceLineDTO invoiceLineDTO, ModelMap model){
        if (id!=null){
            invoiceLineDTO.setProductId(id);
            invoiceLineDTO.setItemTotal(invoiceLineDTO.getPrice().multiply(new BigDecimal(invoiceLineDTO.getQuantity())));
            invoiceLineDTO.setProductName(productService.findOne(id).getShortName());
            invoiceLineDTOS.add(invoiceLineDTO);
            Set<InvoiceLineDTO> dtosSet = new HashSet<>(invoiceLineDTOS);
            invoiceLineDTOS=new ArrayList<>(dtosSet);
        }
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        return "supply/invoice";
    }


    @GetMapping("/edittodayinvoice/{id}")
    public String editInvoice(@PathVariable(value = "id") Integer id, ModelMap model){
        Supplies supply = suppliesService.findOne(id);
        invoiceDTO.setId(id);
        invoiceDTO.setContragentId(supply.getSupplier().getId());
        invoiceDTO.setContragentName(supply.getSupplier().getBalansName());
        invoiceDTO.setTotalOrder(supply.getTotal());
        invoiceDTO.setOrderDate(supply.getDateOfSupply());
        invoiceDTO.setInvoiceId(id);
        invoiceLineDTOS.clear();

        List<SupplyLines> supplyList = supply.getSupplyList();
        InvoiceLineDTO invoiceLineDTO = new InvoiceLineDTO();
        int i=1;
        for (SupplyLines sup:supplyList){
            invoiceLineDTO = new InvoiceLineDTO(i, sup.getProduct().getId(), sup.getQuantity(), sup.getProduct().getShortName(),
                    sup.getPrice());
                    invoiceLineDTO.setInvoiceId(id);
                    invoiceLineDTOS.add(invoiceLineDTO);
                    i=+1;
        }
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        return "supply/invoice";
    }


    @RequestMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable(value = "id") Integer id1){
        suppliesService.delete(id1);
        return "supply/supplieslist";
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
    public String editLine(@PathVariable("id") int id, @ModelAttribute InvoiceDTO invoiceDTO,
                           @ModelAttribute("invoicelinedto") InvoiceLineDTO invoiceLineDTO, ModelMap model) {
        invoiceLineDTO=invoiceLineDTOS.get(id-1);
        System.out.println("gggggggggg"+invoiceLineDTO);
        invoiceLineDTOS.remove(id-1);
        System.out.println("gggggggggg"+invoiceLineDTO);
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("invoicelinedto", invoiceLineDTO);
        model.addAttribute("invoicelinedtos", invoiceLineDTOS);
        return "/supply/selectproduct";
    }

    @RequestMapping(value="/addinvoice", method = RequestMethod.POST)
    public String addInvoicePost(ModelMap model) {
        suppliesService.addSupply(invoiceDTO, invoiceLineDTOS);
        return "/index";
    }



}
