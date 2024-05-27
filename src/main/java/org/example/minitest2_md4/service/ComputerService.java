package org.example.minitest2_md4.service;

import org.example.minitest2_md4.exception.DuplicateCodeException;
import org.example.minitest2_md4.exception.ResourceNotFoundException;
import org.example.minitest2_md4.model.Computer;
import org.example.minitest2_md4.repository.IComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepo computerRepo;

    @Override
    public List<Computer> findAll() {
        return computerRepo.findAll();
    }

    @Override
    public Computer findById(Long id) throws ResourceNotFoundException {
        return computerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Computer not found"));
    }

    @Override
    public void save(Computer computer) throws DuplicateCodeException {
        if (computerRepo.existsComputerByComputerCode(computer.getComputerCode())) {
            throw new DuplicateCodeException("ma may tinh khong duoc trung lap: "+computer.getComputerCode());
        } else {
            computerRepo.save(computer);
        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if(! computerRepo.existsById(id)){
           throw new ResourceNotFoundException("ID khong ton tai");
        }
        computerRepo.deleteById(id);

    }

    @Override
    public Page<Computer> findComputerByComputerNameContaining(String name, Pageable pageable) {
        return computerRepo.findComputerByComputerNameContaining(name,pageable);
    }
    public Page<Computer> findComputer(String name, String code, String producer, Pageable pageable){
        return computerRepo.finComputer(name, code, producer,pageable);
    }
}
