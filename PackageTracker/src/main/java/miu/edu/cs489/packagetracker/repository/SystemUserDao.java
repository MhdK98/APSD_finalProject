package miu.edu.cs489.packagetracker.repository;

import miu.edu.cs489.packagetracker.entity.PackageSystemUser;
import org.springframework.data.repository.CrudRepository;

public interface SystemUserDao extends CrudRepository<PackageSystemUser, Integer> {

}
