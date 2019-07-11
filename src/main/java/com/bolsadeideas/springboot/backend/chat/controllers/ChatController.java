package com.bolsadeideas.springboot.backend.chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bolsadeideas.springboot.backend.chat.models.documents.Mensaje;

@Controller
public class ChatController {

	private String[] colores = { "red", "green", "blue", "magenta", "purple", "orange" };

	/**
	 * Con esta anotación se indica la url donde van a llegar los mensajes, publica
	 * un nuevo en mensaje en el broker.
	 * 
	 * Aqui se recibe el mensaje del cliente que lo haya pubicado y al hacer el
	 * return se realiza la notificación a todos los clientes subscritos
	 * 
	 * @param mensaje
	 * @return
	 */
	// aqui no se indica el prefijo de la configuración
	@MessageMapping(value = "/mensaje")
	// aqui si se indica el prefijo definido en la configuracion y se agrega un
	// nombre a donde se va a enviar la respuesta, la notificación.
	@SendTo(value = "/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo Usuario");
		}
		return mensaje;
	}

}
