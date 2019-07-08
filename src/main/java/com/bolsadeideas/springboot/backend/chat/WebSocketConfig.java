package com.bolsadeideas.springboot.backend.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//habilita el servidor/brocker de web socket en spring
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
				/*
				 * con esto indicas cual es la ruta que servirá para conectarse desde el
				 * frontend (angular)
				 */
				.addEndpoint("/chat-websocket")
				/* Configura el cors */
				.setAllowedOrigins("http://localhost:4200")
				/* Permite usar el protocolo HTTP para conectarse al brocker */
				.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		/* Es un prefijo sirve para los nombre de los eventos */
		registry.enableSimpleBroker("/chat/");
		/*
		 * Es un prefijo. Con este indicas el destino al momento de publicar un mensaje
		 */
		registry.setApplicationDestinationPrefixes("/app");

	}

}
