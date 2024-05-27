package org.example.minitest2_md4.repository;

import org.example.minitest2_md4.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IComputerRepo extends JpaRepository<Computer,Long> {
    boolean existsComputerByComputerCode(String computerCode);
    Page<Computer> findComputerByComputerNameContaining(String name, Pageable pageable);
    @Query("SELECT c FROM Computer c WHERE " +
            "(?1 IS NULL OR c.computerName LIKE %?1%) AND " +
            "(?2 IS NULL OR c.computerCode LIKE %?2%) AND " +
            "(?3 IS NULL OR c.producer LIKE %?3%)")
    Page<Computer>finComputer(String name, String code,String producer,Pageable pageable);
}
