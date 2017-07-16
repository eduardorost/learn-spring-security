package br.com.learnspringsecurity.repositories;

import br.com.learnspringsecurity.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findFirstByLoginAndPassword(String login, String password);
}
