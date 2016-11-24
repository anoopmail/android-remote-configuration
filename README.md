# android-remote-configuration
A library to keep your configuration on a remote server and let the android application pull from there. Uses Shared Preferences for storage. Features fallback/default object support.

[![Release](https://img.shields.io/github/release/anoopmail/android-remote-configuration.svg?label=Remote Configuration)](https://jitpack.io/#anoopmail/android-remote-configuration)

In you activity
```java
RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();
remoteConfiguration.fetch("https://api.myjson.com/bins/3dm8c", context); // Initiate a network read, run asynchronously
Person r = (Person) remoteConfiguration.get(Person.class, context);
Log.d("Person.name = ", r.name);
```
and the person class with default values
```java
public class Person {
        String name = "John";
        int age = 21;
}
```
You application requires network permission as below in the mansifest file.
```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
```
