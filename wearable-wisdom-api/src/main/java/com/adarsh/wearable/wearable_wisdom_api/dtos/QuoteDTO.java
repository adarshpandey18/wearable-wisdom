package com.adarsh.wearable.wearable_wisdom_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDTO  {
    @NotBlank(message = "Quote is required")
    private String quote;

    @NotBlank(message = "Author is required")
    private String author;
}
