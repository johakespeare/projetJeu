package Armes;

public enum Portee {
    COURTE(5),
    MOYENNE(15),
    LONGUE(30);

    public int distance;

    Portee(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}