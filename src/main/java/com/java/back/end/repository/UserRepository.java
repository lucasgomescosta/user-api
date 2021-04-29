package com.java.back.end.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.back.end.model.User;

/**
 * O repositório é uma interface anotada com @Repository , que também é um bean
 * do Spring e que será automaticamente instanciado na inicialização da
 * aplicação. Algumas consultas podem ser criadas apenas com o nome do método.
 * Esses métodos devem ter algumas palavras-chaves no nome como find , and , or
 * , like e o nome do campo.
 * 
 * @author lucas.costa
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCPF(String cpf);

	List<User> queryByNomeLike(String name);

}
