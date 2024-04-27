package miu.edu.cs489.packagetracker.service;

import miu.edu.cs489.packagetracker.entity.Traveler;
import miu.edu.cs489.packagetracker.repository.TravelerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements ApplicationRunner {

    TravelerRepo travelerRepo;

    @Autowired
    public UsersService(TravelerRepo travelerRepo) {
        this.travelerRepo = travelerRepo;
    }

    public void saveTraveler(Traveler traveler) throws Exception {
        if(traveler != null){
            travelerRepo.save(traveler);
        }
        throw new Exception("User sent to save method is null");
    }

    public List<Traveler> getAllUsers(){
        return (List<Traveler>) travelerRepo.findAll();
    }

    public Traveler getTravelerById(Integer travelerId) throws Exception {
        Optional<Traveler> userOptional = travelerRepo.findById(travelerId);
        if (userOptional.isPresent()) {
            return (Traveler) userOptional.get();
        }
        throw new Exception("Traveler not found with this Id = " + travelerId);
    }

    public Traveler getTravelerByEmail(String travelerEmail) throws Exception {
        return travelerRepo.findTravelerByEmail(travelerEmail);
    }

    public void deleteUser(Integer systemUserId){
        Optional<Traveler> user = travelerRepo.findById(systemUserId);
        user.ifPresent(systemUser -> travelerRepo.delete(systemUser));
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        addInitialData();
    }

    private void addInitialData() {


    }
}
