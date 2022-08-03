package com.test.demoweb.controller;


import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Loan;
import com.test.demoweb.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Basic;
import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getAllLoanApps(){

        try {
            List<Loan> loans = loanService.getAllLoanApps();
            return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error 404",e);
        }
    }

    @PostMapping("/loans")
    public ResponseEntity<BasicResponse> addLoanApp(@RequestBody Loan newLoan){
        try {
            BasicResponse ms = loanService.addLoanApp(newLoan);
            return new ResponseEntity<BasicResponse>(ms,HttpStatus.CREATED);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
        }
    }

    @PutMapping("/loans/{id}")
    public ResponseEntity<BasicResponse> updateLoan(@PathVariable("id") Integer id, @RequestBody Loan newLoan) {

        try {
            BasicResponse ms = loanService.updateLoanApp(id, newLoan);
            return new ResponseEntity<BasicResponse>(ms,HttpStatus.OK);
        }catch (Exception e){
            if (e.getMessage().equals("Loan not found")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
            }else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
            }
        }
    }

    @DeleteMapping("/loans/{id}")
    public ResponseEntity<BasicResponse> deleteLoanApp(@PathVariable (value = "id") int id){

        try {
            BasicResponse loans = loanService.deleteLoanApp(id);
            return new ResponseEntity<BasicResponse>(loans,HttpStatus.OK);
        }catch (Exception e){
            if (e.getMessage().equals("Book not found")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
            }else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
            }
        }
    }

}