package br.com.devtarlley.DenguinhosPetShop.services.exceptions.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FieldMessage {

    private String fildName;
    private String message;

}
