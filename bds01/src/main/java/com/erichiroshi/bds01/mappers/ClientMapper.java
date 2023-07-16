package com.erichiroshi.bds01.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.erichiroshi.bds01.dto.ClientDTO;
import com.erichiroshi.bds01.entities.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientDTO toDTO(Client entity);

	Client toClient(ClientDTO dto);

	@Mapping(target = "id", ignore = true)
	void update(ClientDTO dto, @MappingTarget ClientDTO entityDTO);

}