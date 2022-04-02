package com.kodluyoruz.controller;

import com.kodluyoruz.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_form", "Ben model yapısından geldim");
        model.addAttribute("key_form2", "Ben 2. kez modelden geldim.");
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben model yapısından geldim");
        return "thymeleaf4";
    }

    //Model Object Göndermek
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleafModelObject(Model model){
        model.addAttribute("key_modelObject1", "text");

        ProductDto productDto = ProductDto.builder()
                    .productId(0L)
                    .productName("Urun Adi")
                    .productPrice(2500)
                .build();

        model.addAttribute("key_modelObject2", productDto);
        return "thymeleaf5";
    }

    //Model ObjectList Göndermek
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleafModelObjectList(Model model){
        model.addAttribute("key_modelObjectList1", "text");
        List<ProductDto> myList = new ArrayList<>();
        myList.add(ProductDto.builder().productId(0L).productName("Urun Adi").productPrice(2500).build());
        myList.add(ProductDto.builder().productId(1L).productName("Urun Adi2").productPrice(3500).build());
        myList.add(ProductDto.builder().productId(2L).productName("Urun Adi3").productPrice(4500).build());
        model.addAttribute("product_list", myList);
        return "thymeleaf6";
    }

    // http://localhost:8080/thymeleaf7/5
    @GetMapping( {"/thymeleaf7","/thymeleaf7/{id}"} )
    public String getThymeleafModelObject2(Model model, @PathVariable(name = "id", required = false) Long id){
        if(id != null){
            model.addAttribute("key_modelpathvariable", "id: " + id);
        }else{
            model.addAttribute("key_modelpathvariable", "Id could not find!");
        }
        return "thymeleaf7";
    }
}
