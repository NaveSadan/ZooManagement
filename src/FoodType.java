import java.util.Date;

public class FoodType {
    private String foodName;
    private double dailyAmount;
    private int feedingPerDay;
    private Date expirationDate;

    //בנאי חלקי מקבל רק dailyAmount ומגדיר ברירות מחדל לשאר המשתנים
    public FoodType(double dailyAmount){
        this.foodName="Generic Food";
        this.dailyAmount=dailyAmount;
        this.feedingPerDay=3;
        this.expirationDate=new Date(120,0,1);
    }

    //בנאי שלם
    public FoodType(String foodName,double dailyAmount,int feedingPerDay,Date expirationDate) {
        setFoodName(foodName);
        setDailyAmount(dailyAmount);
        setFeedingPerDay(feedingPerDay);
        setExpirationDate(expirationDate);
    }

    public String toString() {
        return "FoodType; foodName="+this.foodName+", feedingPerDay= "+this.feedingPerDay+", expirationDate= "+this.expirationDate;
    }

    public boolean dailyCheck(int feedingPerDay, Date expirationDate){
        Date today=new Date();//תאריך של היום
        return(feedingPerDay==3&&expirationDate.compareTo(today)>=7);//אם כמות ההאכלות ביום היא 3 ותאריך התפוגה גדול בשבוע מהיום יחזיר True
    }

    //פונקצית EQUALS שמשווה אם המזון שני האובייקטים זהים בכל הערכים
    public boolean equals(FoodType foodType){
        return (foodType.foodName.equalsIgnoreCase(this.foodName)&&foodType.dailyAmount==this.dailyAmount&&
                foodType.feedingPerDay==this.feedingPerDay&&foodType.expirationDate==this.expirationDate);
    }

    //גטרים
    public String getFoodName() {
        return foodName;
    }

    public double getDailyAmount() {
        return dailyAmount;
    }

    public int getFeedingPerDay() {
        return feedingPerDay;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    //סטרים
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    // מוודא שכמות המזון היא בין 5-50 ק"ג
    public void setDailyAmount(double dailyAmount) {
        if (dailyAmount >= 5 && dailyAmount <= 50)
            this.dailyAmount = dailyAmount;
        else
            this.dailyAmount = 0;
    }

    // מוודא שכמות ההאכלות בין 3-10 ק"ג
    public void setFeedingPerDay(int feedingPerDay) {
        if (feedingPerDay>=3&&feedingPerDay<=10)
            this.feedingPerDay = feedingPerDay;
        else
            this.feedingPerDay=0;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
