package com.pabbu.anthemLearn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	   @RequestMapping(value = "/index")
	   public String index() {
	      return "index";
	   }
	   
	   @RequestMapping(value = "/addProd")
	   public String addProd() {
	      return "addProd";
	   }
	   
	   @RequestMapping(value = "/viewProducts")
	   public String viewProducts() {
	      return "viewProducts";
	   }
}
