package uz.javachi.spring_data_jpa_with_spring_boot.controllers;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javachi.spring_data_jpa_with_spring_boot.criterias.TodoCriteria;
import uz.javachi.spring_data_jpa_with_spring_boot.exp.EntityNotFoundException;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Todo;
import uz.javachi.spring_data_jpa_with_spring_boot.repositories.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Tag(
        name = "Todo Controller",
        description = "This is api collection referenced to Todos",
        externalDocs = @ExternalDocumentation(
                description = "This is test",
                url = "http:localhost:8081"
        )
)
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Operation(
            summary = "This is for get one todo", description = "This is description"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Todo.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))
            })
    })
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo Not Found With ID: " + id));
        return ResponseEntity.ok(todo);
    }

    @Operation(description = "Get all todos")
    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodo(TodoCriteria todoCriteria) {
        System.out.println(todoCriteria);
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    @Operation(deprecated = true, description = "Tis ")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }
}
