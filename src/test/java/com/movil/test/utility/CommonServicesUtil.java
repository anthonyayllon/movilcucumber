package com.movil.test.utility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class CommonServicesUtil {

    public static String getBodyContactData() {

        JSONObject jsonParams = new JSONObject();



        /******************************************************************/
        //  Set de jsonParams
        /******************************************************************/
        jsonParams.put("publicOffice", false);
        jsonParams.put("agreeAddress", true);
        jsonParams.put("countryCode", "PE");
        jsonParams.put("uberCode", CommunUtil.randomStringMax(10));
        jsonParams.put("email", CommunUtil.randomEmail("@gmail.com"));
        jsonParams.put("name", CommunUtil.nameRandom());
        jsonParams.put("lastname", CommunUtil.lastNameRandom());
        jsonParams.put("mobile", CommunUtil.randomNumberPhone());
        jsonParams.put("segmentation", CommunUtil.segmentation());

        int doctype = CommunUtil.randomNumber(8,10);
        if(doctype==8)
        {
            jsonParams.put("documentType", 8);
            jsonParams.put("nationalityCode", "PE");
        }
        else
        {
            jsonParams.put("documentType", 9);
            jsonParams.put("nationalityCode", CommunUtil.countryRandom());
        }

        String dni = CommunUtil.randomDni();
        jsonParams.put("documentNumber", dni);
        jsonParams.put("prefixDriverLicense", "M");
        jsonParams.put("secondLastname", CommunUtil.seconLastNameRandom());
        jsonParams.put("genderCode", "16");
        jsonParams.put("birthday", CommunUtil.randomDateOfBirth());
        jsonParams.put("nro", CommunUtil.randomNumberHouse());
        jsonParams.put("urb", "Lima");
        jsonParams.put("districtUbigeo", "150102");
        jsonParams.put("reference", CommunUtil.referensRandom());
        jsonParams.put("callTime", "80");
        jsonParams.put("agreeTerms", true);
        jsonParams.put("departmentCode", 15);
        jsonParams.put("provinceCode", 1);
        jsonParams.put("districtCode", 2);
        jsonParams.put("address", CommunUtil.streetRandom());//para
        String licencia = CommunUtil.randomCharacter()+dni;
        jsonParams.put("driverLicense", licencia);
        jsonParams.put("statusRequest", 75);

        return jsonParams.toString();
    }
}
