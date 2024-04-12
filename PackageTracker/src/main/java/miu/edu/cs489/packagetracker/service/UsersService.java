package miu.edu.cs489.packagetracker.service;

import miu.edu.cs489.packagetracker.repository.SystemUserDao;
import miu.edu.cs489.packagetracker.entity.AirportOperator;
import miu.edu.cs489.packagetracker.entity.PackageSystemUser;
import miu.edu.cs489.packagetracker.entity.Traveler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    SystemUserDao userDao;

    @Autowired
    public UsersService(SystemUserDao userDao) {
        this.userDao = userDao;
    }

    public void saveOperator(AirportOperator airportOperator) throws Exception {
        if(airportOperator != null){
            userDao.save(airportOperator);
        }
        throw new Exception("User sent to save method is null");
    }

    public void saveTraveler(Traveler traveler) throws Exception {
        if(traveler != null){
            userDao.save(traveler);
        }
        throw new Exception("User sent to save method is null");
    }

    public List<PackageSystemUser> getAllUsers(){
        return (List<PackageSystemUser>) userDao.findAll();
    }

    public Traveler getTravelerById(Integer travelerId) throws Exception {
        Optional<PackageSystemUser> userOptional = userDao.findById(travelerId);
        if (userOptional.isPresent() && userOptional.get() instanceof Traveler) {
            return (Traveler) userOptional.get();
        }
        throw new Exception("Traveler not found with this Id = " + travelerId);
    }

    public AirportOperator getOperatorById(Integer operatorId) throws Exception {
        Optional<PackageSystemUser> userOptional = userDao.findById(operatorId);
        if (userOptional.isPresent() && userOptional.get() instanceof AirportOperator) {
            return (AirportOperator) userOptional.get();
        }
        throw new Exception("Airport Operator not found with this Id = " + operatorId);
    }

    public void deleteUser(Integer systemUserId){
        Optional<PackageSystemUser> user = userDao.findById(systemUserId);
        user.ifPresent(systemUser -> userDao.delete(systemUser));
    }


}
