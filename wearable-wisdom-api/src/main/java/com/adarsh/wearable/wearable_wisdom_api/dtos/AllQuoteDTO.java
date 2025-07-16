package com.adarsh.wearable.wearable_wisdom_api.dtos;

import com.adarsh.wearable.wearable_wisdom_api.entities.Quote;
import lombok.Data;

import java.util.List;

@Data
public class AllQuoteDTO {
    private int count;
    List<QuoteDTO> data;
}
