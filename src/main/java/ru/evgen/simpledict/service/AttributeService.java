package ru.evgen.simpledict.service;

import org.springframework.stereotype.Service;
import ru.evgen.simpledict.model.Attribute;
import ru.evgen.simpledict.repository.AttributeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {

    final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    public Optional<Attribute> findById(long id) {
        return attributeRepository.findById(id);
    }

    public Attribute save(Attribute attribute) {
        validate(attribute);
        return attributeRepository.save(attribute);
    }

    public void deleteById(long id) {
        attributeRepository.deleteById(id);
    }

    public List<Attribute> findByDictionaryId(Long dictionaryId) {
        return attributeRepository.findByDictionaryId(dictionaryId);
    }

    public void deleteByDictionaryId(Long dictionaryId) {
        attributeRepository.deleteByDictionaryId(dictionaryId);
    }

    //todo: реализовать проверку на корректное соотношение типа данных и значения
    private boolean validate(Attribute attribute) {
        return true;
//        throw new RuntimeException("Значение не соответствует типу данных для поля: " + attribute.getName());
    }
}
