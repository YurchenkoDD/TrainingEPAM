package Yurchenko;

/*
    Converts from human to dto and vice versa
 */

public class Converter<P> {
    private Human.Address ConvertAddressToEntity(HumanDto.Address dtoAdd) {
        Human human = new Human();
        Human.Address address = human.new Address();
        address.setStreet(dtoAdd.getStreet());
        address.setCity(dtoAdd.getCity());
        address.setHouseNumber(dtoAdd.getHouseNumber());
        return address;
    }

    private HumanDto.Address ConvertAddressToDto(Human.Address add) {
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
        return Human;
    }

    public HumanDto ConvertToDto(Human Human) {
        HumanDto Dto = new HumanDto();
        Dto.setId(Human.getId());
        Dto.setName(Human.getName());
        Dto.setBirthDate(Human.getBirthDate());
        Dto.setAddress(ConvertAddressToDto(Human.getAddress()));
        return Dto;
    }
}