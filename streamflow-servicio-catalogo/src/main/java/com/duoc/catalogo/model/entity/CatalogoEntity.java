package com.duoc.catalogo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
public class CatalogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreItem;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreItem() { return nombreItem; }
    public void setNombreItem(String nombreItem) { this.nombreItem = nombreItem; }
}