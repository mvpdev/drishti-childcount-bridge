package org.ei.drishti.ccforms;

import org.ei.drishti.utils.ChildcountBridge;
import org.ei.drishti.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;

@Service
public class ChildcountFormB {
	

	private String message;
	private static String params;
	
	//household
	private static String visit_pattern = "{0} +V {1} {2} {3}";
	private static String fplanning_pattern = "{0} +P {1} {2} {3} ";
	private static String sick_pattern = "{0} +E {1} {2} {3} ";
	//Underfive
	private static String visit_pattern = "{0} +V {1} {2} {3}";
	private static String fplanning_pattern = "{0} +P {1} {2} {3} ";
	private static String sick_pattern = "{0} +E {1} {2} {3} ";
	
	
	public void householdvisit(HouseholdVisitForm info){
	
		    //HOUSEHOLD VISIT (+V)
		    Object[] params = new Object[] {info.healthID(), info.member_available(), info.under_five(), advice_coded(info.advice_given()) };
		    String vmessage = MessageFormat.format(visit_pattern, params);
		    System.out.println(vmessage);
		    
		    ChildcountBridge send = new ChildcountBridge(info.CHWIdentity(), vmessage, "", "");
		    send.submitPost();
		    
		    //OTHER SICK MEMBERS SECTION (+E)
		    //if there sick members and RDT have been used.
		    /*
		    String other_sickmember = info.other_sickmembers();
		    String rdt_used;
		    
		    Object[] params = new Object[] {info.healwthID(), info.other_sickmembers(), info.under_five(), info.advice_given() };
		    String message = MessageFormat.format(sick_pattern, params);
		    System.out.println(message);
		    
		    
		    ChildcountBridge send = new ChildcountBridge(info.CHWIdentity(), message, "", "");
		    send.submitPost();
		    */
		    //FAMILY PLANNING SECTION (+P)
		    Object[] params_p = new Object[] {info.healthID(), info.women_count(), info.women_using_fplanning(), info.fplanning_method() };
		    String pmessage = MessageFormat.format(fplanning_pattern, params_p);
		    System.out.println(pmessage);
		    
		    
		    ChildcountBridge psend = new ChildcountBridge(info.CHWIdentity(), pmessage, "", "");
		    psend.submitPost();
	}

	public void pregnancyvisit(PregnancyVisitForm info){
	
		    //Pregnancy VISIT (+V)
		    
	}

	public void underfivevisit(UnderFiveVisitForm info){
	
		    //Underfive VISIT (+V)
		    
	}
	
		
	public static String advice_coded(String string){	
		  String str = string.toLowerCase();

                  /* delimiter */
                  String delimiter = " ";
                  String advice = "";
                  /* given string will be split by the argument delimiter provided. */
                  String[] temp = str.split(delimiter);
                  /* print substrings */
                  for(int i =0; i < temp.length ; i++){
                    String out_put= temp[i].trim();
                    if(out_put.equals("family_planning")){
                        advice +="FP";
                    }
                    if(out_put.equals("bednet")){
                        advice +=" BN";
                    }
                    if(out_put.equals("handwashing")){
                        advice +=" SH";
                    }
                    if(out_put.equals("latrines")){
                        advice +=" SH";
                    }
                    if(out_put.equals("water_purification")){
                        advice +=" SH";
                    }
                  }
                  return advice;
	}
}



