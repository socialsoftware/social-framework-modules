package pt.ist.data;

public class DataObjectType {

    public static DataObjectType STRING = new DataObjectType("STRING");
    public static DataObjectType NUMBER = new DataObjectType("NUMBER");
    public static DataObjectType MONEY = new DataObjectType("MONEY");
    public static DataObjectType DATE = new DataObjectType("DATE");

    private String dataObjectType;

    public DataObjectType(String dataObjectType) {
        this.dataObjectType = dataObjectType;
    }

    @Override
    public String toString() {
        return dataObjectType;
    }

}
