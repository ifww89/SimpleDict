package ru.evgen.simpledict.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evgen.simpledict.model.Attribute;
import ru.evgen.simpledict.service.AttributeService;
import ru.evgen.simpledict.service.DictionaryService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AttributeController {

    private final DictionaryService dictionaryService;
    private final AttributeService attributeService;

    public AttributeController(DictionaryService dictionaryService, AttributeService attributeService) {
        this.dictionaryService = dictionaryService;
        this.attributeService = attributeService;
    }

    @GetMapping("/dictionaries/{dictionaryId}/attributes")
    public ResponseEntity<List<Attribute>> getAllAttributesByDictionaryId(@PathVariable(value = "dictionaryId") Long dictionaryId) {
        if (!dictionaryService.existsById(dictionaryId)) {
            throw new EntityNotFoundException("Не найден справочник id = " + dictionaryId);
        }

        List<Attribute> attributes = attributeService.findByDictionaryId(dictionaryId);
        return new ResponseEntity<>(attributes, HttpStatus.OK);
    }

    @GetMapping("/attributes/{id}")
    public ResponseEntity<Attribute> getAttributesByDictionaryId(@PathVariable(value = "id") Long id) {
        Attribute attribute = attributeService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не найден аттрибут id = " + id));

        return new ResponseEntity<>(attribute, HttpStatus.OK);
    }

    @PostMapping("/dictionaries/{dictionaryId}/attributes")
    public ResponseEntity<Attribute> createAttribute(@PathVariable(value = "dictionaryId") Long dictionaryId,
                                                     @RequestBody Attribute attributeRequest) {
        Attribute attribute = dictionaryService.findById(dictionaryId).map(dictionary -> {
            attributeRequest.setDictionary(dictionary);
            return attributeService.save(attributeRequest);
        }).orElseThrow(() -> new EntityNotFoundException("Не найден справочник id = " + dictionaryId));

        return new ResponseEntity<>(attribute, HttpStatus.CREATED);
    }

    @DeleteMapping("/attributes/{id}")
    public ResponseEntity<HttpStatus> deleteAttribute(@PathVariable("id") long id) {
        attributeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/dictionaries/{dictionaryId}/attributes")
    public ResponseEntity<List<Attribute>> deleteAllAttributesOfDictionary(@PathVariable(value = "dictionaryId") Long dictionaryId) {
        if (!dictionaryService.existsById(dictionaryId)) {
            throw new EntityNotFoundException("Не найден справочник id = " + dictionaryId);
        }

        attributeService.deleteByDictionaryId(dictionaryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
