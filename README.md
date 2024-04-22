# Travel Package Management
## An Application that helps in managing travel packages for agencies

### LLD For Travel Package Management
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

### SigningUp to an activity is implemented using visitor design pattern, Which helps in deducting right amount based on passengerType at runtime.
### Adding of new passengerType in future can be with minimal code changes.


<img width="666" alt="Screenshot 2024-04-22 at 8 40 30 PM" src="https://github.com/rajeshmanchikanti10/TravelPackageManagement/assets/45352809/6e92e462-bec6-46bf-afc6-70769295ee38">

