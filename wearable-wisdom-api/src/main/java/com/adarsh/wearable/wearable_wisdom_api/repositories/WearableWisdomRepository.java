package com.adarsh.wearable.wearable_wisdom_api.repositories;

import com.adarsh.wearable.wearable_wisdom_api.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WearableWisdomRepository extends JpaRepository<Quote, Long> {
    @Query(value = "SELECT * FROM quote ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Quote getRandomQuote();

    Optional<Quote> findByIsDailyTrue();

}
