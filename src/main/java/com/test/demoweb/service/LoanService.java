package com.test.demoweb.service;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Loan;
import com.test.demoweb.repository.LoanModel;
import com.test.demoweb.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
public class LoanService implements ILoanService{

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoanApps() throws Exception {
        List<LoanModel> loanModels = loanRepository.findAll();
        List<Loan> loans = new ArrayList<>();
        for (LoanModel loanModel: loanModels){
            Loan newLoan = convertModelToDTO(loanModel);
            loans.add(newLoan);
        }

        return loans;
    }

    @Override
    public BasicResponse addLoanApp(Loan loan) throws Exception {
        LoanModel newLoanModel = convertDTOtoModel(loan);
        LoanModel loanSave;

        try {
            loanSave = loanRepository.save(newLoanModel);
            BasicResponse ms = new BasicResponse();
            ms.setMessage("Loan agregado con id: "+loanSave.getId());
            return ms;
        }catch (Exception e){
            throw new Exception("Loan not save");
        }
    }

    @Override
    public BasicResponse updateLoanApp(Integer id, Loan loan) throws Exception {
        Optional<LoanModel> loanModel = loanRepository.findById(id);

        if (!loanModel.isPresent()){
            throw new Exception("Book not found");
        }

        LoanModel newLoan = loanModel.get();
        newLoan.setUser(loan.getUser());
        newLoan.setId_user(loan.getId_user());
        newLoan.setId_book(loan.getId_book());
        newLoan.setStatus(loan.getStatus());
        newLoan.setBook(loan.getBook());
        newLoan.setDate(loan.getDate());
        newLoan.setUpdate_date(loan.getUpdate_date());

        LoanModel loanSave;

        try {
            loanSave = loanRepository.save(newLoan);
            BasicResponse ms = new BasicResponse();
            ms.setMessage("Loan con la id: "+loanSave.getId()+" fue actualizado con exito");
            return ms;
        }catch (Exception e){
            throw new Exception("Loan no actualizado");
        }
    }

    @Override
    public BasicResponse deleteLoanApp(Integer id) throws Exception {
        Optional<LoanModel> loanModel = loanRepository.findById(id);

        if (!loanModel.isPresent()){
            throw new Exception("Loan not found");
        }

        try {
            loanRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al borrar");
        }

        BasicResponse ms = new BasicResponse();
        ms.setMessage("Loan eliminado con exito");
        return ms;
    }

    private Loan convertModelToDTO(LoanModel loanModel){

        Loan loan = new Loan();
        loan.setId(loanModel.getId());
        loan.setUser(loanModel.getUser());
        loan.setId_user(loanModel.getId_user());
        loan.setId_book(loanModel.getId_book());
        loan.setStatus(loanModel.getStatus());
        loan.setBook(loanModel.getBook());
        loan.setDate(loanModel.getDate());
        loan.setUpdate_date(loanModel.getUpdate_date());

        return loan;

    }

    private LoanModel convertDTOtoModel(Loan loan){

        LoanModel loanModel = new LoanModel();

        loanModel.setUser(loan.getUser());
        loanModel.setId_user(loan.getId_user());
        loanModel.setId_book(loan.getId_book());
        loanModel.setStatus(loan.getStatus());
        loanModel.setBook(loan.getBook());
        loanModel.setDate(loan.getDate());
        loanModel.setUpdate_date(loan.getUpdate_date());

        return loanModel;

    }
}
