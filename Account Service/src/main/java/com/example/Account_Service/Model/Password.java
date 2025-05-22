package com.example.Account_Service.Model;

import com.example.Account_Service.Validation.NotBreached;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Password {
    @JsonProperty("new_password")
    @NotBlank
    @NotBreached
    @Size(min = 12)
    String password;
}
