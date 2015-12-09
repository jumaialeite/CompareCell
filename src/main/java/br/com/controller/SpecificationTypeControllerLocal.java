package br.com.controller;

import java.util.List;

import br.com.persistence.entity.SpecificationType;

/**
 * Classe que gerencia informações de SpecificationType.
 * 
 * @author Juliana
 */
public interface SpecificationTypeControllerLocal {
	
	/**
	 * Salva um tipo de especificação. 
	 * Caso não esteja cadastrado adiciona um novo, caso esteja, atualiza as informações.
	 * 
	 * @param entity entidade a ser cadastrada ou atualizada
	 */
	public void save(SpecificationType entity);
	
	/**
	 * Lista os tipos de especificação cadastrados no banco.
	 * 
	 * @return lista dos tipos encontrados
	 */
	public List<SpecificationType> list();

}
