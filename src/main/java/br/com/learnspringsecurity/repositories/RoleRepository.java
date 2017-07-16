package br.com.learnspringsecurity.repositories;

import br.com.learnspringsecurity.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
