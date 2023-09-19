package ru.evgen.simpledict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evgen.simpledict.model.*;
import ru.evgen.simpledict.service.AttributeService;
import ru.evgen.simpledict.service.DictionaryService;

@Service
public class DatabaseUtils {

    final DictionaryService dictionaryService;
    final AttributeService attributeService;

    public DatabaseUtils(DictionaryService dictionaryService, AttributeService attributeService) {
        this.dictionaryService = dictionaryService;
        this.attributeService = attributeService;
    }

    public void fillDatabase() {
        Dictionary dictionary1 = dictionaryService.save(new Dictionary("Справочник 1"));
        Dictionary dictionary2 = dictionaryService.save(new Dictionary("Справочник 2"));
        attributeService.save(new Attribute(dictionary1, DataType.STRING, "Имя1", "Значение1"));
        attributeService.save(new Attribute(dictionary1, DataType.STRING, "Имя2", "Значение2"));
        attributeService.save(new Attribute(dictionary1, DataType.STRING, "Имя3", "Значение3"));
    }
}
