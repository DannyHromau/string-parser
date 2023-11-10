package com.dannyhromau.parser.facade;

import com.dannyhromau.parser.core.base.BaseFacade;
import org.springframework.stereotype.Component;

@Component
public interface LettersFacade extends BaseFacade<String> {
    @Override
    String count(String inputString);
}
