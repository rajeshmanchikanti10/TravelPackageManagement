# Travel Package Management
## An Application that helps in managing travel packages for agencies

## LLD For Travel Package Management
### Main Entities:
   * Passenger
   * Destination
   * TravelPackage
   * Activity

### Destination: TravelPackge(M:N)
### Destination : Activity(M:1)
### Passenger : TravelPackage(M:M)

### Destination:
 *  Destination has destinationName(unique Identifier), list of activities available at that destination, and state
 *   State field helps in filtering out InActive destinations

### Passenger:
  *  Passenger has passengerNumber(unique Indetifier),name,balance and passengerType
  *  Passenger type is an enum, which helps in caluculating amount to be paid at an activity, based on type(STANDARD,GOLD,PREMIUM)
### Activity
  * Activity has activityname,capacity,amountCharged and list of passenger's signedup for activity
  * Passenger get added to this,once user successfully registers activity
### TravelPackage
  * TravelPackage has name(unique identifier),passengerCapacity,list of passengers enrolled for package,list of destination under the package
  * Additional travel package also provides following
    * printItinerary
    * printPassengerList
    * printAvailableActivities
    * printPassengerDetails
### Usage of visitor
  * SigningUp to an activity is implemented using visitor design pattern, Which helps in deducting right amount based on passengerType at runtime.
  * Adding a new passengerType in future can be done with minimal code changes.
<img width="666" alt="Screenshot 2024-04-22 at 8 40 30 PM" src="https://github.com/rajeshmanchikanti10/TravelPackageManagement/assets/45352809/d60fbaa2-df7b-4a20-aeef-0eded269bc2c">

## HLD:
  ### Block Diagram
 <img width="623" alt="Screenshot 2024-04-22 at 11 11 22 PM" src="https://github.com/rajeshmanchikanti10/TravelPackageManagement/assets/45352809/91314066-47aa-4d80-9ff5-d054223af718">

  * As Travel Package system involves proper structuring of schema and no un-structured gets inserted into DB, we can think sql as an option, but with sql we will face problem with scale and performance.
  *  we can use SQL with distrubted cluster, this will address our scale issue
  *  Using Postgres withh citus helps in dealing with performance issue, as it has support for Parallel Query Execution,Indexing and Query Optimization etc.



<img width="820" alt="Screenshot 2024-04-23 at 6 48 20 AM" src="https://github.com/rajeshmanchikanti10/TravelPackageManagement/assets/45352809/f69d6917-922f-4f1d-bac4-66a13870fd90">






  

