package uz.javachi.mapstruct.project;

import lombok.*;
import uz.javachi.mapstruct.projectColumn.ProjectColumn;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    private String id;
    private String name;
    private Path docPath;
    private List<ProjectColumn> projectColumnList;
    private LocalDateTime createdAt;
}
