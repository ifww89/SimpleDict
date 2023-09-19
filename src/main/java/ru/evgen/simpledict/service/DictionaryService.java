package ru.evgen.simpledict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evgen.simpledict.model.Dictionary;
import ru.evgen.simpledict.repository.DictionaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }

    public Optional<Dictionary> findById(long id) {
        return dictionaryRepository.findById(id);
    }

    public Dictionary save(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    public void deleteAll() {
        dictionaryRepository.deleteAll();
    }

    public void deleteById(long id) {
        dictionaryRepository.deleteById(id);
    }

    public boolean existsById(Long tutorialId) {
        return dictionaryRepository.existsById(tutorialId);
    }
}
