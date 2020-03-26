package Yurchenko;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HumanDto {
    private Integer id;
    private String name;
    private Date birthDate;
    private Address address;

    @Data
    public class Address {
        private String city;
        private String street;
        private Integer houseNumber;
    }
}
