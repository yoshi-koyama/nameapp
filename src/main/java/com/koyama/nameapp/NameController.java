package com.koyama.nameapp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {

    private NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/names")
    public List<Name> getNames(@RequestParam String startsWith) {
        List<Name> names = nameService.findNames(startsWith);
        return names;
    }

    @GetMapping("/names/{id}")
    public Name getName(@PathVariable Integer id) {
        Name name = nameService.findNameById(id);
        return name;
    }

    @ExceptionHandler(value = NameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNameNotFoundException(
      NameNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
          "timestamp", ZonedDateTime.now().toString(),
          "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
          "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
          "message", e.getMessage(),
          "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
