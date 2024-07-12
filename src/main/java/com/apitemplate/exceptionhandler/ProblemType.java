package com.apitemplate.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	ACESSO_NEGADO("/acesso-negado", "Acesso negado"),
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	MENSAGEM_NAO_COMPREENSIVEL("/mensagem-incompreensivel", "Mensagem não compreensível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	USUARIO_NAO_ENCONTRADO("/usuario-nao-encontrado", "Usuario não encontrado"),
	USUARIO_EXISTENTE("/usuario-existente", "Usuario existente"),
	EMAIL_NAO_ENCONTRADO("/email-nao-encontrado", "Email não encontrado"),
	EMAIL_EM_USO("/email-em-uso", "Email em uso"),
	CPF_EM_USO("/cpf-em-uso", "CPF em uso"),
	PERFIL_EXISTENTE("/perfil-existente", "Perfil existente"),
	PERFIL_NAO_ENCONTRADO("/perfil-nao-encontrado", "Perfil não encontrado");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://www.seusite.com.br" + path;
		this.title = title;
	}
	
}
