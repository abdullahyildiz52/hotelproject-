package tests.muhammed;

import org.testng.annotations.Test;
import utilities.TestBaseRapor;

public class US_0005_To_TC_0005 extends TestBaseRapor {

    @Test
    public void tc_0005(){

        MethodsClass methodsClass=new MethodsClass();

        methodsClass.websiteGirisToHotelList();

        methodsClass.hotelListToEditHotel();

        methodsClass.editHotelPageOfAdressBox();

    }
}
