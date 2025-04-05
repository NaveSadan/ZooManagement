import java.util.Date;

public class Visitor extends Creature {
    private Date visitDate;

    // c'tors
    public Visitor (String name, String id) {
        super(name, id);
        setVisitDate(new Date(100,2,1)); // פורמט ההשמה
    }
    public Visitor (String name, String id, Date visitDate) {
        super (name, id);
        setVisitDate(visitDate);
    }

    // Get's & Set's
    @Override
    public void setName (String name) {
        if (name.length() < 10)
            this.name = name;
        else
            this.name= "Visitor";
    }

    @Override
    public void setId (String id) {
        int cnt = 0; //פתיחת קאונטר
        // פתיחת התנאי ( אורך ומספרים בלבד) ע״י לולאה
        if (id.length() == 9) {
            for (int i=0; i<id.length(); i++) {
                if (id.charAt(i) >= '0' && id.charAt(i) <= '9')
                    cnt ++;
            }
        }
        if (cnt == 9)
            setId(id);
        else
            this.id = "000000000"; // ערך דיפולט
    }

    public Date getVisitDate () {
        return visitDate;
    }

    public void setVisitDate (Date visitDate) {
        this.visitDate = visitDate;
    }

    // Methods
    @Override
    public String toString() {
        return "Visitor; "+super.toString()+ "Visit Date: "+ visitDate;
    }

    // מתודת השוואה ע״י כלל התכונות
    @Override
    public boolean equals (Object o) {
        if (o != null && o instanceof Visitor)
            if (((Visitor)o).name.equals(this.name))
                if (((Visitor) o).id.equals(this.id))
                    if (((Visitor) o).visitDate.equals(this.visitDate))
                        return true;
        return false;
    }

    public int calculateCaloriesBurned() {
        return 2*500;
    }

}
