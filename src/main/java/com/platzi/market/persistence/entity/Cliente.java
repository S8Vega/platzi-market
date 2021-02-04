package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}