package br.com.devtarlley.DenguinhosPetShop.services.validation;

import br.com.devtarlley.DenguinhosPetShop.dto.PetNewDto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PetInsetValidator implements ConstraintValidator<PetInsert, PetNewDto> {
    @Override
    public void initialize(PetInsert ann) {
    }

    @Override
    public boolean isValid(PetNewDto objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // inclua os testes aqui, inserindo erros na lista

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
