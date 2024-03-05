package com.ecua3d.corporative.repository;


import com.ecua3d.corporative.model.FilamentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilamentRepository extends CrudRepository<FilamentEntity, Integer> {

}
