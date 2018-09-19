package circlemenu.com.simpletabview.model;

import java.util.ArrayList;

public class Category {
    private String categoryName;
    private ArrayList<SchemeDetail> schemeDetails;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<SchemeDetail> getSchemeDetails() {
        return schemeDetails;
    }

    public void setSchemeDetails(ArrayList<SchemeDetail> schemeDetails) {
        this.schemeDetails = schemeDetails;
    }
}
