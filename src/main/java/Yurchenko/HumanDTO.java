package Yurchenko;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HumanDTO {
    private Integer id;
    private String name;
    private Address address;
    private Date birthDate;

    @Data
    class Address {
        private String city;
        private String street;
        private Integer houseNumber;
    }
}
