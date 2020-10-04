package com.apicrudds.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apicrudds.backend.dto.ClientDTO;
import com.apicrudds.backend.entities.Client;
import com.apicrudds.backend.resources.ClientRepository;
import com.apicrudds.backend.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Transactional(readOnly=true)
	public List<ClientDTO> findAll(){
		List<Client> list =  clientRepository.findAll();
		return  list.stream().map(x-> new ClientDTO(x)).collect(Collectors.toList());
	
	}
	
	@Transactional(readOnly=true)
	public ClientDTO findById(long id){
		Optional<Client> obj = clientRepository.findById(id);
		Client entity  = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return  new ClientDTO(entity);
	}

}
