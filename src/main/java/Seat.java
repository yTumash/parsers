import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Seat {

    public Type type;
    private Integer seatPitch;
    private Integer width;
    private Integer seatRows;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getSeatPitch() {
        return seatPitch;
    }

    public void setSeatPitch(Integer seatPitch) {
        this.seatPitch = seatPitch;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Type {
        ECONOMY("economy"),
        PREMIUM_ECONOMY("premium economy"),
        BUSINESS("business"),
        FIRST_CLASS("first class");

        private String t;

        Type(String t) {
            this.t = t;
        }

        public static Type takeSeat(String t) {
            for (Type type : Type.values()) {
                if (type.getType().equals(t)) {
                    return type;
                }
            }
            return null;
        }

        public String getType() {
            return t;
        }

        public void setType(String t) {
            this.t = t;
        }
    }
}

