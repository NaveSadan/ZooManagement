import java.util.ArrayList;

public class ZooManagement {
    private ArrayList<Animal> animals;
    private ArrayList<Visitor>visitors;
    private ArrayList<ZooKeeper>zooKeepers;
    private ArrayList<ZooManager>zooManagers;


    //C'trs
    public ZooManagement(){
        setAnimals(new ArrayList<>());
        setVisitors(new ArrayList<>());
        setZooKeepers(new ArrayList<>());
        setZooManagers(new ArrayList<>());
    }

    // Get's & Set's
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public ArrayList<ZooKeeper> getZooKeepers() {
        return zooKeepers;
    }
    public void setZooKeepers(ArrayList<ZooKeeper> zooKeepers) {
        this.zooKeepers = zooKeepers;
    }

    public ArrayList<ZooManager> getZooManagers() {
        return zooManagers;
    }
    public void setZooManagers(ArrayList<ZooManager> zooManagers) {
        this.zooManagers = zooManagers;
    }


    //Methods:
    public void printAllVisitorsDetails(){ // פונקציה שמדפיסה רשימת מבקרים אם קיימים
        System.out.println("List of visitors: ");
        if (visitors.isEmpty())
            System.out.println("No visitors");
        else
            for(Visitor visitor:visitors){
                System.out.println(visitor);
            }
    }
 
    public boolean addAnimal(Animal a) {
        for (Animal animal:animals)
            if(animal.getId().equalsIgnoreCase(a.getId()))
                return false;
        animals.add(a);
        return true;
    }

    public boolean addZooManagerWithComplexEmailValidation(ZooManager zm) {
        for (ZooManager zooManager : zooManagers) {
            if (zooManager.getId().equals(zm.getId()))
                if (zm.getEmailM().length() > 10)
                    if (!zm.getEmailM().substring(zm.getEmailM().length() - 4, zm.getEmailM().length() - 1).equals("@ZOO"))
                        System.out.println("fault");
            return false;
        }
        if (zm.getEmailM().length() > 10)
            return false;
        if (!zm.getEmailM().substring(zm.getEmailM().length() - 4, zm.getEmailM().length() - 1).equals("@ZOO"))
            return false;
        zooManagers.add(zm);
        return true;
    }


    public void assignShiftsBasedOnVisitorCount () {
        if (visitors.size() > 100)
            for (ZooKeeper zooKeeper : zooKeepers) // לעבור על כל שומר ולעדכן
                if (!zooKeeper.getShift().equals("Night"))
                    zooKeeper.changeShift("Night");
        else
            for (ZooKeeper zooKeeper2 : zooKeepers)
                zooKeeper2.changeShift("Morning");
    }

    public void checkFoodExpertise () {
        String str = "missing expertise:\n";
        for (Animal animal:animals) {
            String foodType=animal.getFoodType().getFoodName();
            int cnt=0;
            for (ZooKeeper zooKeeper : zooKeepers)
                if (foodType.equalsIgnoreCase(zooKeeper.getFoodExpert()))
                    cnt++;
            if(cnt==0&&!str.contains(foodType))
                str+=foodType+"\n";

        }
        System.out.println(str);
    }

    public void addZooKeeper(ZooKeeper zooKeeper){
        zooKeepers.add(zooKeeper);
    }

    public void addVisitor(Visitor visitor){
        visitors.add(visitor);
    }

}



