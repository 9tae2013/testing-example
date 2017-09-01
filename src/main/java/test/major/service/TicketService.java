package test.major.service;

import test.major.domain.SelectedSeat;

import java.util.List;

public class TicketService {
    private CardService cardService;

    public TicketService(CardService cardService) {
        this.cardService = cardService;
    }

    public int calculateTotalPoint(List<SelectedSeat> selectedSeats) {
        int total = 0;
        for (SelectedSeat selectedSeat : selectedSeats) {
            total += selectedSeat.getCount() * selectedSeat.getSeatType().getUsePoint();
        }

        if (total < cardService.getPoint(1)) {
            return total;
        } else {
            return -1;
        }

    }
}
