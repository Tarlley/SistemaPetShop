package br.com.devtarlley.DenguinhosPetShop.services.validation;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.repository.ProprietarioRepository;
import br.com.devtarlley.DenguinhosPetShop.controller.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProprietarioUpdateValidator implements ConstraintValidator<ProprietarioUpdate, ProprietarioDto> {
        @Autowired
        private HttpServletRequest request;


        @Autowired
        private ProprietarioRepository proprietarioRepository;

    @Override
    public void initialize(ProprietarioUpdate constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }




    @Override
    public boolean isValid(ProprietarioDto proprietarioDto, ConstraintValidatorContext constraintValidatorContext) {
       @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Proprietario aux = proprietarioRepository.findByEmail(proprietarioDto.getEmail());
        if (aux != null && !aux.getId().equals(uriId)){
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
