package com.adminService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminService.Entity.AdminEntity;
import com.adminService.Service.AdminService;
import com.adminService.Entity.AirlinesEntity;


@RestController
@RequestMapping("/adminservice")
@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200/adminlogin","http://localhost:4200"})
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
    private KafkaTemplate<String, AirlinesEntity> kafkaTemplate;
    
    private static final String TOPIC_NAME = "registerflights";
    
    @PostMapping("/airlines/register")
    public String saveInAirlines(@RequestBody AirlinesEntity a){
        // save data on kafka
        kafkaTemplate.send(TOPIC_NAME, a);
        return "Proccessed...";
    }

	 @GetMapping("/admin")
	    public String greet(){
	        return "Admin login successful....";
	    }
	
	@GetMapping("/admindetail")
	public List<AdminEntity> getUser() {
		return adminService.findAdmin();
	}
}
