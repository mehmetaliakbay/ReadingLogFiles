 import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        //la.printAll();
        //la.printAllHigherThanNum(400);
        
        System.out.println("unique ip adresses according to Status Code range "+la.countUniqueIPsInRange(300,399));
        
        //unique ip addresses for spesific days
       /* ArrayList<String> uniqueIpAddr =la.uniqueIPVisitsOnDay("Mar 17");
        System.out.println(uniqueIpAddr.size());
       for(String ipAddr : uniqueIpAddr){
            System.out.println(ipAddr);

        } */
        
       
       
    }
    
    public void UniqueIPTester(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs+ " IPs");
    
    }
    
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        //System.out.println(counts);
        
        //return Integer
        //the most visit by one ip
        //System.out.println("the most visit by one ip = "+la.mostNumberVisitsByIP(counts));
        
        //the most visits by ips
        ArrayList<String> mostVisitsIps = la.iPsMostVisits(counts);
        //System.out.println("the most visit ips = "+mostVisitsIps);
        
        
        // for each day which ips visited our web site -- according to days
        HashMap<String, ArrayList<String>> ipForDays = la.iPsForDays();
        //System.out.println("for each day which ips visited our web site  = "+ipForDays);
        
        //returned String
        //the day by the most visit
        String day = la.dayWithMostIPVisits(ipForDays);
        //System.out.println("the day by the most visit  = "+day);
        
        //returned ArrayList<String>
        //the ips with most visit on a single day
        System.out.println(la.iPsWithMostVisitsOnDay(ipForDays,"Mar 17"));
    }
 
    
    
    
}
