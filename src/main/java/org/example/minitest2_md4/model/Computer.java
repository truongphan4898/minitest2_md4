package org.example.minitest2_md4.model;

import javax.persistence.*;

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String computerCode;
    private String computerName;
    private String producer;
    @ManyToOne
    @JoinColumn(name = "typeComuterId")
    private TypeComputer typeComputer;

    public Computer() {
    }

    public Computer(Long id, String computerCode, String computerName, String producer, TypeComputer typeComputer) {
        this.id = id;
        this.computerCode = computerCode;
        this.computerName = computerName;
        this.producer = producer;
        this.typeComputer = typeComputer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerCode() {
        return computerCode;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public TypeComputer getTypeComputer() {
        return typeComputer;
    }

    public void setTypeComputer(TypeComputer typeComputer) {
        this.typeComputer = typeComputer;
    }
}
