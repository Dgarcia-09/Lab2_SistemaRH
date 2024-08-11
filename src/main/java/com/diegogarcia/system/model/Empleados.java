package com.diegogarcia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Empleados {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer id;
    public String nombreCompleto;
    public Integer dpi;
    public String puesto;
    public double salario;

    
}
