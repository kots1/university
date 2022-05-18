package com.test.university.model.converter;

import com.test.university.model.Degree;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DegreeConverter implements AttributeConverter<Degree, String> {
    @Override
    public String convertToDatabaseColumn(Degree degree) {
        if (degree == null) {
            return null;
        }
        return degree.getName();
    }

    @Override
    public Degree convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(Degree.values())
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
