package uz.javachi.spring_data_jpa_with_spring_boot;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectDto projectDTO);

    ProjectDto toDto(Project project);

    List<ProjectDto> toDto(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDto projectDTO, @MappingTarget Project project);
}