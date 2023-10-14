
package Model;


public class Billing {
    
    private Long billId;
    private Long patientId;
    private String name;
    private String billDate;
    private String detail;
    private int unit;
    private int amount;
    private int total;

    public Billing() {
    }

    public Billing(Long billId, Long patientId, String name, String billDate, String detail, int unit, int amount, int total) {
        this.billId = billId;
        this.patientId = patientId;
        this.name = name;
        this.billDate = billDate;
        this.detail = detail;
        this.unit = unit;
        this.amount = amount;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
