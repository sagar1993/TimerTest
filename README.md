# TimerTest


Current Approaches


A. With code modification.
  1. Store data in memory to trigger task.
 
  In memory database - Hazelcast 
    In memory databse .... --description-- 
    It provides Listener classes which gets notified with any CRUD operations on database. Modification to --listner-- with inserts to db can be used as a trigger point for the task scheduler for recon.
    
    Pros - Faster execution.
    Cons - Can't be used directly with distributed architecture.
     Setting it only for the purpose of recon execution could be performance costly.
  
  Dev efforts - setting it up with current application
    
  Singleton class -  a singlton class in application memory to catch any incoming trnasaction. Modification to --listner-- with inserts to db can be used as a trigger point for the task scheduler for recon.
  
    Pros - Faster execution.
     Quick development.
    Cons - Can't be used with distributed architecture of web application.
  
  Dev efforts - minimal, mostly requires unit testing.
  
B. Without code modification
  1. Database Listener
  
  Pros - Can be used with distributed architecture given its running on single server.
  Cons - Costly in case of in case of multiple transactions occuring in shorter time span. 
    
  2. Database Polling (current approach)
  
  Pros - Can be used with distributed architecture given its running on single server.
   
