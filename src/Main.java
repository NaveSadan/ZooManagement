import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        // *** יצירת אובייקטים ותאריכים ***
        Date expirationDateCarnivore = new Date(2005-1900, 8, 24);
        Date expirationDateHerbivore = new Date(2013-1900, 3, 15);

        Date bDAteElephant = new Date(2020-1900, 2, 5);
        Date bDAteLion = new Date(2009-1900, 8, 27);
        Date bDAteZebra = new Date(2004-1900, 2, 17);
        Date bDAteHorse = new Date(1995-1900, 8, 23);

        System.out.println("try create FoodType :");

        FoodType herbivoreFood = new FoodType("Herbivore", 7, 7, expirationDateHerbivore);
        System.out.println(herbivoreFood.toString());
        FoodType carnivoreFood = new FoodType("Carnivore", 6, 3, expirationDateCarnivore);
        System.out.println(carnivoreFood.toString());
        FoodType horseFood = new FoodType("grassFood", 9, 6, expirationDateCarnivore);
        System.out.println(carnivoreFood.toString());


        System.out.println("\ntry create Animals");
        Animal elephant = new Animal("elephant6756545", "LP231", "Male", true, herbivoreFood, bDAteLion,"Elephants' cage","John");
        System.out.println(elephant.toString());
        Animal lion = new Animal("Lion79776756545", "L1231", "Male", true, carnivoreFood, bDAteLion,"Lions' cage","Jery Smith");
        System.out.println(lion.toString());
        Animal zebra = new Animal("NewZebraSpotnik", "CD123", "Male", false, carnivoreFood, bDAteZebra,"Zebras' cage","jane");
        System.out.println(zebra.toString());
        Animal horse = new Animal("NewHorshSpotnik", "HR123", "Male", true, horseFood, bDAteHorse,"Horses' cage","John");
        System.out.println(horse.toString());

        System.out.println("\ntry create zookeeper :");
        ZooKeeper zookeeperJohn = new ZooKeeper("John Domin", "432435123", 8000, "Morning", "Zoo123", "Carnivore","NewHorshSpotnik");
        System.out.println(zookeeperJohn.toString());
        ZooKeeper zookeeperJane = new ZooKeeper("Jane Smith", "344534564", 7800, "Night", "Zoo456", "Herbivore","NewZebraSpotnik");
        System.out.println(zookeeperJane.toString());
        ZooKeeper zookeeperJerry = new ZooKeeper("Jery Smith", "645612455", 9000, "Night", "Zoo456", "Herbivore","Lion79776756545");
        System.out.println(zookeeperJerry.toString());



        ArrayList<ZooKeeper> zookeepersForSarah = new ArrayList<>();
        zookeepersForSarah.add(zookeeperJohn);
        zookeepersForSarah.add(zookeeperJane);
        zookeepersForSarah.add(zookeeperJerry);



        // *** יצירת מנהלי גן חיות ***
        ZooManager zooManagerSarah = new ZooManager("Sarah", "M123", "Main Street", "newSara345943@.com", zookeepersForSarah);
        ZooManager zooManagerMike = new ZooManager("Mike", "M456", "Broadway", "mike@zoo.com", new ArrayList<>());

        // *** ניהול גן חיות ***
        ZooManagement zooManagement = new ZooManagement();


        zooManagement.addAnimal(elephant);
        zooManagement.addAnimal(lion);
        zooManagement.addAnimal(zebra);
        zooManagement.addAnimal(horse);

        zooManagement.addZooKeeper(zookeeperJerry);
        zooManagement.addZooKeeper( zookeeperJohn);


        // *** הוספת מנהלי גן חיות עם בדיקות אימות כתובת דוא"ל ***
        System.out.println("\nAdding Zoo Managers with email validation:");
        boolean addedSarah = zooManagement.addZooManagerWithComplexEmailValidation(zooManagerSarah);
        System.out.println("Sarah added: " + addedSarah);

        boolean addedMike = zooManagement.addZooManagerWithComplexEmailValidation(zooManagerMike);
        System.out.println("Mike added: " + addedMike);

        // *** הוספת מבקרים ***
        Visitor visitorAlice = new Visitor("Alice", "V001", new Date(2024 - 1900, 8, 25));
        Visitor visitorBob = new Visitor("Bob", "V002", new Date(2024 - 1900, 8, 26));
        zooManagement.addVisitor(visitorAlice);
        zooManagement.addVisitor(visitorBob);





        // *** ZooManager הצגת פרטי  ***
        System.out.println("\nDisplaying Zoo Managers:");
        System.out.println(zookeeperJerry.toString());

        // *** שינוי משמרות לפי כמות מבקרים ***
        System.out.println("\nChanging shifts based on visitor count:");
        zooManagement.assignShiftsBasedOnVisitorCount();
        for (ZooKeeper zk : zookeepersForSarah) {
            System.out.println(zk.toString());
        }

        // *** בדיקת התמחות מזון ***
        System.out.println("\nChecking food expertise:");
        zooManagement.checkFoodExpertise();

        // *** שינוי כתובת מנהל גן החיות ***
        System.out.println("\nChanging address for Zoo Manager Mike:");
        zooManagerMike.changeAddress("New Address");
        System.out.println(zooManagerMike.toString());

        // *** בדיקה אם החיות סובלות מאובדן ***
        System.out.println("\nChecking if animals are suffering from extinction:");
        System.out.println("Lion extinction check: " + lion.checkExt(new Date(2000-1900, 8, 24)));
        System.out.println("Elephant extinction check: " + elephant.checkExt(new Date()));

        // בדיקת הפונקציונליות האחרונה שהתווספה (Match)
        System.out.println();
        System.out.println("does lion match jery? "+lion.match(zookeeperJerry));
        System.out.println("does zebra match jane? "+zebra.match(zookeeperJane));
        System.out.println("does horse match jhon? "+horse.match(zookeeperJohn));

        //בדיקת הפונקציה move
        System.out.println();
        System.out.println("move horse to elaphants' cage");
        horse.move("Elephants' cage");
        System.out.println("horse new area is: "+horse.getArea());

        //בדיקת הפונקציה שריפת קלוריות
        System.out.println();
        System.out.println("zookeeper jerry burnt in default day - "+zookeeperJerry.calculateCaloriesBurned()+" calories");
        System.out.println("elephant today ran for 100 minutes so it burnt - "+elephant.calculateCaloriesBurned(4,100)+" calories");
        System.out.println("visitor bob burnt in default day - "+visitorBob.calculateCaloriesBurned()+" calories");
        System.out.println("zoo manager mike worked today 500 minutes so he burnt only - "+zooManagerMike.calculateCaloriesBurned(5,500)+" calories");





    }
}




