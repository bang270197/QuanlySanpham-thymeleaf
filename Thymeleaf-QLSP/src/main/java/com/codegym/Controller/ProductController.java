package com.codegym.Controller;

import com.codegym.Model.Product;
import com.codegym.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/show-list")
    public String showList(Model model){
        ArrayList<Product> products=productService.showAll();
        model.addAttribute("products",products);
        return "/product/showlist";
    }

    @GetMapping("/showForm-addProduct")
    public ModelAndView showAddProduct(){
        ModelAndView modelAndView=new ModelAndView("/product/addProduct");
        modelAndView.addObject("products",new Product());
        return modelAndView;
    }

    @PostMapping("/add-product")
    public ModelAndView addProduct(@ModelAttribute Product product ){
         if (product!=null){
             productService.addProduct(product);
         }
         ModelAndView modelAndView=new ModelAndView("/product/addProduct");
         modelAndView.addObject("products",new Product());
        modelAndView.addObject("success","themthanhcong");
         return modelAndView;
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Product product=productService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/product/editProduct");
        modelAndView.addObject("products",product);
        return modelAndView;
    }

    @PostMapping("/editProduct")
    public ModelAndView editProduct(@ModelAttribute Product product){
        productService.editProduct(product);
       ModelAndView modelAndView=new ModelAndView("/product/editProduct");
       modelAndView.addObject("products",new Product());
       modelAndView.addObject("message","Sua thanh cong");
       return modelAndView;
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        ModelAndView modelAndView=new ModelAndView("/product/showlist");
        modelAndView.addObject("products",productService.showAll());
        return modelAndView;
    }

    @GetMapping("/detail-product/{id}")
    public ModelAndView detailProduct(@PathVariable Long id){
        Product product=null;
        if (id != null){
             product=productService.findById(id);
        }
        ModelAndView modelAndView=new ModelAndView("/product/detail");
        modelAndView.addObject("products1",product);
        return modelAndView;
    }
    @PostMapping("/search-product")
    public ModelAndView modelAndView(@RequestParam String name){
        ArrayList<Product> productArrayList=productService.findByName(name);
        ModelAndView modelAndView=new ModelAndView("/product/searchProduct");
        modelAndView.addObject("products",productArrayList);
        return modelAndView;
    }
}
