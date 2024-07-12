package com.apitemplate.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.apitemplate.dto.BoletoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private User pagador;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "codigo_barras", nullable = false, unique = true)
    private String codigoBarras;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    public Boleto() {

    }

    public Boleto(BoletoDTO pBoletoDTO) {
        this.id = pBoletoDTO.getId();
        this.pagador = new User(pBoletoDTO.getPagador());
        this.valor = pBoletoDTO.getValor();
        this.dataVencimento = pBoletoDTO.getDataVencimento();
        this.codigoBarras = pBoletoDTO.getCodigoBarras();
        this.dataPagamento = pBoletoDTO.getDataPagamento();
        this.valorPago = pBoletoDTO.getValorPago();
    }

}
