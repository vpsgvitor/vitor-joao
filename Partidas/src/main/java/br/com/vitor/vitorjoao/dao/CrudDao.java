package br.com.vitor.vitorjoao.dao;

import java.util.List;

public interface CrudDao<T> {

	void salvar(T dado);

	void alterar(T dado);

	void excluir(T dado);

	T findOne(Long id);

	List<T> listar();

}
