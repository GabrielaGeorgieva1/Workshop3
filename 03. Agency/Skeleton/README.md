<img src="https://webassets.telerikacademy.com/images/default-source/logos/telerik-academy.svg" alt="logo" width="300px" style="margin-top: 20px;"/>

# OOP Workshop - Travel Agency

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work way easier.

## Description

Implement a journey and ticket tracking system for a famous travel agency called `Sunny Travel`. The application already accepts commands and outputs text for each submitted command, what you need to do is build the OO classes hierarchy. The user can create different models (`Bus, Airplane, Train, Ticket, Journey`), as well as list them. Make sure to follow the Object Orientated Programming best practices and conventions that we have talked about during the lectures.

## Architecture

By now you should be acquainted with how the Engine works. It's the same as all previous workshops. The commands use the `AgencyRepositoryImpl` class to create and store all the application information. After the command executes, it returns a result message to the `EngineImpl` that prints it to the console.

Your focus should be on the `models` and `commands` packages, where you need to place the classes you create, using the provided interfaces in the `contracts` package or implement the commands which are not ready yet.

## Part 1 - Models

> Note: All validation intervals are inclusive (closed).

### Fields and behavior

#### **Train**

- `Passenger Capacity` - a number between `30` and `150`.
  - Exception message: `A train cannot have less than 30 passengers or more than 150 passengers.`
- `Carts` - a number between `1` and `15`.
  - Exception message: `A train cannot have less than 1 cart or more than 15 carts.`
- `Type` - one of `[Land, Air, Sea]`.
- `Price Per Kilometer` - a number between `0.1` and `2.5` representing currency.
- Should be convertible to **String** in the format:

```none
Train ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Carts amount: VALUE
```

#### **Airplane**

- `Passenger Capacity` - a number.
- `Type` - one of `[Land, Air, Sea]`.
- `Has Free Food` - boolean.
- `Price Per Kilometer` - a number.
- Should be convertible to **String** in the format:

```none
Airplane ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Has free food: VALUE
```

#### **Bus**

- `Passenger Capacity` - a number between `10` and `50`.
  - Exception message: `A bus cannot have less than 10 passengers or more than 50 passengers.`
- `Price Per Kilometer` - a number.
- `Type` - one of `[Land, Air, Sea]`.
- Should be convertible to **String** in the format:

```none
Bus ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
```

#### **Journey**

- `Start Location` - a string with length between `5` and `25`.
  - Exception message: `The StartingLocation's length cannot be less than 5 or more than 25 symbols long.`
- `Destination` - a string with length between `5` and `25`.
  - Exception message: `The Destination's length cannot be less than 5 or more than 25 symbols long.`
- `Distance` - a number between `5` and `5000`.
  - Exception message: `The Distance cannot be less than 5 or more than 5000 kilometers.`
- `Vehicle` - the vehicle that will be used in the journey.
- `calculateTravelCosts()` - calculated by multiplying the `Distance` by the `Vehicle`'s `price per kilometer`.
- Should be convertible to **String** in the format:

```none
Journey ----
Start location: VALUE
Destination: VALUE
Distance: VALUE
Vehicle type: VALUE
Travel costs: VALUE
```

#### **Ticket**

- `Journey` - the journey the ticket is sold for.
- `Administrative Costs` - a number.
- `CalculatePrice()` - calculated by multiplying the `Administrative Costs` by the `Journey`'s `travel costs`.
- Should be convertible to **String** in the format:

```none
Ticket ----
Destination: VALUE
Price: VALUE
```

#### **Additional validations**

The laws of physics and finances dictate that:

- A vehicle with **less than 1** or **more than 800 passengers** cannot exist!
  - Exception message: `A vehicle with less than 1 passengers or more than 800 passengers cannot exist!`
- A vehicle with a price per kilometer **lower than $0.10** or **higher than $2.50** cannot exist!
  - Exception message: `A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!`

In your case, there is no such vehicle, but think about these rules more generally. This system could be extended in the future to accommodate more vehicles.

### Repository

The `AgencyRepositoryImpl` class is used to store and retrieve all information that the application needs. It is also in charge of creating the objects.

The class has a private `nextId` field that is used to store the next `ID` to be assigned. Whenever something with an ID is created, the `nextId` field should be incremented.

Your task is to implement all methods that throw `UnsupportedOperationException`.

### Commands

**All commands are case insensitive, except their parameters!** Each command is represented in the code base as a separate class, that is invoked by the CommandFactoryImpl.

You are given a set of commands. The following are already implemented:

- **CreateBus** `[passengerCapacity] [pricePerKilometer]` - Creates a new `Bus`.
- **CreateTrain** `[passengerCapacity] [pricePerKilometer] [carts]` - Creates a new `Train`.
- **CreateJourney** `[startLocation] [destination] [distance] [vehicleID]` - Creates a new `Journey`.
- **ListJourneys** - Lists all stored journeys.
- **ListTickets** - Lists all stored tickets.

And these are the commands you need to implement yourself:

- **CreateAirplane** `[passengerCapacity] [pricePerKilometer] [hasFreeFood]` - Creates a new `Airplane`.
- **CreateTicket** `[journeyID] [administrativeCosts]` - Creates a new `Ticket`.
- **ListVehicles** - Lists all stored vehicles.

### Constraints

- You are allowed to create new and modify existing **classes, interfaces, enumerations and packages** in the `models` package.
- You are allowed to modify the **AgencyRepositoryImpl**.
- You are allowed to create and modify existing classes in the `commands` package.
- ***You are NOT allowed to modify any other existing interfaces!***
- ***You are NOT allowed to modify any other existing classes, enumerations and packages!***

### Unit Tests

- You have been given unit tests to keep track off your progress. Run them by right-clicking the `tests` package and selecting `Run 'All Tests'`.
- Should you get stuck, check out the tests' names to guide you what you should do.
  
> Note: Be careful not to change anything in the `tests` folder.

### Step by step guide

1. If you try to build the Skeleton it won't compile. Do not worry.
2. Navigate to the `models` package. What would be the hierarchy between the interface? Inspect what classes are there and think about what interfaces do they need to implement. Is there an opportunity to introduce an abstract class?
3. After implementing and encapsulating the needed models head over to the `AgencyRepositoryImpl` class. All methods that throw `UnsupportedOperationException` need to be implemented.
4. It is now time to implement all commands that are not implemented.

### Advanced tasks (Optional)

> Note: Do not worry about those. Start working on them only if you've completed all the other tasks.

1. The `ticketsToString`, `vehiclesToString`, and `journeysToString` method look kind of similar. For every list type, there is a method. Can we have one method for all list types? Take a look at `<T extends Printable> String elementsListToString(List<T> elements)` in `ListingHelpers.java`.
1. The `findTicketById`, `findJourneyById`, and `findVehicleById` methods are similar as well. They just loop over a list of objects and check if any of the objects has `ID` equal to the wanted `ID`. Can we use generics to have only one method that goes through a list (no matter of what type, as long as it has a `getId()` method) and finds if one of the elements has the target `ID`? You are already given most of the method signature in `AgencyRepositoryImpl.java`, `<T extends {{???}}> T findElementById(List<T> elements, int id);`. What should go in the `{{?}}`?

### Sample Input

```
createbus 10 0.7
createairplane 230 1 true
createtrain 80 0.44 3
listvehicles
createjourney Sofia Turnovo 300 1
createjourney Sofia Turnovo 33 2
listjourneys
createticket 4 30.2
createticket 4 -1.5
createticket 5 100
listtickets
createticket pesho 100
createairplane 250 1 true
createticket 2 pipi
createairplane alabala 23 16
createjourney Sofia Turnovo 3000 1
createjourney SsdddddddddsdsssssssssSsdddddddddsdsssssssss Turnovo 3000 1
createjourney Sofia SsdddddddddsdsssssssssSsdddddddddsdsssssssss 3000 1
createtrain 80 0.08 3
createtrain 80 2.7 3
listtickets
createtrain 28 0.4 3
createtrain 152 0.4 3
listvehicles
exit
```

### Sample Output

```
Vehicle with ID 1 was created.
Vehicle with ID 2 was created.
Vehicle with ID 3 was created.
Bus ----
Passenger capacity: 10
Price per kilometer: 0.70
Vehicle type: LAND
####################
Airplane ----
Passenger capacity: 230
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
####################
Train ----
Passenger capacity: 80
Price per kilometer: 0.44
Vehicle type: LAND
Carts amount: 3
Journey with ID 4 was created.
Journey with ID 5 was created.
Journey ----
Start location: Sofia
Destination: Turnovo
Distance: 300
Vehicle type: LAND
Travel costs: 210.00
####################
Journey ----
Start location: Sofia
Destination: Turnovo
Distance: 33
Vehicle type: AIR
Travel costs: 33.00
Ticket with ID 6 was created.
Value of 'costs' must be a positive number. Actual value: -1.50.
Ticket with ID 8 was created.
Ticket ----
Destination: Turnovo
Price: 6342.00
####################
Ticket ----
Destination: Turnovo
Price: 3300.00
Invalid value for journey id. Should be a number.
Vehicle with ID 9 was created.
Invalid value for cost. Should be a number.
Invalid value for passenger capacity. Should be a number.
Journey with ID 10 was created.
The StartingLocation's length cannot be less than 5 or more than 25 symbols long.
The Destination's length cannot be less than 5 or more than 25 symbols long.
A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!
A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!
Ticket ----
Destination: Turnovo
Price: 6342.00
####################
Ticket ----
Destination: Turnovo
Price: 3300.00
A train cannot have less than 30 passengers or more than 150 passengers.
A train cannot have less than 30 passengers or more than 150 passengers.
Bus ----
Passenger capacity: 10
Price per kilometer: 0.70
Vehicle type: LAND
####################
Airplane ----
Passenger capacity: 230
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
####################
Train ----
Passenger capacity: 80
Price per kilometer: 0.44
Vehicle type: LAND
Carts amount: 3
####################
Airplane ----
Passenger capacity: 250
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
```
