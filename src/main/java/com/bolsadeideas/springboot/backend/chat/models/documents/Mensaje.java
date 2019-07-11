package com.bolsadeideas.springboot.backend.chat.models.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "mensajes")
public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String texto;
	private Long fecha;
	private String username;
	private String tipo;
	private String color;
}
