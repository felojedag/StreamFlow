package com.duoc.notificaciones.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    public String enviarNotificacionTest() {
        return "Servicio de Notificaciones activo y listo para enviar correos/alertas.";
    }
}