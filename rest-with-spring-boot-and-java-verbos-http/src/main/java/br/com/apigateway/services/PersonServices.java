package br.com.apigateway.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apigateway.data.vo.v1.PersonVO;
import br.com.apigateway.data.vo.v2.PersonVO2;
import br.com.apigateway.exceptions.ResourceNotFoundException;
import br.com.apigateway.mapper.DozerMapper;
import br.com.apigateway.mapper.custom.PersonMapper;
import br.com.apigateway.model.Person;
import br.com.apigateway.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parserListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parserObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parserObject(person, Person.class);
		var vo =  DozerMapper.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO2 createV2(PersonVO2 person) {

		logger.info("Creating one person with V2!");
		var entity = mapper.convertVoTOEntity(person);
		var vo =  mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddres(person.getAddres());
		entity.setGender(person.getGender());
		
		var vo =  DozerMapper.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}