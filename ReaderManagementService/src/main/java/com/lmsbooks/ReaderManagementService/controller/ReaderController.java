package com.lmsbooks.ReaderManagementService.controller;

import com.lmsbooks.ReaderManagementService.entity.Reader;
import com.lmsbooks.ReaderManagementService.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readerService.getReaderById(id);
    }

    @PostMapping
    public Reader saveOrUpdateReader(@RequestBody Reader reader) {
        return readerService.saveOrUpdateReader(reader);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}
