package br.com.igrejas.domain.exceptions;

public class RestricaoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5351778774801906600L;
	private static final String MESSAGE = "Restricao Não encontrada com o %i";
	public RestricaoNotFoundException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
