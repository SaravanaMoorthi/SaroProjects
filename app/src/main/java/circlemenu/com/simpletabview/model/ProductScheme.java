package circlemenu.com.simpletabview.model;

public class ProductScheme {
    private int id;
    private String productName;
    private String assetCategory;
    private String scheme;
    private String tenor;
    private String roi;
    private float approveAmnt;
    private float emiAmnt;
    private int type;
    private String nameCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public String getRoi() {
        return roi;
    }

    public void setRoi(String roi) {
        this.roi = roi;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getApproveAmnt() {
        return approveAmnt;
    }

    public void setApproveAmnt(float approveAmnt) {
        this.approveAmnt = approveAmnt;
    }

    public float getEmiAmnt() {
        return emiAmnt;
    }

    public void setEmiAmnt(float emiAmnt) {
        this.emiAmnt = emiAmnt;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
