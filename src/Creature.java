public  abstract class Creature {
    protected String name;
    protected String id;


    public Creature(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public abstract boolean equals(Object o);

    public String toString() {
        return "Id: "+ id+ ", Name"+ name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int calculateCaloriesBurned(int activityFactor, int durationInMinutes ){
        return activityFactor*durationInMinutes;
    }



    public abstract int calculateCaloriesBurned ();
}
