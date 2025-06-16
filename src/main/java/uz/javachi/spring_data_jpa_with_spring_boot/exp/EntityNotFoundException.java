package uz.javachi.spring_data_jpa_with_spring_boot.exp;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
