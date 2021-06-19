package com.mstore.domain.shared.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, ID> {

	public T findById(ID id);

	public Page<T> findAll(Pageable pageable);

	public Long count();

	public List<T> findAll();

	public <S extends T> S save(S entity);

	void deleteById(ID id);

	void delete(T entity);
}
