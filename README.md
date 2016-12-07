# android-remote-configuration
A library to keep your configuration on a remote server and let the android application pull from there. Uses Shared Preferences for storage. Features fallback/default object support.

[![Release](https://img.shields.io/github/release/anoopmail/android-remote-configuration.svg?label=Remote Configuration)](https://jitpack.io/#anoopmail/android-remote-configuration)

In you activity
```java
RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();
remoteConfiguration.fetch("https://api.myjson.com/bins/1sirp", context); // Initiate a network read, run asynchronously
Person r = (Person) remoteConfiguration.get(Person.class, context);
Log.d("Person.name = ", r.name);
```
the configuration file hosted should be in JSON format. sample [here](https://api.myjson.com/bins/1sirp)

```java{
   "welcomeText": "Hi user",
   "isLoginAllowed": true
   }
```

and the person class with default values
```java
public class Configuration {
        String welcomeText = "Hi user";
        boolean isLoginAllowed = true;
}
```
You application requires network permission as below in the mansifest file.
```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
```
