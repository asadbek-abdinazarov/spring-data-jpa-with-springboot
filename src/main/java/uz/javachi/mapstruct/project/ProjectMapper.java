package uz.javachi.mapstruct.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import uz.javachi.mapstruct.projectColumn.ProjectColumnMapper;

import java.nio.file.Path;


@Mapper(
        uses = {ProjectColumnMapper.class}
)
public interface ProjectMapper {

    ProjectMapper PROJECT_MAPPER = Mappers.getMapper(ProjectMapper.class);

/*    @Mapping(target = "docPath", qualifiedByName = "pathToString", source = "docPath")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd.MM.yyyy")
    ProjectDTO toDto(Project project);*/

    @Named("pathToString")
    default String pathToString(Path path) {
        return path != null ? path.toString() : null;
    }
}
