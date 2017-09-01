package test.major.domain;

public class SeatType {
    private String typeName;
    private int usePoint;

    public SeatType(String typeName, int usePoint) {
        this.typeName = typeName;
        this.usePoint = usePoint;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getUsePoint() {
        return usePoint;
    }
}
