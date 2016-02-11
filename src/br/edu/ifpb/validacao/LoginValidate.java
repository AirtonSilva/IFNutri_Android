package br.edu.ifpb.validacao;

import android.content.Context;
import br.edu.ifpb.asynctask.LoginAs;

public class LoginValidate extends LoginAs{

	public LoginValidate(Context activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}
	
	//aqui deve estar a validação do usuário no sistema, 
	//após estabelecer conexão do cliente andoid com serviço rest,
	//enviar formulário via JSON (POST)
	// {'nome:' 'Fulano', 'senha': '123456'}
	// se estiver correto, código 200
	// senão, 400 - {'mensagem:', 'usuário ou senha inválidos'}
	
	//Url Serviço: /verificarLogin
	//Requisição POST (JSON): {"login": "*[a-z, A-Z]", "senha": "*[a-z, A-Z]"}
	//Resposta: HTTP código de sucesso: Accepted (202),
	//JSON: {"codigo": "*[1-9]", "nome": "*[a-z, A-Z]",
	//apikey: "*[a-z, A-Z]"}.

}
