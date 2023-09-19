package ru.evgen.simpledict.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    private String val;

    @Enumerated(EnumType.ORDINAL)
    private DataType dataType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dictionary_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Dictionary dictionary;

    public Attribute() {

    }
    public Attribute(Dictionary dictionary, DataType dataType, String name, String val) {
        this.dataType = dataType;
        this.name = name;
        this.val = val;
        this.dictionary = dictionary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String content) {
        this.val = content;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
