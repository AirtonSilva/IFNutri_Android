package br.edu.ifpb.validacao;

import android.content.Context;
import br.edu.ifpb.asynctask.LoginAs;

public class LoginValidate extends LoginAs{

	public LoginValidate(Context activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}
	
	//aqui deve estar a valida��o do usu�rio no sistema, 
	//ap�s estabelecer conex�o do cliente andoid com servi�o rest,
	//enviar formul�rio via JSON (POST)
	// {'nome:' 'Fulano', 'senha': '123456'}
	// se estiver correto, c�digo 200
	// sen�o, 400 - {'mensagem:', 'usu�rio ou senha inv�lidos'}
	
	//Url Servi�o: /verificarLogin
	//Requisi��o POST (JSON): {"login": "*[a-z, A-Z]", "senha": "*[a-z, A-Z]"}
	//Resposta: HTTP c�digo de sucesso: Accepted (202),
	//JSON: {"codigo": "*[1-9]", "nome": "*[a-z, A-Z]",
	//apikey: "*[a-z, A-Z]"}.

}
