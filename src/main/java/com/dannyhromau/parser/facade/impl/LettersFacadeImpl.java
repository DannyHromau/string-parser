package com.dannyhromau.parser.facade.impl;

import com.dannyhromau.parser.facade.LettersFacade;
import com.dannyhromau.parser.service.LettersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettersFacadeImpl implements LettersFacade {

    private final LettersService lettersService;

    @Override
    public String count(String inputString) {
        return lettersService.count(inputString);
    }
}
