package br.com.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.persistence.entity.Cellular;

/**
 * Classe de acesso à base de dados para gerenciamento da entidade Cellular.
 *  
 * @author Juliana
 */
@Local
public interface CellularDAO {
	
	/**
	 * Caso a entidade já esteja cadastrada na base, a atualiza, caso contrário cadastra uma nova.
	 * 
	 * @param entity entidade a ser inserida ou atualizada
	 * @return entidade inserida ou atualizada
	 */
	public Cellular save(Cellular entity);
	
	/**
	 * Busca uma entidade pelo seu identificador.
	 * 
	 * @param id identificador da entidade
	 * @return entidade caso encontrada, null caso contrário
	 */
	public Cellular find(Long id);
	
	/**
	 * Lista todas as entidades cadastradas na base.
	 * 
	 * @param order se true, ordena pelos favoritos
	 * @return lista de entidades encontradas
	 */
	public List<Cellular> list(boolean order);
	
	/**
	 * Remove a entidade da base de dados.
	 * 
	 * @param id Identificador da entidade a ser removida
	 */
	public void delete(Long id);
	
	/**
	 * Busca a entidade pelo nome.
	 * 
	 * @param name nome a ser utilizado na busca
	 * @return entidade caso encontrada, null caso contrário
	 */
	public Cellular findByName(String name);

}
