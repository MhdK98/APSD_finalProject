package miu.edu.cs489.packagetracker.service;


import jakarta.transaction.Transactional;
import miu.edu.cs489.packagetracker.repository.TravelerRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final TravelerRepo userRepo;

    public MyUserDetailsService(TravelerRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException, DataAccessException {
        var user = userRepo.findTravelerByEmail(s);
        var userDetails = new MyUserDetails(user);
        return userDetails;
    }
}
