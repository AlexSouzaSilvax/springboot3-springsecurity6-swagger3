package com.apitemplate.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apitemplate.model.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, UUID> {

	@Query(value = "select * from boleto where id_usuario = :pIdUsuario order by 1 desc", nativeQuery = true)
	List<Boleto> findAllByUser(@Param("pIdUsuario") UUID pIdUsuario);

	@Query(value = "SELECT EXISTS (SELECT 1 FROM boleto WHERE id_usuario = :pIdUsuario ) AS registro_existe", nativeQuery = true)
	boolean existsBoletoUser(@Param("pIdUsuario") UUID pIdUsuario);

	@Query(value = "delete from boleto where id_usuario = :pIdUsuario", nativeQuery = true)
	void deleteAllBoletosPorUser(@Param("pIdUsuario") UUID pIdUsuario);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update boleto set valor = :pValor, data_vencimento = :pDataVencimento, codigo_barras = :pCodigoBarras, data_pagamento = :pDataPagamento, valor_pago = :pValorPago where id = :pId", nativeQuery = true)
	void updateAllById(
			@Param("pValor") BigDecimal pValor,
			@Param("pDataVencimento") LocalDate pDataVencimento,
			@Param("pCodigoBarras") String pCodigoBarras,
			@Param("pDataPagamento") LocalDate pDataPagamento,
			@Param("pValorPago") BigDecimal pValorPago,
			@Param("pId") UUID pId);

}