package uz.javachi.mapstruct.project;

import org.junit.jupiter.api.Test;
import uz.javachi.mapstruct.projectColumn.ProjectColumn;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static uz.javachi.mapstruct.project.ProjectMapper.PROJECT_MAPPER;

class ProjectMapperTest {

/*    @Test
    void toDto() {
        Project project = new Project("1", "TODO APP", Path.of("https://online_pdp.uz"), null, null);
        System.out.println(PROJECT_MAPPER.toDto(project));


    }

    @Test
    void toDtoWithProjectColumn() {
        Project project = new Project("2", "TODO APP", Path.of("https://online_pdp.uz"), List.of(
                new ProjectColumn("1", "Test", 1, LocalDateTime.now()),
                new ProjectColumn("2", "Test2", 2, LocalDateTime.now()),
                new ProjectColumn("3", "Test3", 3, LocalDateTime.now()),
                new ProjectColumn("4", "Test4", 4, LocalDateTime.now())
        ), LocalDateTime.now());
        System.out.println(PROJECT_MAPPER.toDto(project));
    }*/
}