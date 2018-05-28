package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    CustomerRepository customerRepository;

   public static void main(String[] args) throws Exception{
       SpringApplication.run(Application.class,args);
   }

    @Transactional(readOnly=true)
    @Override
    public void run(String... args) throws Exception {

       System.out.println("\n1.findAll()...");
       for(Customer customer : customerRepository.findAll()){
           System.out.println(customer);
       }

       System.out.println("\n3.findByDate(Date date)...");
       for(Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))){
           System.out.println(customer);
       }
       exit(0);
    }



}
