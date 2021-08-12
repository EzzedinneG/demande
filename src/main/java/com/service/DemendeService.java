package com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.model.Demende;


public interface DemendeService {
	public Page<Demende> findallDemende(Pageable page);
	public Optional<Demende> FindById(long id);
    public void AddDemende (Demende user);
	public Optional<Demende> UpdateDemende(Demende user);
	public Optional<Demende> Deletebyid(long id);

}
