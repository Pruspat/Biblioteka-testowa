package com.example.demo.support;

import com.example.demo.book.BookContentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/support")
public class SupportController {

    @Autowired
    SupportRepository supportRepository;

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public SupportEntity findOneById(@PathVariable Integer id) {
        return supportRepository.findById(id);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public HttpStatus addMsg(@RequestBody Support support) {

        SupportEntity supportEntity = new SupportEntity(support.getCustomerId(),support.getContent(),false, "");
        supportRepository.save(supportEntity);
        return HttpStatus.CREATED;
    }


    @RequestMapping(value = "/all/{customerId}" , method = RequestMethod.GET)
    public List<SupportEntity> findAllByCustomerIid(@PathVariable Integer customerId) {
        return supportRepository.findAllByCustomerId(customerId);
    }

    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public List<SupportEntity> findAll() {
        return supportRepository.findAll();
    }

    @RequestMapping(value = "/all-by-status" , method = RequestMethod.GET)
    public List<SupportEntity> findBysStatus(@RequestBody Support support) {
        return supportRepository.findAllByStatus(support.isStatus());
    }

    @RequestMapping(value = "/replay" , method = RequestMethod.GET)
    public HttpStatus findByStatus(@RequestBody Support support) {

        System.out.println(support.getId()+ "    "+support.getReplay());
        supportRepository.setReplay(support.getId(),support.getReplay());

        return HttpStatus.CREATED;
    }
}
