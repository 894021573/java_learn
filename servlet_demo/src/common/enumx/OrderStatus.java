package common.enumx;

public enum OrderStatus
{
    WAIT_PAY(1, "待支付"),
    HAS_PAY(2, "已支付"),
    CANCELED(3, "已取消"),
    DELETED(4, "已删除");

    private int value;
    private String description;

    private OrderStatus(int value, String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
}
