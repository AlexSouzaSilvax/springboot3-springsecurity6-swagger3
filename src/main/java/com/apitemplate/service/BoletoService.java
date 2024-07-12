package com.apitemplate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apitemplate.dto.BoletoDTO;
import com.apitemplate.model.Boleto;
import com.apitemplate.model.User;
import com.apitemplate.repository.BoletoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoletoService {

	private BoletoRepository boletoRespository;

	private BoletoDTO boletoDTO;

	@Transactional
	public List<BoletoDTO> findAll(UUID pIdUsuario) {
		return boletoDTO.BoletoToBoletoDTO(boletoRespository.findAllByUser(pIdUsuario));
	}

	public BoletoDTO findById(UUID id) {
		return new BoletoDTO(boletoRespository.findById(id).get());
	}

	public Object saveOrUpdate(BoletoDTO pBoletoDTO) {
		Boleto pBoleto = new Boleto(pBoletoDTO);
		if (pBoleto.getId() != null) {
			return update(pBoleto);
		}
		pBoleto.setPagador(new User(pBoletoDTO.getPagador()));
		return save(pBoleto);
	}

	public Boleto save(Boleto pBoleto) {
		return boletoRespository.save(pBoleto);
	}

	public Object update(Boleto pBoleto) {
		boletoRespository.updateAllById(
				pBoleto.getValor(),
				pBoleto.getDataVencimento(),
				pBoleto.getCodigoBarras(),
				pBoleto.getDataPagamento(),
				pBoleto.getValorPago(),
				pBoleto.getId());
		return boletoRespository.findById(pBoleto.getId());
	}

	public void delete(UUID id) {
		if (existsBoleto(id)) {
			boletoRespository.deleteById(id);
		}
	}

	public boolean existsBoleto(UUID id) {
		return boletoRespository.existsById(id);
	}
}