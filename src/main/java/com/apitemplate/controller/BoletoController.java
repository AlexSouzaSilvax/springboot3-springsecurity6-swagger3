package com.apitemplate.controller;

import com.apitemplate.dto.BoletoDTO;
import com.apitemplate.service.BoletoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/boleto")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Boleto", description = "Boleto API")
public class BoletoController {
	private BoletoService boletoService;

	@GetMapping("find-all")
	public ResponseEntity<Object> findAll(@RequestParam UUID idUsuario) {
		return ResponseEntity.ok(boletoService.findAll(idUsuario));
	}

	@GetMapping("find-by-id")
	public ResponseEntity<Object> findById(@RequestParam UUID id) {
		return ResponseEntity.ok(boletoService.findById(id));
	}

	@PostMapping("create")
	public ResponseEntity<Object> create(@RequestBody BoletoDTO pBoletoDTO) {
		boletoService.saveOrUpdate(pBoletoDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("delete")
	public ResponseEntity<Object> delete(@RequestBody UUID id) {
		boletoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
