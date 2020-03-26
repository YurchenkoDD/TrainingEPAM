package Yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts human to dto and vice versa
 */
public class Converter {

    private Logger fileAndConsoleLogger = LoggerFactory.getLogger(Converter.class);

    private Human.Address ConvertAddressToEntity(HumanDto.Address dtoAdd) {
        Human human = new Human();
        Human.Address address = human.new Address();
        address.setStreet(dtoAdd.getStreet());
        address.setCity(dtoAdd.getCity());
        address.setHouseNumber(dtoAdd.getHouseNumber());
        return address;
    }

    private HumanDto.Address ConvertAddressToDTO(Human.Address add) {
        HumanDto humanDto = new HumanDto();
        HumanDto.Address address = humanDto.new Address();
        address.setStreet(add.getStreet());
        address.setCity(add.getCity());
        address.setHouseNumber(add.getHouseNumber());
        return address;
    }

    public Human ConvertToEntity(HumanDto dto) {
        Human Human = new Human();
        Human.setId(dto.getId());
        Human.setName(dto.getName());
        Human.setBirthDate(dto.getBirthDate());
        Human.setAddress(ConvertAddressToEntity(dto.getAddress()));
        fileAndConsoleLogger.info("Конвертация из DTO в сущность");
        return Human;
    }

    public HumanDto ConvertToDTO(Human Human) {
        HumanDto dto = new HumanDto();
        dto.setId(Human.getId());
        dto.setName(Human.getName());
        dto.setBirthDate(Human.getBirthDate());
        dto.setAddress(ConvertAddressToDTO(Human.getAddress()));
        fileAndConsoleLogger.info("Конвертация из сущности в DTO");
        return dto;
    }
}