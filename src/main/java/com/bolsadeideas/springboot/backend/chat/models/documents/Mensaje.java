package com.bolsadeideas.springboot.backend.chat.models.documents;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	private Long fecha;
	private String username;
	private String tipo;

}