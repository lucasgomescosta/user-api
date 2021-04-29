package com.java.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.back.end.dto.UserDTO;
import com.java.back.end.exception.UserNotFoundException;
import com.java.back.end.service.UserService;

/**
 * Basicamente, eles chamarão a classe da camada de serviço. A classe continua
 * com a mesma anotação @RestController e os métodos com as
 * anotações @GetMapping , @PostMapping e @DeleteMapping. Uma diferença é a
 * injeção da dependência da classe de serviços UserService. Os métodos nela são
 * os mesmos, com a diferença de que agora são chamados os métodos da camada de
 * serviço em vez de manipular a lista em memória. a anotação @RequestParam deve
 * ser usada quando queremos passar parâmetros na URL para a rota.
 * url: "http://localhost:8080/user/search?nome=mar%25"
 * 
 * @author lucas.costa
 *
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<UserDTO> getUsers() {
		List<UserDTO> usuarios = userService.getAll();
		return usuarios;
	}

	@GetMapping("/user/{id}")
	UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PostMapping("/user")
	UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}

	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}

	@DeleteMapping("/user/{id}")
	UserDTO delete(@PathVariable Long id) throws UserNotFoundException {
		return userService.delete(id);
	}

	/**
	 * fará a busca pelo nome recebido como parâmetro - o nome pode ser completo ou
	 * apenas parte do nome. Se o nome for completo, a rota retornará apenas um
	 * usuário, se o usuário passar apenas parte do nome, pode ser retornada uma
	 * lista de usuários. Outra novidade é a anotação @RequestParam , que deve ser
	 * usada quando queremos passar parâmetros na URL para a rota.
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {
		return userService.queryByName(nome);
	}
}
