package circlemenu.com.simpletabview.utility;

import java.util.ArrayList;

import circlemenu.com.simpletabview.model.Category;
import circlemenu.com.simpletabview.model.SchemeDetail;

public class GenerateSchemeData {
    public static final String title[] = {"LG", "SAMSUNG", "SONY", "Videocon", "Whirlpool"};

    private String[] lgCategoryName = {"Water Purifier", "Electric Chimney", "Air Purifier", "Refrigerator", "Mobile Phones", "Microwave Oven",
            "Vaccum Cleaners", "Telivision", "Air Conditioning"};

    private String[] samsungCategoryName = {"Select Category", "Telivision", "Air Conditioning", "Refrigerator", " Laptops", "Mobile Phones", "Microwave Oven", "Home Theatre"
            , "Washing Machine", "Vaccum Cleaners"};

    private String[] sonyCategoryName = {"Select Category", "Telivision", "Home Theatre"};

    private String[] vidCategoryName = {"Select Category", "Telivision", "Air Conditioning","Refrigerator", "Washing Machine"};

    private String[] wpoolCategoryName = {"Select Category","Air Conditioning","Refrigerator", "Microwave Oven", "Washing Machine"};

    private String[] defaultScheme = {"Select Scheme"};
    private String[] defaultTenor = {""};
    private String[] defaultRoi = {""};

    private String[] lgWaterPurifierScheme = {"Select Scheme", "LG 10M 0 Adv EMI", "LG 10M 1 Adv EMI", "LG 10M 2 Adv EMI"};
    private String[] lgWaterPurifierTenor = {"", "10", "10", "10"};
    private String[] lgWaterPurifierRoi = {"", "10", "10", "10"};

    private String[] lgElectricChimneyScheme = {"Select Scheme", "LG 12M 4 Adv EMI", "LG 18M 4 Adv EMI", "LG 15M 0 ADV EMI"};
    private String[] lgElectricChimneyTenor = {"", "12", "18", "15"};
    private String[] lgElectricChimneyRoi = {"", "10", "12", "12"};

    private String[] lgAirPurifierScheme = {"Select Scheme", "LG AP TL 24M 4 Adv EMI", "LG 20M 0 ADV EMI", "LG SPL TN 12M 0 ADV EMI"};
    private String[] lgAirPurifierTenor = {"", "24", "20", "12"};
    private String[] lgAirPurifierRoi = {"", "18", "18", "10"};

    private String[] lgRefrigeratorScheme = {"Select Scheme", "LG 18M 0 ADV EMI", "LG 10M 1 Adv EMI", "LG 20M 0 ADV EMI"};
    private String[] lgRefrigeratorTenor = {"", "18", "10", "20"};
    private String[] lgRefrigeratorRoi = {"", "12", "10", "18"};

    private String[] lgMobilePhonesScheme = {"Select Scheme", "LG 12M 4 ADV EMI", "LG 12M 0 Adv EMI", "LG 15M 0 Adv EMI"};
    private String[] lgMobilePhonesTenor = {"", "12", "12", "15"};
    private String[] lgMobilePhonesRoi = {"", "10", "10", "12"};

    private String[] lgMicrowaveOvenScheme = {"Select Scheme", "LG 24M 0 ADV EMI", "LG 18M 0 ADV EMI", "LG 12M 4 ADV EMI"};
    private String[] lgMicrowaveOvenTenor = {"", "24", "18", "12"};
    private String[] lgMicrowaveOvenRoi = {"", "18", "12", "10"};

    private String[] lgVaccumCleanersScheme = {"Select Scheme", "LG 9M 0 ADV EMI", "LG 25M 5 Adv EMI", "LG 10M 2 Adv EMI"};
    private String[] lgVaccumCleanersTenor = {"", "9", "25", "10"};
    private String[] lgVaccumCleanersRoi = {"", "10", "18", "10"};

    private String[] lgTelivisionScheme = {"Select Scheme", "LG AP TL 10M 2 Adv EMI", "LG AP TL 18M 4 Adv EMI", "LG AP TL 26M 4 Adv EMI"};
    private String[] lgTelivisionTenor = {"", "10", "18", "26"};
    private String[] lgTelivisionRoi = {"", "10", "12", "18"};

    private String[] lgAirConditioningScheme = {"Select Scheme", "LG AP TL 24M 5 Adv EMI", "LG 12M 4 ADV EMI", "LG AP TL 9M 0 ADV EMI"};
    private String[] lgAirConditioningTenor = {"", "24", "12", "9"};
    private String[] lgAirConditioningRoi = {"", "18", "10", "10"};


    private String[] samTelivisionScheme = {"Select Scheme", "SAMSUNG 12M 4 ADV EMI", "Samsung 12M 0 Adv EMI", "SAMSUNG 8M 0 ADV EMI"};
    private String[] samTelivisionTenor = {"", "25", "12", "8"};
    private String[] samTelivisionRoi = {"", "18", "10", "10"};

    private String[] samAirConditioningScheme = {"Select Scheme", "Samsung 18M 4 Adv EMI", "SAMSUNG 8M 0 ADV EMI", "Samsung 30M 6 Adv EMI"};
    private String[] samAirConditioningTenor = {"", "12", "8", "30"};
    private String[] samAirConditioningRoi = {"", "10", "10", "18"};

    private String[] samRefrigeratorScheme = {"Select Scheme", "Samsung 9M 0 Adv EMI", "Samsung 10M 0 Adv EMI", "Samsung 10M 1 Adv EMI"};
    private String[] samRefrigeratorTenor = {"", "18", "10", "10"};
    private String[] samRefrigeratorRoi = {"", "10", "10", "10"};

    private String[] samLaptopsScheme = {"Select Scheme", "Samsung 10M 1 Adv EMI", "Samsung 9M 0 Adv EMI", "SAMSUNG 12M 4 ADV EMI"};
    private String[] samLaptopsTenor = {"", "9", "9", "12"};
    private String[] samLaptopsRoi = {"", "10", "10", "10"};

    private String[] samMobilePhonesScheme = {"Select Scheme", "Samsung 10M 1 Adv EMI", "SAMSUNG 12M 4 ADV EMI", "Samsung 10M 0 Adv EMI"};
    private String[] samMobilePhonesTenor = {"", "10", "12", "10"};
    private String[] samMobilePhonesRoi = {"", "10", "12", "10"};

    private String[] samMicrowaveOvenScheme = {"Select Scheme", "Samsung 12M 0 Adv EMI", "Samsung 12M 4 Adv EMI", "Samsung 15M 0 Adv EMI"};
    private String[] samMicrowaveOvenTenor = {"", "12", "12", "15"};
    private String[] samMicrowaveOvenRoi = {"", "12", "10", "12"};

    private String[] samHomeTheatreScheme = {"Select Scheme", "Samsung 12M 0 Adv EMI", "Samsung 12M 4 Adv EMI", "Samsung 15M 0 Adv EMI"};
    private String[] samHomeTheatreTenor = {"", "12", "12", "15"};
    private String[] samHomeTheatreRoi = {"", "12", "10", "12"};

    private String[] samWashingMachineScheme = {"Select Scheme", "Samsung 30M 6 Adv EMI", "SAMSUNG 10M 2 ADV EMI", "SAMSUNG 15M 0 ADV EMI"};
    private String[] samWashingMachineTenor = {"", "30", "10", "15"};
    private String[] samWashingMachineRoi = {"", "18", "10", "12"};

    private String[] samVaccumCleanersScheme = {"Select Scheme", "Samsung 30M 6 Adv EMI", "Samsung 15M 0 Adv EMI", "Samsung 12M 0 Adv EMI"};
    private String[] samVaccumCleanersTenor = {"", "12", "15", "12"};
    private String[] samVaccumCleanersRoi = {"", "10", "12", "10"};

    private String[] sonyTelivisionScheme = {"Select Scheme", "SONY 12M 4 ADV EMI", "SONY 9M 0 ADV EMI", "SONY 18M 4 ADV EMI"};
    private String[] sonyTelivisionTenor = {"", "12", "9", "18"};
    private String[] sonyTelivisionRoi = {"", "10", "10", "12"};

    private String[] sonyHTScheme = {"Select Scheme", "SONY 18M 4 ADV EMI", "SONY 12M 4 ADV EMI", "SONY 12M 4 ADV EMI"};
    private String[] sonyHTTenor = {"", "18", "12", "12"};
    private String[] sonyHTRoi = {"", "12", "10", "10"};

    private String[] vidTelivisionScheme = {"Select Scheme", "CD_GEN KR 10M 0 ADV UPTO", "CD_GEN 10M 4 ADV UPTO", "CD_GEN 18M 4 ADV UPTO"};
    private String[] vidTelivisionTenor = {"", "10", "10", "18"};
    private String[] vidTelivisionRoi = {"", "10", "10", "12"};

    private String[] vidAirConditioningScheme = {"Select Scheme", "CD_GEN BB 10M 0 ADV UPTO", "CD_GEN BB 12M 4 ADV UPTO", "CD_GEN BB 8M 0 ADV UPTO"};
    private String[] vidAirConditioningTenor = {"", "10", "12", "8"};
    private String[] vidAirConditioningRoi = {"", "10", "12", "10"};

    private String[] vidRefrigeratorScheme = {"Select Scheme", "CD_GEN KR 10M 0 ADV UPTO", "CD_GEN 10M 4 ADV UPTO", "CD_GEN 18M 4 ADV UPTO"};
    private String[] vidRefrigeratorTenor = {"", "10", "10", "18"};
    private String[] vidRefrigeratorRoi = {"", "10", "10", "12"};

    private String[] vidWashingMachineScheme = {"Select Scheme", "CD_GEN BB 10M 0 ADV UPTO", "CD_GEN BB 12M 4 ADV UPTO", "CD_GEN BB 8M 0 ADV UPTO"};
    private String[] vidWashingMachineTenor = {"", "10", "12", "8"};
    private String[] vidWashingMachineRoi = {"", "10", "12", "10"};

    private String[] wpoolAirConditioningScheme = {"Select Scheme", "CD_GEN BB 8M 0 ADV UPTO 3", "CD_GEN BB 10M 2 ADV UPTO", "CD_GEN BB 12M 4 ADV UPTO"};
    private String[] wpoolAirConditioningTenor = {"", "8", "10", "12"};
    private String[] wpoolAirConditioningRoi = {"", "10", "10", "10"};

    private String[] wpoolRefrigeratorScheme = {"Select Scheme", " CD_GEN BB 8M 0 ADV UPTO 5", "CD_GEN BB 10M 2 ADV UPTO", "CD_GEN BB 10M 2 ADV UPTO"};
    private String[] wpoolRefrigeratorTenor = {"", "8", "10", "10"};
    private String[] wpoolRefrigeratorRoi = {"", "10", "10", "10"};

    private String[] wpoolMicrowaveOvenScheme = {"Select Scheme", "CD_GEN BB 10M 0 ADV UPTO", "CD_GEN BB 12M 4 ADV UPTO", "CD_GEN BB 10M 1 ADV UPTO"};
    private String[] wpoolMicrowaveOvenTenor = {"", "10", "12", "10"};
    private String[] wpoolMicrowaveOvenRoi = {"", "10", "10", "10"};

    private String[] wpoolWashingMachineScheme = {"Select Scheme", "CD_GEN BB 10M 1 ADV UPTO", "CD_GEN BB 12M 4 ADV UPTO", "CD_GEN 10M 1 ADV UPTO"};
    private String[] wpoolWashingMachineTenor = {"", "10", "12", "10"};
    private String[] wpoolWashingMachineRoi = {"", "10", "12", "10"};




    private ArrayList<Category> mCategoryList;
    private int mPosition;

    public GenerateSchemeData(int position) {
        mPosition = position;
        generateData();
    }

    private void generateData() {
        switch (mPosition) {
            case 0:
                mCategoryList = new ArrayList<>();

//                addSchemeDetail(lgCategoryName[0], defaultScheme, defaultTenor, defaultRoi);
                addSchemeDetail(lgCategoryName[0], lgWaterPurifierScheme, lgWaterPurifierTenor, lgWaterPurifierRoi);
                addSchemeDetail(lgCategoryName[1], lgElectricChimneyScheme, lgElectricChimneyTenor, lgElectricChimneyRoi);
                addSchemeDetail(lgCategoryName[2], lgAirPurifierScheme, lgAirPurifierTenor, lgAirPurifierRoi);
                addSchemeDetail(lgCategoryName[3], lgRefrigeratorScheme, lgRefrigeratorTenor, lgRefrigeratorRoi);
                addSchemeDetail(lgCategoryName[4], lgMobilePhonesScheme, lgMobilePhonesTenor, lgMobilePhonesRoi);
                addSchemeDetail(lgCategoryName[5], lgMicrowaveOvenScheme, lgMicrowaveOvenTenor, lgMicrowaveOvenRoi);
                addSchemeDetail(lgCategoryName[6], lgVaccumCleanersScheme, lgVaccumCleanersTenor, lgVaccumCleanersRoi);
                addSchemeDetail(lgCategoryName[7], lgTelivisionScheme, lgTelivisionTenor, lgTelivisionRoi);
                addSchemeDetail(lgCategoryName[8], lgAirConditioningScheme, lgAirConditioningTenor, lgAirConditioningRoi);
                break;
            case 1:
                mCategoryList = new ArrayList<>();
//                addSchemeDetail(samsungCategoryName[0], defaultScheme, defaultTenor, defaultRoi);
                addSchemeDetail(samsungCategoryName[1], samTelivisionScheme, samTelivisionTenor, samTelivisionRoi);
                addSchemeDetail(samsungCategoryName[2], samAirConditioningScheme, samAirConditioningTenor, samAirConditioningRoi);
                addSchemeDetail(samsungCategoryName[3], samRefrigeratorScheme, samRefrigeratorTenor, samRefrigeratorRoi);
                addSchemeDetail(samsungCategoryName[4], samLaptopsScheme, samLaptopsTenor, samLaptopsRoi);
                addSchemeDetail(samsungCategoryName[5], samMobilePhonesScheme, samMobilePhonesTenor, samMobilePhonesRoi);
                addSchemeDetail(samsungCategoryName[6], samMicrowaveOvenScheme, samMicrowaveOvenTenor, samMicrowaveOvenRoi);
                addSchemeDetail(samsungCategoryName[7], samHomeTheatreScheme, samHomeTheatreTenor, samHomeTheatreRoi);
                addSchemeDetail(samsungCategoryName[8], samWashingMachineScheme, samWashingMachineTenor, samWashingMachineRoi);
                addSchemeDetail(samsungCategoryName[9], samVaccumCleanersScheme, samVaccumCleanersTenor, samVaccumCleanersRoi);
                break;
            case 2:
                mCategoryList = new ArrayList<>();

//                addSchemeDetail(sonyCategoryName[0], defaultScheme, defaultTenor, defaultRoi);
                addSchemeDetail(sonyCategoryName[1], sonyTelivisionScheme, sonyTelivisionTenor, sonyTelivisionRoi);
                addSchemeDetail(sonyCategoryName[2], sonyHTScheme, sonyHTTenor, sonyHTRoi);
                break;
            case 3:
                mCategoryList = new ArrayList<>();
                addSchemeDetail(vidCategoryName[1], vidTelivisionScheme, vidTelivisionTenor, vidTelivisionRoi);
                addSchemeDetail(vidCategoryName[2], vidAirConditioningScheme, vidAirConditioningTenor, vidAirConditioningRoi);
                addSchemeDetail(vidCategoryName[3], vidRefrigeratorScheme, vidRefrigeratorTenor, vidRefrigeratorRoi);
                addSchemeDetail(vidCategoryName[4], vidWashingMachineScheme, vidWashingMachineTenor, vidWashingMachineRoi);
                break;

            case 4:
                mCategoryList = new ArrayList<>();
                addSchemeDetail(wpoolCategoryName[1], wpoolAirConditioningScheme, wpoolAirConditioningTenor, wpoolAirConditioningRoi);
                addSchemeDetail(wpoolCategoryName[2], wpoolRefrigeratorScheme, wpoolRefrigeratorTenor, wpoolRefrigeratorRoi);
                addSchemeDetail(wpoolCategoryName[3], wpoolMicrowaveOvenScheme, wpoolMicrowaveOvenTenor, wpoolMicrowaveOvenRoi);
                addSchemeDetail(wpoolCategoryName[4], wpoolWashingMachineScheme, wpoolWashingMachineTenor, wpoolWashingMachineRoi);
                break;
        }
    }

    private void addSchemeDetail(String categoryName, String[] schemeList, String[] tenorList, String[] roiList) {
        ArrayList<SchemeDetail> schemeDetails = new ArrayList<>();

        for (int i = 0; i < schemeList.length; i++) {
            SchemeDetail schemeDetail = new SchemeDetail();
            schemeDetail.setScheme(schemeList[i]);
            schemeDetail.setTenor(tenorList[i]);
            schemeDetail.setRoi(roiList[i]);
            schemeDetails.add(schemeDetail);
        }

        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setSchemeDetails(schemeDetails);
        mCategoryList.add(category);
    }

    public ArrayList<Category> getCategoryList() {
        return mCategoryList;
    }
}
