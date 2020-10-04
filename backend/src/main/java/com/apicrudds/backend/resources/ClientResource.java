package com.apicrudds.backend.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicrudds.backend.entities.Client;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Maria Silva", "12345678901", 6500.0, Instant.now(), 2 ));
		list.add(new Client(1L, "João Gomes", "12345678901", 3500.0, Instant.now(), 2 ));
		list.add(new Client(1L, "Tereza Cristina", "12345678901", 6500.0, Instant.now(), 2 ));
		
		return ResponseEntity.ok().body(list);
	}

}
