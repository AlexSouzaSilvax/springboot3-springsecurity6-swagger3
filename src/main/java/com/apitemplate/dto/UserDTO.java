package com.apitemplate.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.apitemplate.enums.UserRole;
import com.apitemplate.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {

        UUID id;

        String nome;

        String email;

        String celular;

        String username;

        @Enumerated(EnumType.STRING)
        UserRole userRole;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "data_criacao", nullable = false, updatable = false)
        @JsonProperty("data_criacao")
        Date dataCriacao;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "data_atualizacao", nullable = false, updatable = false)
        @JsonProperty("data_atualizacao")
        Date dataAtualizacao;

        public UserDTO() {

        }

        public List<UserDTO> UserToUserDTO(List<User> pListUser) {

                List<UserDTO> listUserDTO = new ArrayList<>();

                for (int i = 0; i < pListUser.size(); i++) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setId(pListUser.get(i).getId());
                        userDTO.setNome(pListUser.get(i).getNome());
                        userDTO.setEmail(pListUser.get(i).getEmail());
                        userDTO.setCelular(pListUser.get(i).getCelular());
                        userDTO.setUsername(pListUser.get(i).getUsername());
                        userDTO.setUserRole(pListUser.get(i).getUserRole());
                        userDTO.setDataCriacao(pListUser.get(i).getDataCriacao());
                        userDTO.setDataAtualizacao(pListUser.get(i).getDataAtualizacao());
                        listUserDTO.add(userDTO);
                }

                return listUserDTO;
        }

}
