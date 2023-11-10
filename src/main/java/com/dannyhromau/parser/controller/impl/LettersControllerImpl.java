package com.dannyhromau.parser.controller.impl;

import com.dannyhromau.parser.controller.LettersController;
import com.dannyhromau.parser.facade.LettersFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class LettersControllerImpl implements LettersController {
    private final LettersFacade lettersFacade;

    @Override
    public ResponseEntity<String> count(@RequestBody @NonNull String inputString) {
        log.info("call letters count");
        return ResponseEntity.ok(lettersFacade.count(inputString));
    }
}
