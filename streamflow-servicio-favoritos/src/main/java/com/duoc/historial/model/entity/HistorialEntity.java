package com.duoc.historial.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial")
public class HistorialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long contenidoId;

    @Column(nullable = false)
    private String tipoContenido; // PELICULA, SERIE, EPISODIO

    @Column(nullable = false)
    private LocalDateTime fechaReproduccion;

    @Column(nullable = false)
    private Integer progresoPorcentaje; // 0-100

    @PrePersist
    public void prePersist() {
        this.fechaReproduccion = LocalDateTime.now();
        if (this.progresoPorcentaje == null) {
            this.progresoPorcentaje = 0;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getContenidoId() { return contenidoId; }
    public void setContenidoId(Long contenidoId) { this.contenidoId = contenidoId; }
    public String getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(String tipoContenido) { this.tipoContenido = tipoContenido; }
    public LocalDateTime getFechaReproduccion() { return fechaReproduccion; }
    public void setFechaReproduccion(LocalDateTime fechaReproduccion) { this.fechaReproduccion = fechaReproduccion; }
    public Integer getProgresoPorcentaje() { return progresoPorcentaje; }
    public void setProgresoPorcentaje(Integer progresoPorcentaje) { this.progresoPorcentaje = progresoPorcentaje; }
}
