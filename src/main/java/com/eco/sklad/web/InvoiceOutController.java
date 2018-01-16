package com.eco.sklad.web;

import com.eco.sklad.domain.*;
import com.eco.sklad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value="/sell")
public class InvoiceOutController {


    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    ContragentService contragentService;


    @ModelAttribute("productlist")
    public List<Product> allProductsList() {
        return productService.findAll();
    }

    @ModelAttribute("contragentlist")
    public List<Contragent> allContragents() {
        return contragentService.findAll();
    }

    @ModelAttribute("saletypelist")
    public List<SaleType> allSaleTypes() {
        return Arrays.asList(SaleType.values());
    }


    public Order neworder;

    @GetMapping("/orders")
    public String showAllOrders(ModelMap model) {
        model.addAttribute("orderslist", orderService.findAll());
        return "sell/orderslist";
    }

    @GetMapping("/addneworder")
    public String addNewOrder(ModelMap model)  {
        neworder = new Order();
        neworder.setManagerName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute( "neworder", neworder);
        return "sell/order";
    };

    @RequestMapping("/neworder")
        public String selectProduct(@RequestParam(value = "product.id", required = false) Integer productid,
                                    @RequestParam(value = "quantity", required = false) Integer quantity,
                                    @RequestParam(value = "salePrice", required = false) BigDecimal salePrice,
                                    @RequestParam(value = "saletype", required = false) String saleType,
//                                    @ModelAttribute("neworder") Order neworder, BindingResult result,
                                    ModelMap model){
            if (productid!=null){
                SaleType sale = SaleType.fromString(saleType);
                neworder.addOrderLines(new OrderLines(productService.findOne(productid), quantity, salePrice, sale));
            }
            System.out.println("ddddddddddddd"+neworder);
            model.addAttribute("neworder", neworder);
            return "sell/order";
        }


        @GetMapping("/edittodayorder/{id}")
        public String editOrder(@PathVariable(value = "id") Integer id, ModelMap model){
            Order neworder = orderService.findOne(id);

//            int i=1;
//            for (SupplyLines sup:supplyList){
//                invoiceLineDTO = new InvoiceLineDTO(i, sup.getProduct().getId(), sup.getQuantity(), sup.getProduct().getShortName(),
//                        sup.getPrice());
//                invoiceLineDTO.setInvoiceId(id);
//                invoiceLineDTOS.add(invoiceLineDTO);
//                i=+1;
//            }
            model.addAttribute("neworder", neworder);

            return "sell/neworder";
        }


        @RequestMapping("/delete/{id}")
        public String deleteOrder(@PathVariable(value = "id") Integer id1){
            orderService.delete(id1);
            return "sell/orderslist";
        }



        @RequestMapping(value="/addinvoice", params={"addline"})
        public String addOrderLine(
                @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
                @RequestParam("customer") int customerid,
//                @Valid @ModelAttribute("neworder") Order neworder,
//                                   BindingResult bindingResult,
                ModelMap model) {
            neworder.setOrderDate(oDate);
            neworder.setCustomer(contragentService.findOne(customerid));
//            model.addAttribute("neworder", neworder);
            model.addAttribute("neworderline", new OrderLines());
            return "sell/addorderline";
        }

        @RequestMapping(value = "/orderline/delete/{id}")
        public String deleteInvoiceLine(@PathVariable int id,
                                        ModelMap model) {
//            model.addAttribute("neworder", neworder);
            neworder.removeOrderLine(id-1);
            return "redirect:/sell/neworder";
        }

//        @RequestMapping(value = "/clear")
//        public String clearInvoice (@ModelAttribute InvoiceDTO invoiceDTO, ModelMap model){
//            invoiceLineDTOS.clear();
//            return "redirect:/supply/product";
//        }

        @RequestMapping("/invoiceline/edit/{id}")
        public String editOrderLine(@PathVariable("id") int id, @ModelAttribute Order neworder,
                               ModelMap model) {
//            invoiceLineDTO=invoiceLineDTOS.get(id-1);
//            System.out.println("gggggggggg"+invoiceLineDTO);
            model.addAttribute("neworder", neworder);
            return "/sell/selectproduct";
        }

        @RequestMapping(value="/addinvoice")
        public String addOrderPost(
                @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
                @ModelAttribute("neworder") Order neworder,
                                   BindingResult bindingResult,

                                   ModelMap model) {
            neworder.setOrderDate(oDate);
            System.out.println("ddddddd"+neworder);
//            orderService.addOrder(neworder);
            return  "rdirect:/sell";
        }



    }


