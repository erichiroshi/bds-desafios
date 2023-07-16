package com.erichiroshi.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erichiroshi.bds01.dto.ClientDTO;
import com.erichiroshi.bds01.entities.Client;
import com.erichiroshi.bds01.mappers.ClientMapper;
import com.erichiroshi.bds01.repositories.ClientRepository;
import com.erichiroshi.bds01.services.exceptions.DatabaseException;
import com.erichiroshi.bds01.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private ClientMapper mapper;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> mapper.toDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entity not found. Id: " + id));
		return mapper.toDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = mapper.toClient(dto);
		entity = repository.save(entity);
		return mapper.toDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		ClientDTO entityDTO = findById(id);
		mapper.update(dto, entityDTO);
		Client entity = mapper.toClient(entityDTO);
		entity = repository.save(entity);
		return mapper.toDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		try {
			findById(id);
			repository.flush();
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity constraint violation");
		}
	}
}
