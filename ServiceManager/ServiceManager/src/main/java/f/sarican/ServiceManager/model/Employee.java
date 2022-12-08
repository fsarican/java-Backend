package f.sarican.ServiceManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;

    private Date createDate = new Date();

    private String firstName;

    private String surName;

}
