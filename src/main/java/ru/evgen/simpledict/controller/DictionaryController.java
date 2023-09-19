package ru.evgen.simpledict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evgen.simpledict.model.Dictionary;
import ru.evgen.simpledict.service.DictionaryService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DictionaryController {
    final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionaries")
    public ResponseEntity<List<Dictionary>> getAllDictionaries() {
        try {
            List<Dictionary> dictionaries = dictionaryService.findAll();
            if (dictionaries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dictionaries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dictionaries/{id}")
    public ResponseEntity<Dictionary> getDictionaryById(@PathVariable("id") long id) {
        Optional<Dictionary> dictionaryData = dictionaryService.findById(id);

        if (dictionaryData.isPresent()) {
            return new ResponseEntity<>(dictionaryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dictionaries")
    public ResponseEntity<Dictionary> createDictionary(@RequestBody Dictionary dictionary) {
        try {
            Dictionary _dictionary = dictionaryService
                    .save(dictionary);
            return new ResponseEntity<>(_dictionary, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dictionaries")
    public ResponseEntity<HttpStatus> deleteAllDictionaries() {
        try {
            dictionaryService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dictionaries/{id}")
    public ResponseEntity<HttpStatus> deleteDictionary(@PathVariable("id") long id) {
        try {
            dictionaryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
