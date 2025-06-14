package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SessionUser {

    public Long getId(){
        return new Random().nextLong(1,100);
    }

}
