package uz.javachi.spring_data_jpa_with_spring_boot.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto implements Serializable {
    private String errorURI;
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime localDateTime;

    public ErrorDto(String errorURI, String errorMessage, Integer errorCode) {
        this.errorURI = errorURI;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.localDateTime = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    }
}
