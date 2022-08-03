package com.test.demoweb.service;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Loan;

import java.util.List;

public interface ILoanService {

    public List<Loan> getAllLoanApps() throws Exception;

    public BasicResponse addLoanApp(Loan loan) throws Exception;

    public BasicResponse updateLoanApp(Integer id, Loan loan) throws Exception;

    public BasicResponse deleteLoanApp(Integer id) throws Exception;

}
