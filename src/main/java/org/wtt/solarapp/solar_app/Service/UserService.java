package org.wtt.solarapp.solar_app.Service;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wtt.solarapp.solar_app.Entity.User;
import org.wtt.solarapp.solar_app.Repo.UserRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }
    
    public List<Map<String, Object>> getAllUsersWithImages() {
        List<User> users = userRepo.findAll();
        List<Map<String, Object>> userList = new ArrayList<>();

        for (User user : users) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("id", user.getId());
            userMap.put("name", user.getName());
            userMap.put("address", user.getAddress());
            userMap.put("mobileNumber", user.getMobileNumber());
            userMap.put("solarCapacity", user.getSolarCapacity());
            userMap.put("paymentMode", user.getPaymentMode());

          
            userMap.put("aadharCardFilepath", "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(user.getAadharCardFile()));
            userMap.put("panCardFilePath", "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(user.getPanCardFile()));
            userMap.put("bankDetailsUpload", "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(user.getBankDetailsFile()));

            userList.add(userMap);
        }

        return userList;
    }
    }
    
    


