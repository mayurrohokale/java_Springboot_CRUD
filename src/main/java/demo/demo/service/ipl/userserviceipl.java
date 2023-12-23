package demo.demo.service.ipl;

import demo.demo.entity.user;
import demo.demo.repository.userrepository;
import demo.demo.service.userservice;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class userserviceipl implements userservice {
    private userrepository userRepository;
    @Override
    public user createUser(user User) {
        return userRepository.save(User);
    }

    @Override
    public user getUserById(Long userId) {
        Optional<user> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<user> getAlluser() {
        return userRepository.findAll();
    }

    @Override
    public user updateUser(user user) {
        user existinguser = userRepository.findById(user.getId()).get();
        existinguser.setFirstname(user.getFirstname());
        existinguser.setLastname(user.getLastname());
        existinguser.setEmail(user.getEmail());
        user updateduser = userRepository.save(existinguser);
        return updateduser;
    }

    @Override
    public void deleteuser(Long userId) {
        userRepository.deleteById(userId);
    }
}
