package Yurchenko;

import java.util.List;
import java.util.ArrayList;

/**
 * Service for working with dto
 */
public class Service {

    /**
     * Get dto from DB
     *
     * @param dto from user
     * @return filled dto
     */
    public HumanDto get(HumanDto dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human = converter.ConvertToEntity(dto);
        repository.get(human);
        dto = converter.ConvertToDto(human);
        return dto;
    }

    /**
     * Get all dto from DB
     *
     * @param i number of users
     * @return list of dto
     */
    public List<HumanDto> getAll(int i) {
        List<HumanDto> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDto dto = new HumanDto();
            list.add(get(dto));
        }
        return list;
    }

    /**
     * Save dto in DB
     *
     * @param dtoList of dto
     */
    public void saveAll(List<HumanDto> dtoList) {
        for (HumanDto dto : dtoList) {
            Converter converter = new Converter();
            Repository repository = new Repository();
            Human human = converter.ConvertToEntity(dto);
            repository.save(human);
        }
    }
}

