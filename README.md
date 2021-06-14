# KCiTunesAlbums
A Sample app using the iTunes Search API

## App Functions
-Displays a list of albums obtained from iTunes Search API
-Clicking each item will show a detailed view of the selected item
-User session is saved as the app closes. When app reopens, user will be redirected to the last screen viewed e.g. Specific Album Item, Main List Screen

## Language
This project is made using Kotlin

## Configurations
Gradle configs 

````
buildFeatures {
        viewBinding true
    }
````

Used viewBinding in the project for easy access to layout views and lesser code. 

 
## Third-party libraries used for this project
-Retrofit: for easy implementation of REST API calls
-Okhttp: in combination with Retrofit to log API request and response
-Moshi: JSON converter library for serializing and deserializing objects
-Room Persistence: database library to easily manipulate SQLite

## Architecture
MVP (Model View Presenter) design pattern is used in this project.

Why MVP?
-It's very understandable and easier code maintenance because it separated application's model, view and presenter in layers
-Clear separation of responsibilities between components. This separation allows for an easier understanding and maintenance of the code base.
-Modularity allows you to switch to a different implementation of view component in order to completely change application's UI, while all other components remain intact.
-Easier Testing


