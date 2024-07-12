package com.apitemplate.repository;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apitemplate.enums.UserRole;
import com.apitemplate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByUsername(String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update usuario set nome = :pNome, email = :pEmail, celular = :pCelular, username = :pUsername, password = :pPassword, user_role = :pUserRole, data_criacao = :pDataCriacao, data_atualizacao = :pDataAtualizacao where id = :pId", nativeQuery = true)
    void updateAllById(
            @Param("pNome") String pNome,
            @Param("pEmail") String pEmail,
            @Param("pCelular") String pCelular,
            @Param("pUsername") String pUsername,
            @Param("pPassword") String pPassword,
            @Param("pUserRole") UserRole pUserRole,
            @Param("pDataCriacao") Date pDataCriacao,
            @Param("pDataAtualizacao") Date pDataAtualizacao,
            @Param("pId") UUID pId);
}