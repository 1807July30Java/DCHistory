package com.revature.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataService {
    @RequestMapping(value="/data", method=RequestMethod.GET)
  	@ResponseBody
  	public ResponseEntity<String> sayHello(){
  		return new ResponseEntity<>("Hello World!",HttpStatus.OK);
  	}
}
