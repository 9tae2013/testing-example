package test.major.domain;

public class SelectedSeat {
    private SeatType seatType;
    private int count;

    public SelectedSeat(SeatType seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getCount() {
        return count;
    }
}
