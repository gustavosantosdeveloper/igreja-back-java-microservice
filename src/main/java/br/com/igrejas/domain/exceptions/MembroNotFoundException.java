package br.com.igrejas.domain.exceptions;

public class MembroNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final String MESSAGE = "Usuário não encontrado com o id %s";
	private static final long serialVersionUID = 6590095929948729065L;

	public MembroNotFoundException() {
		super(MESSAGE);
	}
	
}
