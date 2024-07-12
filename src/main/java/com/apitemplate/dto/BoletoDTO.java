package com.apitemplate.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.apitemplate.model.Boleto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BoletoDTO {

        private UUID id;

        private UUID pagador;

        private BigDecimal valor;

        private LocalDate dataVencimento;

        private String codigoBarras;

        private LocalDate dataPagamento;

        private BigDecimal valorPago;

        public BoletoDTO() {

        }

        public BoletoDTO(Boleto pBoleto) {
                this.id = pBoleto.getId();
                this.pagador = pBoleto.getPagador().getId();
                this.valor = pBoleto.getValor();
                this.dataVencimento = pBoleto.getDataVencimento();
                this.codigoBarras = pBoleto.getCodigoBarras();
                this.dataPagamento = pBoleto.getDataPagamento();
                this.valorPago = pBoleto.getValorPago();
        }

        public List<BoletoDTO> BoletoToBoletoDTO(List<Boleto> pListBoleto) {

                List<BoletoDTO> listBoletoDTO = new ArrayList<>();

                for (int i = 0; i < pListBoleto.size(); i++) {
                        BoletoDTO boletoDTO = new BoletoDTO();
                        boletoDTO.setId(pListBoleto.get(i).getId());
                        boletoDTO.setPagador(pListBoleto.get(i).getPagador().getId());
                        boletoDTO.setValor(pListBoleto.get(i).getValor());
                        boletoDTO.setDataVencimento(pListBoleto.get(i).getDataVencimento());
                        boletoDTO.setCodigoBarras(pListBoleto.get(i).getCodigoBarras());
                        boletoDTO.setDataPagamento(pListBoleto.get(i).getDataPagamento());
                        boletoDTO.setValorPago(pListBoleto.get(i).getValorPago());
                        listBoletoDTO.add(boletoDTO);
                }
                
                return listBoletoDTO;
        }

}
