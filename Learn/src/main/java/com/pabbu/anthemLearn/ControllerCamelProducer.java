package com.pabbu.anthemLearn;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCamelProducer {
	@Autowired
	ProducerTemplate producerTemplate;
	
	@Autowired
	Details details;

	@RequestMapping(value = "/second")
	@ResponseBody
	public Details startCamel() {
		producerTemplate.sendBody("direct:pabb", "Sending Second Message");
		details.setAge(10);
		details.setAddress("address");
		details.setName("Pabbu");
		return details;
	}
	
	
	
	@RequestMapping(value = "/second_path")
	@ResponseBody
	public Details second(@PathVariable("age") int age) {
		producerTemplate.sendBody("direct:pabb", "Sending Second Message");
		details.setAge(age);
		return details;
	}
	
	
	@RequestMapping(value = "/second_body")
	@ResponseBody
	public Details second_body(@RequestBody Details det) {
		producerTemplate.sendBody("direct:pabb", "Sending Second Message");
		details.setAge(det.getAge());
		details.setAddress(det.getAddress());
		return details;
	}
	

}