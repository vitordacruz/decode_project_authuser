package com.ead.authuser.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class InstructorDto {
    @NotNull
    private UUID userId;
}
