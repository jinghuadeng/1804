package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	
	private RestTemplate restTemplate;
	
	//调用提供者需要一个模板对象
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name){
		String url="http://provider-user/hello/"+name;
		//调用提供者的服务
		return restTemplate.getForObject(url, String.class);
	}
}
