package br.com.apigateway.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.apigateway.data.vo.v2.PersonVO2;
import br.com.apigateway.model.Person;

@Service
public class PersonMapper {
	
	public PersonVO2 convertEntityToVo(Person person) {
		PersonVO2 vo = new PersonVO2();
		vo.setId(person.getId());
		vo.setAddres(person.getAddres());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	
	public Person convertVoTOEntity(PersonVO2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddres(person.getAddres());
		//vo.setBirthDay(new Date());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}

}
