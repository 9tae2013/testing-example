package test.major.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.major.domain.SeatType;
import test.major.domain.SelectedSeat;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@RunWith(JUnitParamsRunner.class)
public class TicketServiceTest {
    @InjectMocks
    TicketService ticketService;
    @Mock
    CardService cardService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Parameters({
            "1, 1, 4000",
            "2, 3, 11000"
    })
    public void returnZero_whenNotSelectSeat(int normal, int honeymoon, int expectedTotal) {
        //arrange
        List<SelectedSeat> selectedSeats = createSelectedSeat(normal, honeymoon);
        when(cardService.getPoint(anyInt())).thenReturn(1000000000);
        //act
        int totalPoint = ticketService.calculateTotalPoint(selectedSeats);
        //assert
        assertThat(totalPoint, equalTo(expectedTotal));
    }

    private List<SelectedSeat> createSelectedSeat(Integer normal, Integer honeymoon) {

        List<SelectedSeat> selectedSeats = new ArrayList<>();
        if (normal != null) {
            SelectedSeat normalSeat = new SelectedSeat(
                    new SeatType("Normal", 1_000),
                    normal);
            selectedSeats.add(normalSeat);
        }

        if (honeymoon != null) {
            SelectedSeat honeymoonSeat = new SelectedSeat(
                    new SeatType("Honeymoon", 3_000),
                    honeymoon);
            selectedSeats.add(honeymoonSeat);
        }
        return selectedSeats;
    }
}