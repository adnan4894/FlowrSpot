# FlowrSpot

## Functionality
1: Display scrollable list of available flowers with recyclerView(pagination)</br>
2: Live search for a specific flower by name or latin name <br/>
3: Bottom-navigation menu, currently navigating to blank fragment

## Architecture
Architecture used in this project MVVM (Model-View - ViewModel).</br>
-Fragment contains code for updating UI and registering events; In some cases, view has direct  access to data values and observe for their changes.</br>
-ViewModel contains logic and data that are used in fragment and views. </br>
MVVM cleanly separates the user interface from the application logic.

## Dependencies 
Retrofit with Moshi for api request and converting json to Kotlin object.</br>
Coroutines for maintaining a synchronous way of coding without dealing with hard readable callbacks.</br>
Glide used as an Image loader.</br>
RecyclerView is used for displaying list of flowers. At this point, RecyclerView is not necessary but, as the api data grow in the future it will be useful.</br>
Hilt used for dependency injection
Room database
Firebase crashlytics

## Path for improvements
- Separate data layer (Network, Local)
- Update the error handling in the base classes.
- Memory management should be updated in the base fragments and viewmodels
- Use room for offline mode
- Add CI/CD

### Most of the recources used in this project are xml converted from svg for maintaining image quality









