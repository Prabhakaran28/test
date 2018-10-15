package com.pabbu.anthemLearn;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class CamelRoutes extends RouteBuilder {
 @Override
 public void configure() throws Exception {
  from("direct:pabbu")
   .log("Message from pabbu is : ${body}");
  
  from("direct:pabb")
  .log("Message from pabb is : ${body}");
 
 
  
 }
}