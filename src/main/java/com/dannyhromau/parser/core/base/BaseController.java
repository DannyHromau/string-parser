package com.dannyhromau.parser.core.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<T> {
    @PostMapping("/count")
    ResponseEntity<String> count(@RequestBody T input);
}
