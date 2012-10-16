/*
* PUSHES DATA FROM COMMCARE MODULES TO CC+ REGISTRATION FORM A
* Main Commcare Modules
*     == child
*     == pregnancy
*     == households
* 
* CHILDCOUNT FORM A>Registration DATA to be mapped with commcare modules
*     Health ID
*     Location
*     Full name
*     Gender
*     dob
*     household Health ID
*  
*  String register_pattern = "{HID} +NEW {location} {fullname} {gender} {dob} {household_head}";
* 
* CHILDCOUNT FORM A>Birth DATA to be mapped with commcare modules
*     Health ID
*     Place of Birth
*     Birth Weight
*
*  String birth_pattern = "{HID} +BIR {delivered_inclinic(Y/N/U)} {weight} ";
*/

package org.ei.drishti.ccforms;

import org.ei.drishti.utils.ChildcountBridge;
import org.ei.drishti.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;

@Service
public class ChildcountFormA {
	
	private String url;
	private String chw;
	private String identity;
	private String message;
	private static String params;
	private static String mob;
	
	private static String register_pattern = "{0} +NEW {1} {2} {3} {4} {5}";
	private static String birth_pattern = " +BIR {0} {1} {2} ";
	//private String mobile_pattern = "{0} +MOB {1} ";
	private static String mobile_pattern = " +MOB {0} ";
	
	
	public void registerUnderFive(UnderFiveRegistrationInformation info){
	
		    Object[] params = new Object[] {info.healthID(), info.locationcode(), info.fullname(), Sex(info.sex()), info.age() ,  info.householdhealthid() };
		    String message = MessageFormat.format(register_pattern, params);
		    
		    //Add BIRTH
		    String clinicdelivery = info.clinicdelivery();
		    String motherid = info.motherhealthid();
		    if(motherid == ""){
		        motherid = info.householdhealthid();
		    }
		    if(clinicdelivery=="yes" || clinicdelivery=="no"){

		            Object[] bir = new Object[] {motherid, codedAnswers(info.clinicdelivery()), info.birthweight()};
		            message += MessageFormat.format(birth_pattern, bir);
		    }
		    
		    System.out.println(message);

		    ChildcountBridge send = new ChildcountBridge(info.CHWIdentity(), message, "", "");
		    send.submitPost();
	}

	public  void registerHousehold(HouseholdRegistrationInformation info){
			
		    Object[] params = new Object[] {info.healthID(), info.locationcode(), info.fullname(), Sex(info.sex()), info.age() ,  "H" };
		    String message = MessageFormat.format(register_pattern, params);

		    //ADD MOBILE PHONE
		    String mobile = info.mobile();
		    /*
		    if(Isnotnull(mobile)==true)

		    {
		        Object[] mob = new Object[] {info.mobile()};
		        message += MessageFormat.format(mobile_pattern, mob);
		    }

		    */
		    
		    System.out.println(message);

		    ChildcountBridge send = new ChildcountBridge(info.CHWIdentity(), message, "", "");
		    send.submitPost();
		    
	}
	
	
	public void registerPregnancy(PregnancyRegistrationInformation info){
	
		    Object[] params = new Object[] {info.healthID(), info.locationcode(), info.fullname(), Sex(info.sex()), info.age() ,  info.householdhealthid() };
		    message = MessageFormat.format(register_pattern, params);
		    
		    //ADD MOBILE PHONE
		    String mobile = info.mobile();
		    /*
		    if(Isnotnull(mobile)==true)
		    {
		        Object[] mob = new Object[] {info.mobile()};
		        message += MessageFormat.format(mobile_pattern, mob);
		    }
		    */

		    
		    System.out.println(message);
		    ChildcountBridge send = new ChildcountBridge(info.CHWIdentity(), message, "", "");
		    send.submitPost();
	}
		
	private static String Sex(String sex){
	
	    if(sex.toLowerCase()=="male"){
			   return "M";
		}
		else if(sex.toLowerCase()=="female"){
		    return  "F";
		}
		else{
		    return "F";
		}
	}

    public static String codedAnswers(String string){
        if(string.toLowerCase()=="yes"){
			   return "Y";
		}
		else if(string.toLowerCase()=="no"){
		    return  "N";
		}
		else{
		    return "N";
		}
    }
}
