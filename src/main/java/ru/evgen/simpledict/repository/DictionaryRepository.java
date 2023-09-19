package ru.evgen.simpledict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgen.simpledict.model.Dictionary;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
}