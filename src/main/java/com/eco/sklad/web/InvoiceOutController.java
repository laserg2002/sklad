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

    @RequestMapping("/orderlist")
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
                                    ModelMap model
    ){
            if (productid!=null){
                SaleType sale = SaleType.fromString(saleType);
                neworder.addOrderLines(new OrderLines(productService.findOne(productid), quantity, salePrice, sale));
            }
//            System.out.println("jjjjjjjjjddddddd"+neworder);
            model.addAttribute("neworder", neworder);
            return "sell/order";
        }


        @GetMapping("/edittodayorder/{id}")
        public String editOrder(@PathVariable(value = "id") Integer id, ModelMap model){
            neworder = orderService.findOne(id);
            model.addAttribute("neworder", neworder);
//            System.out.println("iiiiiiiiiddddddd"+neworder);
            return "sell/order";
        }


        @RequestMapping("/delete/{id}")
        public String deleteOrder(@PathVariable(value = "id") Integer id1){
            orderService.delete(id1);
            return "redirect:sell/orderlist";
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
//            System.out.println("vvvvvvvvv"+neworder);
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

        @RequestMapping("/orderline/edit/{id}")
        public String editOrderLine(@PathVariable("id") int id,
//                                    @ModelAttribute Order neworder,
                               ModelMap model) {
            OrderLines neworderline=neworder.getOrderLines().get(id-1);
//            System.out.println("gggggggggg"+invoiceLineDTO);
            model.addAttribute("neworderline", neworderline);
            neworder.removeOrderLine(id-1);
            return "sell/addorderline";
        }

        @RequestMapping(value="/addinvoice")
        public String addOrderPost(
                @RequestParam("orderDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date oDate,
//                @ModelAttribute("neworder") Order neworder,
//                                   BindingResult bindingResult,
                                   ModelMap model) {

//            System.out.println("ddddddd"+neworder);
            neworder.setOrderDate(oDate);
            orderService.addOrder(neworder);
            return  "redirect:/sell/orderlist";
        }



    }


