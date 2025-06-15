package uz.javachi.spring_data_jpa_with_spring_boot.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hi")
    public String sayHi() {

        SecurityContext context = SecurityContextHolder.getContext();
        User u = (User) context.getAuthentication().getPrincipal();
        StringBuilder sb = new StringBuilder();
        u.getAuthorities().forEach((s) -> sb.append(s).append(","));

        return "Hi there " + u.getUsername() + " " + sb;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String manager(){
        return "manager";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public String user(){
        return "User";
    }

}
