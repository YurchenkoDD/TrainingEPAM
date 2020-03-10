package Yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Converter<P> {

    private  static final Logger logger = LoggerFactory.getLogger(Converter.class);

    private Human.Address ConvertAddressToEntity(HumanDTO.Address dtoAdd) {
        Human human = new Human();
        Human.Address address = human.new Address();
        address.setStreet(dtoAdd.getStreet());
        address.setCity(dtoAdd.getCity());
        address.setHouseNumber(dtoAdd.getHouseNumber());
        return address;
    }

    private HumanDTO.Address ConvertAddressToDTO(Human.Address add) {
        HumanDTO humanDTO = new HumanDTO();
        HumanDTO.Address address = humanDTO.new Address();
        address.setStreet(add.getStreet());
        address.setCity(add.getCity());
        address.setHouseNumber(add.getHouseNumber());
        return address;
    }

    public Human ConvertToEntity(HumanDTO dto) {
        logger.info("Конвертируем в сущность");
        Human Human = new Human();
        Human.setId(dto.getId());
        Human.setName(dto.getName());
        Human.setBirthDate(dto.getBirthDate());
        Human.setAddress(ConvertAddressToEntity(dto.getAddress()));
        return Human;
    }

    public HumanDTO ConvertToDTO(Human Human) {
        HumanDTO DTO = new HumanDTO();
        DTO.setId(Human.getId());
        DTO.setName(Human.getName());
        DTO.setBirthDate(Human.getBirthDate());
        DTO.setAddress(ConvertAddressToDTO(Human.getAddress()));
        return DTO;
    }
}