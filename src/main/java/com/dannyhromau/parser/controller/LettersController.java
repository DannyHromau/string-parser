package com.dannyhromau.parser.controller;

import com.dannyhromau.parser.core.base.BaseController;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/v1/letters")
@Tag(name = "Letters service", description = "Letters controller")
@ApiResponse(responseCode = "200", description = "Successful operation")
@ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
@ApiResponse(responseCode = "404", description = "Not found")
public interface LettersController extends BaseController<String> {
    @Override
    ResponseEntity<String> count(@RequestBody @NonNull String inputString);
}
