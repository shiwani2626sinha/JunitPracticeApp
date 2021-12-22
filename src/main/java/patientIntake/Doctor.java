package patientIntake;

public enum Doctor {
    avery("Ralph Avery"),
    johnson("Beth Johnson"),
    morphy("Pat Muphy");

    private String name;
    Doctor(String name){this.name = name;}

    public String getName(){return name;}
}
