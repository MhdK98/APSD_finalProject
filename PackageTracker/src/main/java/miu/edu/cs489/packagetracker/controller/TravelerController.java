package miu.edu.cs489.packagetracker.controller;

import miu.edu.cs489.packagetracker.entity.Traveler;
import miu.edu.cs489.packagetracker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/traveler")
public class TravelerController {

    UsersService usersService;

    @Autowired
    public TravelerController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Traveler> findAll(){
        return usersService.getAllUsers();
    }

}
