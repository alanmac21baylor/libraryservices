package com.lmsbooks.ReaderManagementService.repository;

import com.lmsbooks.ReaderManagementService.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
