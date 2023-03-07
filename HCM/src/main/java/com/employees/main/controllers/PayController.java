package com.employees.main.controllers;

import com.employees.main.business.dto.PayDTO;
import com.employees.main.business.ibusiness.IBusinessPay;
import com.employees.main.entities.Pay;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pay")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PayController  {

    private final IBusinessPay iBusinessPay;

    public PayController(IBusinessPay iBusinessPay) {
        this.iBusinessPay = iBusinessPay;
    }

    @PostMapping("/createpaysheet/{idContract}")
    public Pay addP(@RequestBody PayDTO payDTO,@PathVariable("idContract")String idContract) {
        return  iBusinessPay.addPay(payDTO,idContract);
    }


    @GetMapping("/all")
    public List<Pay> allP()
    {
        return  iBusinessPay.findData();
    }


    @GetMapping("/paysheet/{id}")
    public Optional<Pay> getP(@PathVariable("id")String id)
    {
        return  iBusinessPay.getItem(id);
    }






}
