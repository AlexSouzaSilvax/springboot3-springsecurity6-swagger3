package com.apitemplate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apitemplate.dto.UserDTO;
import com.apitemplate.model.User;
import com.apitemplate.repository.BoletoRepository;
import com.apitemplate.repository.UserRepository;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRespository;

	private BoletoRepository boletoRepository;

	private UserDTO userDTO;

	@Transactional
	public List<UserDTO> findAll() {
		return userDTO.UserToUserDTO(userRespository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	}

	public Object findById(UUID idUser) {
		return userRespository.findById(idUser);
	}

	public User save(User pUser) {
		return userRespository.save(pUser);
	}

	public Object update(User pUser) {
		userRespository.updateAllById(
				pUser.getNome(),
				pUser.getEmail(),
				pUser.getCelular(),
				pUser.getUsername(),
				pUser.getPassword(),
				pUser.getUserRole(),
				pUser.getDataCriacao(),
				pUser.getDataAtualizacao(),
				pUser.getId());
		return findById(pUser.getId());

	}

	public void delete(UUID idUser) {
		if (existsUser(idUser)) {
			if (existsBoletoUser(idUser)) {
				boletoRepository.deleteAllBoletosPorUser(idUser);
			}
			userRespository.deleteById(idUser);
		}
	}

	public boolean existsUser(UUID idUser) {
		return userRespository.existsById(idUser);
	}

	public boolean existsBoletoUser(UUID idUser) {
		return boletoRepository.existsBoletoUser(idUser);
	}
}