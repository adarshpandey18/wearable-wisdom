package com.adarsh.wearable.wearable_wisdom_api.controllers;

import com.adarsh.wearable.wearable_wisdom_api.dtos.AllQuoteDTO;
import com.adarsh.wearable.wearable_wisdom_api.dtos.QuoteDTO;
import com.adarsh.wearable.wearable_wisdom_api.entities.Quote;
import com.adarsh.wearable.wearable_wisdom_api.services.WearableWisdomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/wearable-wisdom/api")
public class WearableWisdomController {

    private final WearableWisdomService wearableWisdomService;

    public WearableWisdomController(WearableWisdomService wearableWisdomService) {
        this.wearableWisdomService = wearableWisdomService;
    }

    @PostMapping("/post")
    public ResponseEntity<QuoteDTO> saveQuote(@Valid @RequestBody QuoteDTO quoteDTO) {
       QuoteDTO saved =  wearableWisdomService.saveQuote(quoteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDTO> getRandomQuote() {
        QuoteDTO quoteDTO = wearableWisdomService.getRandomQuote();
        return ResponseEntity.ok(quoteDTO);
    }

    @GetMapping("/daily")
    public ResponseEntity<QuoteDTO> getDailyQuote() {
        QuoteDTO quoteDTO = wearableWisdomService.getDailyQuote();
        return ResponseEntity.ok(quoteDTO);
    }

    @GetMapping("/allQuotes")
    public ResponseEntity<AllQuoteDTO> getAllQuotes() {
        List<QuoteDTO> quoteDTOList = wearableWisdomService.getAllQuotes();
        AllQuoteDTO allQuoteDTO = new AllQuoteDTO();
        allQuoteDTO.setCount(quoteDTOList.size());
        allQuoteDTO.setData(quoteDTOList);

        return ResponseEntity.ok(allQuoteDTO);
    }
}
