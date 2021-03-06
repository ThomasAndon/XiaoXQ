package jspServlet.vo;

/**
 * 商品信息
 * @author Zeyang Sun
 */
public class Commodity {

    private int CommodityId;
    private String Name;
    private Float Price;
    private String TheColor;
    private String TheClass;
    private String Instructions;
    private int Number;


    private Float MAXPrice;
    private Float MINPrice;

    public Float getMAXPrice() {
        return MAXPrice;
    }

    public void setMAXPrice(Float MAXPrice) {
        this.MAXPrice = MAXPrice;
    }

    public Float getMINPrice() {
        return MINPrice;
    }
    public void setMINPrice(Float MINPrice) {
        this.MINPrice = MINPrice;
    }
    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getTheColor() {
        return TheColor;
    }

    public void setTheColor(String theColor) {
        TheColor = theColor;
    }

    public String getTheClass() {
        return TheClass;
    }

    public void setTheClass(String theClass) {
        TheClass = theClass;
    }

    private int UserId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }








    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public int getCommodityId() {
        return CommodityId;
    }

    public void setCommodityId(int commodityId) {
        CommodityId = commodityId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
