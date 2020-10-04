package com.apicrudds.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apicrudds.backend.entities.Client;
import com.apicrudds.backend.resources.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Transactional(readOnly=true)
	public List<Client> findAll(){
		return clientRepository.findAll();
	}

}
