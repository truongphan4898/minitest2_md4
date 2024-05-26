package org.example.minitest2_md4.repository;

import org.example.minitest2_md4.model.TypeComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeComputerRepo extends JpaRepository<TypeComputer, Long> {
}
