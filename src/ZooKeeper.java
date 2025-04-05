public class ZooKeeper extends Creature implements Matchable{

    private double salary;
    private String shift;
    private String address;
    private String foodExpert;
    private String compatibleWithAnimal;

    //c'tors
    ZooKeeper(String name, String id) {
        super(name,id);
        setSalary(2500);
        setShift("Night");
        setAddress("zoo22@wildlife.com");
        setFoodExpert("Default Food");
        setCompatibleWithAnimal(null);
    }

    ZooKeeper (String name, String id, double salary, String shift, String address, String foodExpert
    , String compatibleWithAnimal ) {
        super(name, id);
        setSalary(salary);
        setShift(shift);
        setAddress(address);
        setFoodExpert(foodExpert);
        setCompatibleWithAnimal(compatibleWithAnimal);
    }


    // Gets &  Set's
    @Override
    public void setName (String name) {
        if (name.length() <=10)
            this.name = name;
        else
            this.name = "ZooKeeper";
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
            this.id = id;
        else
            this.id = "000000000"; // ערך דיפולט
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary >= 5000 && salary <= 15000)
            this.salary = salary;
        else
            this.salary = 2500;
    }

    public String getShift() {
        return shift;
    }
    public void setShift(String shift) {
        if (shift.equals("Morning") || shift.equals("Noon") || shift.equals("Night"))
            this.shift = shift;
        else
            this.shift = "Night";
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoodExpert() {
        return foodExpert;
    }
    public void setFoodExpert(String foodExpert) {
        this.foodExpert = foodExpert;
    }

    public String getCompatibleWithAnimal() {
        return compatibleWithAnimal;
    }

    public void setCompatibleWithAnimal(String compatibleWithAnimal) {
        this.compatibleWithAnimal = compatibleWithAnimal;
    }

    //Methods
    @Override
    public String toString () {
        return "ZooKeeper; "+super.toString()+", Salary= "+ salary+ ", Shift= "+ shift+
                ", Address= "+ address+ ", Food Expert= "+ foodExpert;
    }

    public void changeShift(String newShift) {
        setShift(newShift);
    }

    public boolean equals(Object o) {
        if((o!=null)&&(o instanceof ZooKeeper)) {
            if (((ZooKeeper)o).name.equals(this.name)) {
                if (((ZooKeeper)o).id.equals(this.id)) {
                    if (((ZooKeeper)o).shift.equals(this.shift)) {
                        if (((ZooKeeper)o).address.equals(this.shift)) {
                            if (((ZooKeeper)o).foodExpert.equals(this.foodExpert)) {
                                if (((ZooKeeper)o).salary == this.salary)
                                    return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int calculateCaloriesBurned() {
        return 7*2500;
    }

    @Override
    public boolean match(Object o){
        return (o!=null)&&(o instanceof Animal)&&
                compatibleWithAnimal.equalsIgnoreCase(((Animal)o).getName())&&
                (((Animal)o).getCompatibleWithHuman().equalsIgnoreCase(name));
    }
}
