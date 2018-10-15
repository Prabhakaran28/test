package com.pabbu.anthemLearn;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCamelProducer2 {
	@Autowired
	ProducerTemplate producerTemplate;

	@RequestMapping(value = "/first")
	@ResponseBody
	public void startCamel() {
		producerTemplate.sendBody("direct:pabbu", "Sending First Message");
	}
}