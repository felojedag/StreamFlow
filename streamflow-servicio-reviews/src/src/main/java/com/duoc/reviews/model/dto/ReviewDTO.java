package com.duoc.reviews.model.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class ReviewDTO {

    private Long id;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El ID del contenido no puede estar vacío")
    private Long contenidoId;

    @NotBlank(message = "El tipo de contenido es obligatorio")
    private String tipoContenido;

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Integer calificacion;

    @Size(max = 1000, message = "El comentario no puede superar los 1000 caracteres")
    private String comentario;

    private LocalDateTime fechaReview;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getContenidoId() { return contenidoId; }
    public void setContenidoId(Long contenidoId) { this.contenidoId = contenidoId; }
    public String getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(String tipoContenido) { this.tipoContenido = tipoContenido; }
    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public LocalDateTime getFechaReview() { return fechaReview; }
    public void setFechaReview(LocalDateTime fechaReview) { this.fechaReview = fechaReview; }
}
