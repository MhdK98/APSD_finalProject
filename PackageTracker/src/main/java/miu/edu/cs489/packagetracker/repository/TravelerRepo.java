package miu.edu.cs489.packagetracker.repository;

import miu.edu.cs489.packagetracker.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepo extends JpaRepository<Traveler, Integer> {

    public Traveler findTravelerByEmail(String email);
}
