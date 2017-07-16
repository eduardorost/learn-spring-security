package br.com.learnspringsecurity.services;

import br.com.learnspringsecurity.entities.RoleEntity;
import br.com.learnspringsecurity.entities.UserEntity;
import br.com.learnspringsecurity.enums.ModuleType;
import br.com.learnspringsecurity.models.User;
import br.com.learnspringsecurity.repositories.RoleRepository;
import br.com.learnspringsecurity.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    public User insert(User user) {
        user.setRegisterDate(new Date());
        user.setEnable(true);

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setRoles(null);

        userEntity = userRepository.save(userEntity);

        userEntity.setRoles(new HashSet<RoleEntity>() {{ add(new RoleEntity(ModuleType.USER.toString())); }});

        for (RoleEntity roleEntity: userEntity.getRoles()) {
            roleEntity.setUser(userEntity);
            roleRepository.save(roleEntity);
        }

        return modelMapper.map(userEntity, User.class);
    }
}
