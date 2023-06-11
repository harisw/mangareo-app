package com.harisw.mangareo.authenticationservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenRequest {
    @NotBlank
    private String JwtToken;
}
