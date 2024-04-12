package miu.edu.cs489.packagetracker.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("OPERATOR")
public class AirportOperator extends PackageSystemUser {

    private String emp_num;
}
