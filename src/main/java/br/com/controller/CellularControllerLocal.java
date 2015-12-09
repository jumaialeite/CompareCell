package br.com.controller;

import java.util.List;

import br.com.exception.NullParameterException;
import br.com.persistence.entity.Cellular;

/**
 * Classe que gerencia informa��es de Cellular.
 * 
 * @author Juliana
 */
public interface CellularControllerLocal {
	
	/**
	 * Salva um celular. Caso n�o esteja cadastrado adiciona um novo, caso esteja, atualiza as informa��es.
	 * 
	 * @param cellular celular a ser cadastrado ou atualizado
	 * @return celular cadastrado ou atualizado
	 * @throws NullParameterException lan�ada quando as informa��es obrigat�rias n�o estejam preenchidas
	 */
	public Cellular save(Cellular cellular) throws NullParameterException;
	
	/**
	 * Lista os celulares cadastrados
	 * 
	 * @param order se true, ordena pelos favoritos
	 * @return lista de celulares cadastrados na base.
	 */
	public List<Cellular> list(boolean order);
	
	/**
	 * Localiza um celular por seu identificador.
	 * 
	 * @param id identificador do celular a ser encontrado.
	 * @return celular caso seja encontrado, null caso contr�rio.
	 */
	public Cellular find(Long id);

	/**
	 * Remove um celular da base.
	 * 
	 * @param id identificador do celular a ser removido.
	 */
	public void remove(Long id);
	
	/**
	 * Busca um celular pelo seu nome.
	 * 
	 * @param name nome a ser utilizado na busca.
	 * @return celular caso seja encontrado, null caso contr�rio.
	 */
	public Cellular findByName(String name);
	
	/**
	 * Adiciona um n�mero na pontua��o de favorito do celular.
	 * 
	 * @param cellularName nome do celular
	 * @return celular atualizado
	 * @throws NullParameterException lan�ada quando as informa��es obrigat�rias n�o estejam preenchidas
	 */
	public Cellular addFavourite(String cellularName) throws NullParameterException;
}
