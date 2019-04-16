package com.example.demo.support;

import com.example.demo.book.BookContentHolder;
import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerEntity;
import com.example.demo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/support")
public class SupportController {

    @Autowired
    SupportRepository supportRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SupportEntity findOneById(@PathVariable Integer id) {
        return supportRepository.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus addMsg(@RequestBody Support support) {

        System.out.println("content" + support.getContent());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        SupportEntity supportEntity = new SupportEntity(customerRepository.findByEmail(currentUser).getId(), support.getContent(), false, "");
        supportRepository.save(supportEntity);
        return HttpStatus.CREATED;
    }


    @RequestMapping(value = "/allByCustomer", method = RequestMethod.GET)
    public List<SupportEntity> findAllByCustomerIid() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        return supportRepository.findAllByCustomerId(customerRepository.findByEmail(currentUser).getId());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Support> findAll() {
        List<SupportEntity> supportEntityList = supportRepository.findAll();
        List<Support> list = new ArrayList<>();

        for (SupportEntity item : supportEntityList) {
            Support support = new Support(item.getId(),item.getCustomerId(), customerRepository.findById(item.getCustomerId()).getName(), customerRepository.findById(item.getCustomerId()).getSurname(), item.getContent(), item.getReplay(), item.isStatus(),item.getWorkerId());
            list.add(support);
        }

        return list;
    }

    @RequestMapping(value = "/all-by-status", method = RequestMethod.GET)
    public List<SupportEntity> findBysStatus(@RequestBody Support support) {
        return supportRepository.findAllByStatus(support.isStatus());
    }

    @RequestMapping(value = "/replay", method = RequestMethod.POST)
    public HttpStatus findByStatus(@RequestBody Support support) {

        supportRepository.setReplay(support.getId(), support.getReplay());

        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/setWorker", method = RequestMethod.POST)
    public HttpStatus setWorker(@RequestBody Support support) {

        supportRepository.setWorker(support.getWorkerId(),support.getId());

        return HttpStatus.CREATED;
    }


    @RequestMapping(value = "/getTask", method = RequestMethod.POST)
    public HttpStatus setTaskForWorker(@RequestBody String content) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        supportRepository.getTask(content, customerRepository.findByEmail(currentUser).getId());

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/getWorkerTasks/{id}", method = RequestMethod.GET)
    public int getTask(@PathVariable Integer id) {

        CustomerEntity customerEntity = customerRepository.findById(id);
        int counter = 0;

            if(customerEntity.getRole().equals("worker")){
                List<SupportEntity> list = supportRepository.findAllByWorkerId(customerEntity.getId());
                counter = list.size();
            }else{
                counter = 0;
            }
        return counter;
    }

}
