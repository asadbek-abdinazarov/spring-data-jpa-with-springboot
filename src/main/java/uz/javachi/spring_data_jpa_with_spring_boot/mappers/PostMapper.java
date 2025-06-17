package uz.javachi.spring_data_jpa_with_spring_boot.mappers;

import org.mapstruct.Mapper;
import uz.javachi.spring_data_jpa_with_spring_boot.dtos.PostCreateDTO;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

//    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

    Post fromDto(PostCreateDTO dto);
}
