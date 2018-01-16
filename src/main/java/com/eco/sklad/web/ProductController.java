package com.eco.sklad.web;

import com.eco.sklad.domain.Producer;
import com.eco.sklad.domain.Product;
import com.eco.sklad.domain.Pcs;
import com.eco.sklad.domain.ProductState;
import com.eco.sklad.service.ProducerService;
import com.eco.sklad.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProducerService producerService;

    @ModelAttribute("producerlist")
    public List<Producer> allProducersList() {
        return producerService.findAll();
    }

    @ModelAttribute("pcslist")
    public List<Pcs> allPcs() {
        return  Arrays.asList(Pcs.values());
    }

    @ModelAttribute("productstatelist")
    public List<ProductState> allProductState() {
        return  Arrays.asList(ProductState.values());
    }

    @GetMapping
        public String showAllProducts(Product product, Model model) {
            model.addAttribute("productlist", productService.findAll());
            return "product/productlist";
        }

        @RequestMapping("/edit/{idProduct}")
        public String showProductForm(@PathVariable("idProduct") Integer id, ModelMap model) {
            Product product = productService.findOne(id);
            model.addAttribute("product", product);
//            model.addAttribute("producerlist", producerService.findAll());
//            model.addAttribute("pcslist", Arrays.asList(Pcs.values()));
            return "product/productform";
        }


        @GetMapping("/new")
        public String addProductForm( ModelMap model) {
            List<Pcs> pcsList = Arrays.asList(Pcs.values());
            model.addAttribute("product", new Product());
            return "product/productform";
        }

        @RequestMapping(value="/add", method = RequestMethod.POST)
        public String addProductPost(
                @RequestParam(value = "ppcs", required = false) String ppcs,
                @RequestParam(value = "prodstate", required = false) String prodState,
                @Valid @ModelAttribute Product product, BindingResult bindingResult) {
            Pcs pcs = Pcs.fromString(ppcs);
            ProductState productState = ProductState.fromString(prodState);
            product.setProductState(productState);
            product.setPcs(pcs);
            System.out.println(product);
        if (bindingResult.hasErrors()) {
                return "product/productform";
            }
            productService.addProduct(product);
            return "redirect:/product";
        }

        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String delete(@PathVariable int id, ModelMap model) {
            productService.delete(id);
            return "redirect:/product";
        }

    }
