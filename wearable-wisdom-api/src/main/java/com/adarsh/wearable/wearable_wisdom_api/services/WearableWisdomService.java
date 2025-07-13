package com.adarsh.wearable.wearable_wisdom_api.services;

import com.adarsh.wearable.wearable_wisdom_api.dtos.QuoteDTO;
import com.adarsh.wearable.wearable_wisdom_api.entities.Quote;
import com.adarsh.wearable.wearable_wisdom_api.repositories.WearableWisdomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WearableWisdomService {

    private final WearableWisdomRepository wearableWisdomRepository;
    private final ModelMapper modelMapper;

    public WearableWisdomService(WearableWisdomRepository wearableWisdomRepository, ModelMapper modelMapper) {
        this.wearableWisdomRepository = wearableWisdomRepository;
        this.modelMapper = modelMapper;
    }

    public QuoteDTO saveQuote(QuoteDTO quoteDTO) {
        Quote quote = modelMapper.map(quoteDTO, Quote.class);
       Quote saved =  wearableWisdomRepository.save(quote);
       return modelMapper.map(saved, QuoteDTO.class);
    }

    public QuoteDTO getRandomQuote() {
        if(wearableWisdomRepository.count() == 0) throw new RuntimeException("No Quotes in the database");
        Quote quote = wearableWisdomRepository.getRandomQuote();
        return modelMapper.map(quote, QuoteDTO.class);
    }


    public QuoteDTO getDailyQuote() {
        if(wearableWisdomRepository.count() == 0) throw new RuntimeException("No Quotes in the database");
        Quote quote = wearableWisdomRepository.findByIsDailyTrue()
                .orElseGet(wearableWisdomRepository::getRandomQuote);
        return modelMapper.map(quote, QuoteDTO.class);
    }

    public void rotateDailyQuote() {
        wearableWisdomRepository.findByIsDailyTrue().ifPresent(q -> {
            q.setDaily(false);
            wearableWisdomRepository.save(q);
        });
        Quote newDaily = wearableWisdomRepository.getRandomQuote();
        newDaily.setDaily(true);
        wearableWisdomRepository.save(newDaily);
    }

}
