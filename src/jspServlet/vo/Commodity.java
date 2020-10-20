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
    private int UserId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

//    public String getLargeClass() {
//        return LargeClass;
//    }

//    public void setLargeClass(String largeClass) {
//        LargeClass = largeClass;
//    }
//
//    public String getSmallClass() {
//        return SmallClass;
//    }
//
//    public void setSmallClass(String smallClass) {
//        SmallClass = smallClass;
//    }

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
