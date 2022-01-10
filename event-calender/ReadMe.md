Events:

    An event would typically consist of {start, end, location, owner, user-list, title}
    Events can either be like meetings (with a dedicated location and appropriate guest-list) or as well be like holidays, birthdays, reminders etc.
    An event once created, can be either accepted or rejected by the constituent users – if neither it should be in neutral state

Implement any 2 API’s:


- User API to create, update or cancel their events. Create/Update operation should be successful only in case of no conflicts of resources
- Given a user, provide an API to fetch list of event/meetings for the given date range.
- Given a Meeting ID, provide an API to give details of invitees with their responses i.e.. ACCEPT, DECLINE etc..
- API to find available rooms in specific building at particular time-slot

Expectations:

    Code quality should be production ready for merge and deployment
    Guidelines have the highest weightage than finishing more api’s
    Code should be demo able. create the sample data yourself in a file, test case or main driver program itself(no external data store). Don’t spend time parsing the inputs.
    Code should be readable, modular(no monoliths), testable, extensible with proper naming conventions
    Code should handle edge cases properly and fail gracefully

Guidelines:

- Define a detailed object model for entities required by system
- Make proper use of inheritance, Abstraction, interfaces, exception handling
- Have proper commenting in code and should follow best coding practices
- Use design patterns like Builder, Factory, Visitor etc wherever applicable
- Justify your coding choices i.e.. why did you choose to define a separate function for a feature or why did you not define a constructor for initialising class
    Define Enums, Singleton classes wherever applicable
    Separation of concern is addressed
    Implement unit test cases for key sections of his/her code
    Use Java 8/7 features like functional interfaces, Auto Closable resources etc..
