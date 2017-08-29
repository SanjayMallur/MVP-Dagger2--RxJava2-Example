# Holiday Pirates

This project is about showing list of user's post on Recyclerview with Title and Body. Clicking on each post takes to details page where user can see list of users with details like name, email id, first 20 photos of post and user comments on that post.

### Prerequisites

Things you need to install and build application:

```
Android Studio 2.3.3

Gradle 3.3

compileSdkVersion 25

buildToolsVersion "25.0.2"

minSdkVersion 15

targetSdkVersion 25
```

### Gradle dependencies

These are the list of gradle dependecies which are needs to be inclcuded in app build.gradle

```
compile "com.android.support:appcompat-v7:25.1.0"
compile "com.android.support:recyclerview-v7:25.1.0"
compile "com.android.support:design:25.1.0"
compile "com.android.support:cardview-v7:25.1.0"

// Dependencies for local unit and mock tests
testCompile "junit:junit:4.12"
testCompile "org.mockito:mockito-all:1.10.19"

//support libraries
compile 'com.github.bumptech.glide:glide:3.7.0'
compile 'com.artemzin.rxjava:proguard-rules:1.2.2.0'
compile 'com.google.dagger:dagger:2.7'
compile 'com.squareup.okhttp3:okhttp:3.4.1'
compile 'com.squareup.okhttp3:logging-interceptor:3.4.1'
compile 'io.reactivex:rxjava:1.2.2'
compile 'com.squareup.retrofit2:retrofit:2.1.0'
compile 'com.squareup.retrofit2:converter-gson:2.1.0'
compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
compile 'com.google.code.gson:gson:2.7'
compile 'com.tbruyelle.rxpermissions:rxpermissions:0.9.1@aar'
compile 'io.reactivex:rxandroid:1.2.1'
provided 'javax.annotation:jsr250-api:1.0'
apt 'com.google.dagger:dagger-compiler:2.7'
```


### Running the units tests

1. Go to /src/test/java
2. Right click on java and "Run tests in java"
3. You can check the results

###  Running the mock tests


Change Build Variant to mockDebug and Sync project
```

   3. Run application and verify mock data on UI 


## Built With

* [Retrofit2](https://github.com/square/retrofit) - Type-safe HTTP client for Android
* [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android
* [Dagger2](https://github.com/google/dagger) - A fast dependency injector for Android and Java
* [RxJava](https://github.com/ReactiveX/RxJava) - A library for composing asynchronous and event-based programs using observable sequences for the Java VM.


## Architecture used
##### MVP why ?

This application is using MVP pattern. Because in this application we have the model Post,Comment,Photos and User. We are using the Repository pattern in order to provide the data we are going to use in our different builds. This pattern allows us to have different datasources per build flavour we have on our build.gradle file. In our case, in our test build we can load mock data with our fakeApiService instead of loading the real data from server. This pattern allows you to have an independent datasource that can be used from different origins (DB, API, mock).

##### Details of Repository Pattern used

Model

1.  We have a MainRepository Interface. This interfacce will contain all the methods we currently need to obtain the data from our datasource.
2.  Then we have a SubRepositories class. This class will be in charge of getting our correct datasource. 
3.  The only datasource is all Manager classes. This classes contains the implementation of  all Repository interface. This datasource will provide the already loaded posts in the view or call the webservice get if it is required.
4.  Our Injection class (One in production package and another one in mock package). This class is made so we can choose which API layer we should use. In this case we use PostServeAPIImp, we might aswell use a MockServerAPIImp.
5.  In summary, We have separated all our datasources from each other, making it easier to change between them. Also they are separated from the API layer we use. Both of them can use different layers without having to change any code.

View 

The view layer is in charge of displaying the data and receiving the user interactions. If an user makes an interaction it will redirect it to the instance of the Presenter it has. After the presenter handles the logic, it will send the data to show to the view. Important: Not all the views needs to implement MVP pattern. Static data doesn't require this implementation.

Presenter

The Presenter layer is in charge of the communication between the View and the Model. It will handle all your business logic and is in charge of delivering it where it was required.


## Author

* **Sanjay Mallur** -  [Github](https://github.com/SanjayMallur)

