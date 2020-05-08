# ReadingLogFiles
In this project I have learned how to analyzed apache documentation web server log files
 - How many unique IP adresses
 - Information about visited web sites

This project have these methods

- countUniqueIPs()  that has no parameters. This method returns an integer representing the number of unique IP addresses. It also assumes that the instance variable records already has its ArrayList of Strings read in from a file, and access records in computing this value. 
- uniqueIPVisitsOnDay() that has one String parameter named someday in the format “MMM DD” where MMM is the first three characters of the month name with the first letter capitalized and the others in lowercase, and DD is the day in two digits (examples are “Dec 05” and “Apr 22”). This method accesses the web logs in records and returns an ArrayList of Strings of unique IP addresses that had access on the given day.
- countUniqueIPsInRange() that has two integer parameters named low and high. This method returns the number of unique IP addresses in records that have a status code in the range from low to high, inclusive. 
- printAllHigherThanNum that has one integer parameter num. This method examines all the web log entries in records and print those LogEntrys that have a status code greater than num. 
