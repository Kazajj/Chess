package chess.chess.model;

public enum PiecesEnum {
    PEDONE(1, "pedone"),
    CAVALLO(2, "cavallo"),
    ALFIERE(3, "alfiere"),
    TORRE(4, "torre"),
    REGINA(5, "regina"),
    RE(6, "re");

    private final int intValue;
    private final String stringValue;

    PiecesEnum(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

