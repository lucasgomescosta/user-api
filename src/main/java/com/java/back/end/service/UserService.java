package com.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.back.end.dto.UserDTO;
import com.java.back.end.model.User;
import com.java.back.end.repository.UserRepository;

@Service
public class UserService {
	/**
	 * camada intermediária - onde ficam as regras de negócio da aplicação. Essas
	 * classes devem ser anotadas com @Service e normalmente são responsáveis por
	 * fazer chamadas ao repositório e também a outros serviços.
	 */

	/**
	 * Autowired é uma anotação para injeção de classes/dependências no Spring,
	 * evitando o alto nível de acoplamento de código, aumentando a legibilidade,
	 * facilidade de manutenção e facilidade de testes.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 1. Chama o método findAll , do UserRepository , que retorna uma lista de
	 * usuários, sendo instâncias da entidade User . 2. Transforma a lista em um
	 * stream e chama o método map para transformar a lista de entidades em uma
	 * lista de DTOs. 3. Retorna a lista de DTOs.
	 * 
	 * @return
	 */
	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

	public UserDTO findById(long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		if (usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		return null;
	}

	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	public UserDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		return null;
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCPF(cpf);
		if (user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}

	public List<UserDTO> queryByName(String name) {
		List<User> usuarios = userRepository.queryByNomeLike(name);
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

}
