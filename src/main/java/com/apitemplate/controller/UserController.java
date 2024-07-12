package com.apitemplate.controller;

import com.apitemplate.dto.UserDTO;
import com.apitemplate.model.User;
import com.apitemplate.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "User", description = "User API")
public class UserController {

	private UserService userService;

	@GetMapping("find-all")
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping("update")
	public ResponseEntity<Object> update(@RequestBody User pUsuario) {
		return ResponseEntity.ok(userService.update(pUsuario));
	}

	@PostMapping("delete")
	public ResponseEntity<Object> delete(@RequestBody UUID id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}