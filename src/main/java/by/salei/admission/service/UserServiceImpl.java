package by.salei.admission.service;

import by.salei.admission.dao.api.UserDao;
import by.salei.admission.dto.UserCreateDto;
import by.salei.admission.dto.UserGetDto;
import by.salei.admission.dto.UserUpdateDto;
import by.salei.admission.entity.User;
import by.salei.admission.entity.UserRole;
import by.salei.admission.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserCreateDto save(UserCreateDto entity) {

        User user = new User();
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setRole(UserRole.USER);

        userDao.save(user);
        return  entity;
    }

    @Override
    public UserUpdateDto update(UserUpdateDto newEntity) {
        return null;
    }

    @Override
    public UserGetDto delete(Long id) {
        return null;
    }

    @Override
    public UserGetDto getById(Long id) {

        User user = userDao.getById(id);
        return UserGetDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .build();
    }

    @Override
    public List<UserGetDto> getAll() {
        return null;
    }

    @Override
    public UserGetDto getByUsername(String username) throws NoResultException{

        User user = userDao.getByUsername(username);
        return UserGetDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .build();
    }
}
