package by.bsuir.prognotes.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 05.12.2017 7:49
 */
@Service
public abstract class Mapper<E, D> {

    @Autowired
    @JsonIgnore
    protected ModelMapper modelMapper;

    abstract public E parseDto(D dto);

    abstract public D buildDto(E entity);

    public List<E> parseDtoList(List<D> dtoList) {
        List<E> entityList = new LinkedList<>();
        for (D dto : dtoList) {
            entityList.add(parseDto(dto));
        }
        return entityList;
    }

    public List<D> buildDtoList(List<E> entityList) {
        List<D> dtoList = new LinkedList<>();
        for (E entity : entityList) {
            dtoList.add(buildDto(entity));
        }
        return dtoList;
    }
}
