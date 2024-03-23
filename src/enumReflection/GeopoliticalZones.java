package enumReflection;

public enum GeopoliticalZones {

    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"),

    NORTHEAST("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"),

    NORTHWEST("Kaduna", "katsina", "kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),

    SOUTHEAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),

    SOUTH_SOUTH("Akwa-Ibom", "Bayelsa", "Cross-River", "Delta", "Edo", "Rivers"),

    SOUTHWEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo");


    private final String[] states;

    GeopoliticalZones(String... states) {
        this.states = states;
    }


    public  String[] getStates() {
        return states;
    }

}
