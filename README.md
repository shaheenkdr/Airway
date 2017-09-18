# Airway

Airway was designed to be a digital assistant for air travellers and was developed as part of AirBerlin hackathon. The app allows to book flights, track flights, calculate delay index at airports, play games, meditatate in between, get review of places etc. 

## Features

* Air ticket booking
* in app games
* Flight tracker
* Airport delay index

## Screens

<img src="https://github.com/shaheenkdr/Airway/blob/master/app/src/main/res/photo482391180746794991%20(1).jpg" width="360" height="640" />

<img src="https://github.com/shaheenkdr/Airway/blob/master/app/src/main/res/photo482391180746794990.jpg" width="360" height="640" />


## Work with Source code

The app requires [flightstats](https://developer.flightstats.com/) API, and the key has to be obtained from Flightstats and it has to be replaced here in `/Utilities/DeveloperKey.java`. 


```
public class DeveloperKey {


    public static final String DEVELOPER_KEY = "YOUR API KEY HERE";

}

```

## Libraries

* [Crashlytics](https://try.crashlytics.com/)
* [Material Dialogs](https://github.com/afollestad/material-dialogs)
* [Google design support library](https://developer.android.com/training/material/design-library.html)
* [Youtube Android player API](https://developers.google.com/youtube/android/player/)
* [Easy Android Animations](https://github.com/2359media/EasyAndroidAnimations)
* [MP Android chart](https://github.com/PhilJay/MPAndroidChart)
* [Google Play Services](https://developers.google.com/android/guides/setup)
* [Picasso](http://square.github.io/picasso/)
* [Retrofit](http://square.github.io/retrofit/)
* [GSON](https://github.com/google/gson)
* [EventBus](https://github.com/greenrobot/EventBus)

## License

    Copyright 2016 Shaheen A Kader

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
