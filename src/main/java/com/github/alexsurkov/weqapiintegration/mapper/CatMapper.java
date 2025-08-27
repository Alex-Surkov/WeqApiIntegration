package com.github.alexsurkov.weqapiintegration.mapper;

import com.github.alexsurkov.weqapiintegration.dto.CatDto;
import net.proselyte.catapiintegration.model.Cat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapper {

    CatDto toCatDto(Cat cat);

    List<CatDto> toCatDto(List<Cat> cats);
}
