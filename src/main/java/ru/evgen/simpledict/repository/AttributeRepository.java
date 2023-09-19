package ru.evgen.simpledict.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgen.simpledict.model.Attribute;
import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findByDictionaryId(Long postId);

    @Transactional
    void deleteByDictionaryId(long dictionaryId);
}
