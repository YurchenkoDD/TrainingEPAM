package Yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Yurchenko.exceptions.*;
import java.util.List;
import java.util.ArrayList;

public class Service {
    private Converter converter = new Converter();
    private Repository repository = new Repository();
    private Logger fileLogger = LoggerFactory.getLogger(Service.class);
    private static final int AllOWED_ID = 30;

    public HumanDTO get(HumanDTO dto) {
        Human human = converter.ConvertToEntity(dto);
        try{
            repository.get(human);
            fileLogger.info("Сущность с id = {} и name = {} получена из БД", dto.getId(), dto.getName());
        }catch(CanNotSaveEntity e){
            fileLogger.warn("Exception: ",e);
        }
        return converter.ConvertToDTO(human);
    }

    public List<HumanDTO> getAll(int i) throws EntityNotFound {
        List<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            if(dto.getId()>AllOWED_ID){
                fileLogger.warn("Человек с id = {} и name = {} не найден", dto.getId());
                throw new EntityNotFound("Человек с id"+ dto.getId()+" не найден");
            }
            list.add(get(dto));
        }
        return list;
    }

    public void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO dto : dtos) {
            Human human=converter.ConvertToEntity(dto);
            try {
                repository.save(human);
                fileLogger.info("Сущность с id = {} и name = {} сохранена в БД", dto.getId(), dto.getName());
            } catch (CanNotSaveEntity e){
                fileLogger.warn("Exception: ",e);
            }
        }
    }
}
