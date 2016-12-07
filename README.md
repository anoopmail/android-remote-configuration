# android-remote-configuration
A library to keep your configuration on a remote server and let the android application pull from there. Uses Shared Preferences for storage. Features fallback/default configuration support.

[![Release](https://img.shields.io/github/release/anoopmail/android-remote-configuration.svg?label=Remote Configuration)](https://jitpack.io/#anoopmail/android-remote-configuration)

## Usage

### Gradle dependency

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.github.anoopmail:android-remote-configuration:v1.1'
}
```

### Sample Code

In you activity
```java
RemoteConfiguration remoteConfiguration = RemoteConfiguration.getInstance();
remoteConfiguration.fetch("https://api.myjson.com/bins/1sirp", context); // Initiate a network read, run asynchronously
Config r = (Config) remoteConfiguration.get(this, Config.class);
Log.d("Welcome text: ", r.welcomeText);
```
the configuration file hosted should be in JSON format. sample [here](https://api.myjson.com/bins/1sirp)

```java
{
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
Add network permissions to the mansifest file.
```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
```
