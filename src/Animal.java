import java.util.Date;

public class Animal extends Creature implements Matchable{
    private String gender;
    private boolean extinction;
    private FoodType foodType;
    private Date bDate;
    private String area;
    private String compatibleWithHuman;



    //בנאי ברירת מחדל
    public Animal(){
        this("Animal","AB123","male",false,new FoodType("Default food",
                1,3,new Date()),new Date(0,0,1),"default cage"
        , null);
    }

    //בנאי שלם
    public Animal(String name,String id,String gender,boolean extinction,
                  FoodType foodType,Date bDate, String area, String compatibleWithHuman){
        super(name,id);
        setGender(gender);
        setExtinction(extinction);
        setFoodType(foodType);
        setbDate(bDate);
        setArea(area);
        setCompatibleWithHuman(compatibleWithHuman);
    }

    //גטרים

    public boolean getExtinction(){
        return extinction;
    }

    public String getGender() {
        return gender;
    }

    public Date getbDate() {
        return bDate;
    }

    public String getArea() {
        return area;
    }

    public String getCompatibleWithHuman() {
        return compatibleWithHuman;
    }

    //סטרים
    @Override
    public void setName(String name) {
        if(name.length()>15)
            this.name="Animal";
        else
            this.name = name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    @Override
    public void setId(String id) {
        if(id.length()==5)
            if ((id.charAt(0)>='A'&&id.charAt(0)<='z'&&id.charAt(1)>='A'&&id.charAt(1)<='z'&&
                    id.charAt(2)>='0'&&id.charAt(2)<='9'&&id.charAt(3)>='0'&&id.charAt(3)<='9'&&
                    id.charAt(4)>='0'&&id.charAt(4)<='9'))
                this.id = id;

            else
                this.id="AB123";

    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
            this.gender = gender;
        else
            this.gender="male";
    }

    public void setExtinction(boolean extinction) {
        this.extinction = extinction;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCompatibleWithHuman(String compatibleWithHuman) {
        this.compatibleWithHuman = compatibleWithHuman;
    }

    // Methods
    public void move(String areaToMove) {
        this.area = areaToMove;
    }

    @Override
    public String toString(){
        return "animal;"+super.toString()+ ", gender= "+gender+", extinction= "+extinction+", bDate= "+bDate+", foodType= "+foodType.getFoodName()+"area: "+area;
    }

    // פונקציה שבודקת אם חיה בסכנת הכחדה ונולדה אחרי תאריך שמתקבל כפרמטר
    public boolean checkExt(Date date){
        return(this.extinction&&this.bDate.after(date));
    }

    // פונקציה המשווה בין כלל הפרמטרים של שתי חיות
    @Override
    public boolean equals(Object o){
        return (!(o == null) && o instanceof Animal && this.bDate==((Animal)o).bDate&&this.extinction== ((Animal)o).extinction
                && this.name.equalsIgnoreCase(((Animal)o).name) && this.id.equals(((Animal)o).id)
                && this.gender.equalsIgnoreCase(((Animal)o).gender)&&this.foodType==(((Animal)o).foodType));
    }

    @Override
    public int calculateCaloriesBurned() {
        return 4*1000;
    }

    @Override
    public boolean match(Object o) {
        return (o != null) && (o instanceof ZooKeeper) &&
                compatibleWithHuman.equalsIgnoreCase(((ZooKeeper) o).getName()) &&
                (((ZooKeeper) o).getCompatibleWithAnimal().equalsIgnoreCase(name));
    }

}