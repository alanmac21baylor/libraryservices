package com.lmsloans.controller;

import com.lmsloans.entity.BookDTO;
import com.lmsloans.entity.Loan;
import com.lmsloans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @PostMapping("/create")
    public Loan createLoan(@RequestBody BookDTO loanRequestDTO) {
        Loan loan = new Loan();
        loan.setBookId(loanRequestDTO.getBookId());
        return loanService.saveOrUpdateLoan(loan);
    }

    @GetMapping("/book/{bookId}")
    public BookDTO getBookDetails(@PathVariable Long bookId) {
        return loanService.getBookDetails(bookId);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

//    @PostMapping
//    public Loan saveOrUpdateLoan(@RequestBody Loan loan) {
//        return loanService.saveOrUpdateLoan(loan);
//    }

    @PostMapping("/saveOrUpdate")
    public Loan saveOrUpdateLoan(@RequestBody Loan loan) {
        return loanService.saveOrUpdateLoan(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}
