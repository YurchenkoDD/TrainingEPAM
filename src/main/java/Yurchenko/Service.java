package Yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Yurchenko.exceptions.EntityNotFound;

import Yurchenko.exceptions.*;

import java.util.List;
import java.util.ArrayList;

public class Service {
    private Converter converter = new Converter();
    private Repository repository = new Repository();
    private Logger fileLogger = LoggerFactory.getLogger(Service.class);
    private static final int AllOWED_ID = 30;

    /**
     * Get dto from repository (DB)
     *
     * @param dto from user
     * @return filled dto
     */
    public HumanDto get(HumanDto dto) {
        Human human = converter.ConvertToEntity(dto);
        try {
            repository.get(human);
            fileLogger.info("Сущность с id = {} и name = {} получена из БД", dto.getId(), dto.getName());
        } catch (CanNotSaveEntity e) {
            fileLogger.warn("Exception: ", e);
        }
        return converter.ConvertToDTO(human);
    }
    /**
     * Get allDto from DB
     *
     * @param i person from DB
     * @return filled dto
     */
    public List<HumanDto> getAll(int i) {
        List<HumanDto> dtoList = new ArrayList<>();
        try {
            List<Human> humanList = repository.getAll(i);
            for (int j = 0; j < i; j++) {
                Human human = humanList.get(j);
                HumanDto dto = converter.ConvertToDTO(human);
                dtoList.add(dto);
            }
        } catch (EntityNotFound e) {
            fileLogger.warn("Exception: ", e);
        }

        return dtoList;
    }

    public void saveAll(List<HumanDto> dtos) {
        for (HumanDto dto : dtos) {
            Human human = converter.ConvertToEntity(dto);
            try {
                repository.save(human);
                fileLogger.info("Сущность с id = {} и name = {} сохранена в БД", dto.getId(), dto.getName());
            } catch (CanNotSaveEntity e) {
                fileLogger.warn("Exception: ", e);
            }
        }
    }
}
