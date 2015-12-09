package br.com.controller;

import java.util.List;

import br.com.persistence.entity.SpecificationType;

/**
 * Classe que gerencia informa��es de SpecificationType.
 * 
 * @author Juliana
 */
public interface SpecificationTypeControllerLocal {
	
	/**
	 * Salva um tipo de especifica��o. 
	 * Caso n�o esteja cadastrado adiciona um novo, caso esteja, atualiza as informa��es.
	 * 
	 * @param entity entidade a ser cadastrada ou atualizada
	 */
	public void save(SpecificationType entity);
	
	/**
	 * Lista os tipos de especifica��o cadastrados no banco.
	 * 
	 * @return lista dos tipos encontrados
	 */
	public List<SpecificationType> list();

}
