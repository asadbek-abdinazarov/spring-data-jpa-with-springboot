package uz.javachi.spring_data_jpa_with_spring_boot.auditing;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/all")
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @PostMapping("/save")
    public ToDo save(@RequestBody ToDo toDo) {
        return toDoRepository.save(toDo);
    }


    @PutMapping("/update")
    public ToDo update(@RequestBody ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @DeleteMapping("/delete")
    public void delete() {
        toDoRepository.deleteAll();
    }
}

