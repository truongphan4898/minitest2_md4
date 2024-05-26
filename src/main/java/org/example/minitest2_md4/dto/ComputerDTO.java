package org.example.minitest2_md4.dto;

import org.example.minitest2_md4.model.TypeComputer;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ComputerDTO {
    private Long id;
    @Pattern(regexp = "^cg.{2}$", message = "mau ban nhap khong hop le")
    private String computerCode;
    @NotBlank(message = "truong nay khong duoc de trong")
    private String computerName;
    @NotBlank(message = "truong nay khong duoc de trong")
    private String producer;
    private TypeComputer typeComputer;

    public ComputerDTO() {
    }

    public ComputerDTO(Long id, String computerCode, String computerName, String producer, TypeComputer typeComputer) {
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
