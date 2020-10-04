package com.apicrudds.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apicrudds.backend.dto.ClientDTO;
import com.apicrudds.backend.entities.Client;
import com.apicrudds.backend.resources.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Transactional(readOnly=true)
	public List<ClientDTO> findAll(){
		List<Client> list =  clientRepository.findAll();
		return  list.stream().map(x-> new ClientDTO(x)).collect(Collectors.toList());
	
	}

}
