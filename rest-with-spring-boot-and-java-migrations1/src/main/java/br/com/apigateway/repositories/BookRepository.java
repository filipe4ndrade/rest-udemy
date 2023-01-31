package br.com.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apigateway.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
