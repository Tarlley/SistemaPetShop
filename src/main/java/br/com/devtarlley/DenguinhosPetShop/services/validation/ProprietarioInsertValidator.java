package br.com.devtarlley.DenguinhosPetShop.services.validation;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioNewDto;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import br.com.devtarlley.DenguinhosPetShop.controller.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioInsertValidator implements ConstraintValidator<ProprietarioInsert, ProprietarioNewDto> {
        @Autowired
        private ProprietarioRepository proprietarioRepository;

    @Override
    public void initialize(ProprietarioInsert constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ProprietarioNewDto proprietarioNewDto, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();

        Proprietario aux = proprietarioRepository.findByEmail(proprietarioNewDto.getEmail());
        if (aux != null){
            list.add(new FieldMessage("email","Email já existente"));
        }

        for (FieldMessage e : list) {

            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFildName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}
