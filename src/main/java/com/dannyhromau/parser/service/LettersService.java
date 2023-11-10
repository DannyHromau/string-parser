package com.dannyhromau.parser.service;

import com.dannyhromau.parser.core.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public interface LettersService extends BaseService {
    @Override
    String count(String inputString);
}
