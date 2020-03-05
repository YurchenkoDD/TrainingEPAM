package Yurchenko;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public HumanDTO get(HumanDTO dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human = converter.ConvertToEntity(dto);
        repository.get(human);
        dto = converter.ConvertToDTO(human);
        return dto;
    }

    public List<HumanDTO> getAll(int i) {
        List<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            list.add(get(dto));
        }
        return list;
    }

    public void saveAll(List<HumanDTO> alldto) {
        for (HumanDTO dto : alldto) {
            Converter converter = new Converter();
            Repository repository = new Repository();
            Human human = converter.ConvertToEntity(dto);
            repository.save(human);
        }
    }
}

