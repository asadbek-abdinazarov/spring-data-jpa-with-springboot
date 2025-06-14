package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<ProjectDto> getAll() {
        List<Project> allProjects = projectRepository.findAll();
        return projectMapper.toDto(allProjects);
    }

    @PostMapping
    public Project create(@RequestBody ProjectDto projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        project.setCode(project.getName().replace(" ", "_").toUpperCase());
        return projectRepository.save(project);
    }
}


