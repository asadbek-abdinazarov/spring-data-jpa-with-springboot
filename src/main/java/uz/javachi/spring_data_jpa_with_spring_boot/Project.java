package uz.javachi.spring_data_jpa_with_spring_boot;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "code_project_ix", columnNames = {"code"})
})
@NamedQueries({
        @NamedQuery(name = "Project.findByNameIgnoreCaseOrderByIdDesc", query = "select p from Project p where upper(p.name) = upper(:name) order by p.id DESC")
})
@Getter
@Setter
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "code cannot be blank")
    @Column(name = "code")
    private String code;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectColumn> projectColumns = new ArrayList<>();

}
