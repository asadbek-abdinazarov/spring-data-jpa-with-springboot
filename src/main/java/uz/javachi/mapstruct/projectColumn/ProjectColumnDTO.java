package uz.javachi.mapstruct.projectColumn;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectColumnDTO {
    private String pc_name;
    private Integer pc_order;
    private String pc_createdAt;
}
