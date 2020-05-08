
/**
 * Write a description of class Tester here.
 * 
 * @author Mehmet ali akbay 
 * @version 5/8/2020
 */


import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     HashMap<String,Integer> counts;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
          counts = new HashMap<String,Integer>();
     }
        
     public void readFile(String filename) {
         FileResource rs = new FileResource(filename);
         for(String line : rs.lines()){
            records.add(WebLogParser.parseEntry(line));
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le : records){
            String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
            
            }
        
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             if(num < le.getStatusCode()){
                 System.out.println(le.getStatusCode());
                
                }
            
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIpAddr = new ArrayList<String>();
        for(LogEntry le : records){
            String d = le.getAccessTime().toString();
            String monthAndDay = d.substring(4,7) +" "+ d.substring(8,10);
            //uniqueIpAddr.add(monthAndDay);
           if(monthAndDay.equals(someday) && !uniqueIpAddr.contains(le.getIpAddress())){
                uniqueIpAddr.add(le.getIpAddress());
            }
        
        }
        return uniqueIpAddr;
        }
     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> uniqueIp = new ArrayList<String>();
        for(LogEntry le : records){
            int statusCode = le.getStatusCode();
            String ipAddr = le.getIpAddress();
            if((low <= statusCode && statusCode <= high) && !uniqueIp.contains(ipAddr)){
                uniqueIp.add(ipAddr);
            } 
        
        }
        
       return uniqueIp.size(); 
     }
     
     
    public HashMap<String, Integer> countVisitsPerIP(){
        
        for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            }else{
                counts.put(ip,counts.get(ip)+1);
            }
        }
    
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> myMap){
        int max = 0 ;
        for(Integer count : myMap.values()){
            if(count>max){
                max = count;
            }
        }
    
        return max;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> myMap){
        int mostNumber = mostNumberVisitsByIP(myMap);
        ArrayList<String> ipList = new ArrayList<String>();
        for(String key : myMap.keySet()){
            if(mostNumber == myMap.get(key)){
                ipList.add(key);
            }
        }
        return ipList;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        
        HashMap<String, ArrayList<String>> iPsForDays = new HashMap<String, ArrayList<String>>();
        
        for(LogEntry le : records){
            ArrayList<String> ipAddr = new ArrayList<String>();
            String d = le.getAccessTime().toString();
            String monthAndDay = d.substring(4,7) +" "+ d.substring(8,10);
            if(iPsForDays.containsKey(monthAndDay)){
                ipAddr = iPsForDays.get(monthAndDay);
                ipAddr.add(le.getIpAddress());
                iPsForDays.put(monthAndDay,ipAddr);
            }else{
                ipAddr.add(le.getIpAddress());
                iPsForDays.put(monthAndDay,ipAddr);
            
            }
           
        }
        return iPsForDays;
  
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsForDays){
        String day = "";
        int max = 0;
        for(String key : ipsForDays.keySet()){
            ArrayList<String> ips = ipsForDays.get(key);
            if(max < ips.size()){
                max = ips.size();
                day = key;
            }
        
        }
        
    
        return day;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipsForDays, String day){
   
        return ipsForDays.get(day);
    
    }
}
















