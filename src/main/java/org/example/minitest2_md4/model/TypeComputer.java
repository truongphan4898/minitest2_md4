package org.example.minitest2_md4.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class TypeComputer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeComputerName;
    @OneToMany(mappedBy = "typeComputer")
    private Set<Computer> computerSet;

    public TypeComputer() {
    }

    public TypeComputer(Long id, String typeComputerName, Set<Computer> computerSet) {
        this.id = id;
        this.typeComputerName = typeComputerName;
        this.computerSet = computerSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeComputerName() {
        return typeComputerName;
    }

    public void setTypeComputerName(String typeComputerName) {
        this.typeComputerName = typeComputerName;
    }

    public Set<Computer> getComputerSet() {
        return computerSet;
    }

    public void setComputerSet(Set<Computer> computerSet) {
        this.computerSet = computerSet;
    }
}
