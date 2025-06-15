package uz.javachi.spring_data_jpa_with_spring_boot.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

    private String username;
    private String password;

}
