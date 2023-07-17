package com.example.springboot;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techbridge.gautam.CodeGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/code")
    public String code(@RequestParam(value = "fname", defaultValue = "myfunc") String fname,
    @RequestParam(value = "rettype", defaultValue = "int") String rettype,
    @RequestParam(value = "params", defaultValue = "int,p1") String params ) {
        
        CodeGenerator cgen = new CodeGenerator();
        String[] argsa = params.split(",");
        //String  argsa[] = {"int" ,"p1" ,"double" ,"p2" ,"boolean" ,"p3"};
        cgen.addFunction(fname ,rettype , argsa);
        cgen.GenCode();
        return cgen.getCode();
    }

}