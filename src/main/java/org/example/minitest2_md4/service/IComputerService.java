package org.example.minitest2_md4.service;

import org.example.minitest2_md4.exception.DuplicateCodeException;
import org.example.minitest2_md4.exception.ResourceNotFoundException;
import org.example.minitest2_md4.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IComputerService {
    List<Computer> findAll();
    Computer findById(Long id)throws ResourceNotFoundException;
    void save(Computer computer) throws DuplicateCodeException;
    void delete(Long id) throws ResourceNotFoundException;
    Page<Computer> findComputerByComputerNameContaining(String name, Pageable pageable);
}
