package com.anuj.cards.service;

import com.anuj.cards.dto.CardsDto;

public interface ICardsService {
    /**
     * Create card for a customer
     * @param mobileNumber - Mobile Number of the customer
     */
    void createCard(String mobileNumber);

    /**
     * Fetch card details based on mobile number
     * @param mobileNumber - Mobile Number of the customer
     * @return Card details of the customer
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     * Update card details based on card number
     * @param cardsDto - CardsDto object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     * Delete card details based on mobile number
     * @param mobileNumber - Mobile Number of the customer
     * @return boolean indicating if the delete of card details is successful or not
     */
    boolean deleteCard(String mobileNumber);
}
