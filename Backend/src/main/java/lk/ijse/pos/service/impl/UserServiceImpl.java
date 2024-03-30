package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.LoginRequest;
import lk.ijse.pos.dto.UserDTO;
import lk.ijse.pos.entity.User;
import lk.ijse.pos.repo.UserRepo;
import lk.ijse.pos.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author : savindaJ
 * @date : 2024-03-30
 * @since : 0.1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    private final ModelMapper modelMapper;

    /**
     * @param userRepository : UserRepo
     * @param modelMapper : ModelMapper
     */
    public UserServiceImpl(UserRepo userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param userDTO : UserDTO
     * @return : boolean
     */
    @Override
    public boolean signUp(UserDTO userDTO) {
        return userRepository.save(modelMapper.map(userDTO, User.class)) != null;
    }

    /**
     * @param request : LoginRequest
     * @return : boolean
     */
    @Override
    public boolean findUser(LoginRequest request) {
        User user = userRepository.findByGmail(request.getGmail());
        if (user == null) throw new RuntimeException("User not found");
        return user.getPassword().equals(request.getPassword());
    }
}
