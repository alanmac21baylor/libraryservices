package com.lmsloans.service;

import com.lmsloans.entity.BookDTO;
import com.lmsloans.entity.Loan;
import com.lmsloans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String BOOK_SERVICE_URL = "http://BookManagementService:8081/books/";

    public BookDTO getBookDetails(Long bookId) {
        return restTemplate.getForObject(BOOK_SERVICE_URL + bookId, BookDTO.class);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan saveOrUpdateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }


}
