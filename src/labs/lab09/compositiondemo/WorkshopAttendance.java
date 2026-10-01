package labs.lab09.compositiondemo;
public class WorkshopAttendance extends DeliveryMethod {
    private final String room;
    public WorkshopAttendance(String room) {
        if (room == null || room.isBlank()) throw new IllegalArgumentException("Room required");
        this.room = room;
    }
    @Override public String instructions() { return "Attend in " + room; }
}
