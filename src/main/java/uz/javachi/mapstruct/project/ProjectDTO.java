package uz.javachi.mapstruct.project;

import lombok.*;
import uz.javachi.mapstruct.projectColumn.ProjectColumnDTO;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
    private String id;
    private String name;
    private String docPath;
    private List<ProjectColumnDTO> projectColumnList;
    private String createdAt;
}
