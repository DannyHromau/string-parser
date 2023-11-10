package com.dannyhromau.parser.service.impl;

import com.dannyhromau.parser.core.config.ErrorMessages;
import com.dannyhromau.parser.exception.InvalidInputDataException;
import com.dannyhromau.parser.service.LettersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LettersServiceImpl implements LettersService {
    @Value("${string_length.min}")
    private int minInputLength;
    @Value("${string_length.max}")
    private int maxInputLength;

    @Override
    public String count(String inputString) {
        checkInputValidity(inputString);
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> outputMap = new LinkedHashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            outputMap.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
        }
        outputMap = outputMap.entrySet().stream()
                .sorted(Map.Entry
                        .comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Character, Integer> entry : outputMap.entrySet()) {
            builder.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue()).append(", ");
        }
        return builder.substring(0, builder.toString().lastIndexOf(','));
    }

    void checkInputValidity(String input) {
        if (input.length() < minInputLength) {
            throw new InvalidInputDataException(ErrorMessages.TOO_SHORT_DATA_MESSAGE.label);
        }
        if (input.length() > maxInputLength) {
            throw new InvalidInputDataException(ErrorMessages.TOO_LONG_DATA_MESSAGE.label);
        }
    }
}
