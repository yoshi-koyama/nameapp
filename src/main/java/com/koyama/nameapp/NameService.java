package com.koyama.nameapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {

    private NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findNames(String startsWith) {
        return nameMapper.findByNameStartingWith(startsWith);
    }
}
