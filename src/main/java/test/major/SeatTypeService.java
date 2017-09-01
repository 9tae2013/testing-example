package test.major;

import test.major.domain.SeatType;

import java.util.ArrayList;
import java.util.List;

public class SeatTypeService {
    private List<SeatType> seatTypes;

    public SeatTypeService() {
        seatTypes = new ArrayList<>();
        seatTypes.add(new SeatType("Normal", 600));
        seatTypes.add(new SeatType("Honeymoon", 1200));
    }

    public SeatType getSeatTypes(String type) {
        throw new UnsupportedOperationException("Not implement yet");
    }
}
