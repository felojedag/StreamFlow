package com.duoc.historial.model.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class HistorialDTO {

    private Long id;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El ID del contenido no puede estar vacío")
    private Long contenidoId;

    @NotBlank(message = "El tipo de contenido es obligatorio")
    private String tipoContenido;

    @NotNull(message = "El progreso es obligatorio")
    @Min(value = 0, message = "El progreso mínimo es 0")
    @Max(value = 100, message = "El progreso máximo es 100")
    private Integer progresoPorcentaje;

    private LocalDateTime fechaReproduccion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getContenidoId() { return contenidoId; }
    public void setContenidoId(Long contenidoId) { this.contenidoId = contenidoId; }
    public String getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(String tipoContenido) { this.tipoContenido = tipoContenido; }
    public Integer getProgresoPorcentaje() { return progresoPorcentaje; }
    public void setProgresoPorcentaje(Integer progresoPorcentaje) { this.progresoPorcentaje = progresoPorcentaje; }
    public LocalDateTime getFechaReproduccion() { return fechaReproduccion; }
    public void setFechaReproduccion(LocalDateTime fechaReproduccion) { this.fechaReproduccion = fechaReproduccion; }
}
