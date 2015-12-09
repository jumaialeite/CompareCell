package br.com.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.persistence.entity.Specification;

/**
 * Classe de acesso à base de dados para gerenciamento da entidade Specification.
 * 
 * @author Juliana
 */
@Local
public interface SpecificationDAO {
	
	/**
	 * Caso a entidade já esteja cadastrada na base, a atualiza, caso contrário cadastra uma nova.
	 * 
	 * @param entity entidade a ser inserida ou atualizada
	 * @return entidade inserida ou atualizada
	 */
	public Specification save(Specification entity);
	
	/**
	 * Busca uma entidade pelo seu identificador.
	 * 
	 * @param id identificador da entidade
	 * @return entidade caso encontrada, null caso contrário
	 */
	public Specification find(String id);
	
	/**
	 * Lista todas as entidades cadastradas na base.
	 * 
	 * @return lista de entidades encontradas
	 */
	public List<Specification> list();
	
	/**
	 * Remove a entidade da base de dados.
	 * 
	 * @param id Identificador da entidade a ser removida
	 */
	public void delete(String id);

}
