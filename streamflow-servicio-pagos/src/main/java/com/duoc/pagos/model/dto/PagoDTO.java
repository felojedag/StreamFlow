package com.duoc.pagos.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PagoDTO {
    private Long id;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El monto es obligatorio")
    @Min(value = 1, message = "El monto debe ser mayor a 0")
    private Double monto;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
}