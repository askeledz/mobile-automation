# cross-platform-mobile testing
An Appium (java) example project for cross platform testing of an Android and an iOS application

Instructions:

Android SDK
--------------------
install and set PATH.

Android Studio
--------------------
install and create AVD.


AVD
-------------
- Create AVD with Android Strudio.
   - https://developer.android.com/studio/run/managing-avds.html
- Then you can check
  - #emulator -list-avds
    - (e.g. Andrej_AVD_Nexus_5X_API_24)
- Go to Emulator folder:
  - #cd ~/Library/Android/sdk/tools
- Start AVD:
  - #emulator -avd Andrej_AVD_Nexus_5X_API_24

- Start Appium and you are ready for ANDROID test. MAke sure you set DesiredCapabilities according to you AVD. 

Appium-iOS-Inspector:
*******************************
github location: https://github.com/mykola-mokhnach/Appium-iOS-Inspector

Clone the project and open html page wich is inside. 
Please be aware that simulator and Appium should be up and running before.

Macaca Inspector if you need:
-----------------------
https://bitbar.com/appium-1-6-3-tips-for-identifying-ids-elements-and-xpath-values/

Make sure you build app in XCode on specific simulator and that you use this simulator and this app. !!!!!!

You can install it if you have a .app file already built locally
1. Start simulator
#alias simulator='open /Applications/Xcode.app/Contents/Developer/Applications/Simulator.app'
Run simulator:
#simulator
2. Run ” xcrun simctl install 7C2900B5-1B0D-42FD-9B6E-98EF37576570 /Users/<user>/Documents/Private/development/app_ios/UICatalog.app
 e.g xcrun simctl install 7C2900B5-1B0D-42FD-9B6E-98EF37576570 /Users/<user>/Library/Developer/Xcode/DerivedData/UICatalog-gemsayjuidjhyvawjrhaqtavedzw/Build/Products/Debug-iphonesimulator/UICatalog.app

You can run the following to see IP and port:
app-inspector -u identifier --verbose
e.g.
Inspector start at:
http://192.168.1.8:5678

Run inspector:
#app-inspector -u 7C2900B5-1B0D-42FD-9B6E-98EF37576570
#app-inspector -u C4EF6D65-3027-400F-B3D4-ECEE778BA0BC --verbose

For real device:
---------
It can be used to inspect real devices same steps above apply only instead of using the simulator you would grab the UUID of the real device. This can be done with the following: run instruments -s devices in Terminal


CLEAR ALL SIMULATORS
---------
echo "Shutting down the simulator app"
osascript -e 'quit app "Simulator"'

echo "Making sure ALL simulators are shutdown"
xcrun simctl list | grep Booted | grep -e "[0-9A-F\-]\{36\}" -o | xargs xcrun simctl shutdown

echo "Erasing apps from all simulators and resetting back to clean state"
xcrun simctl erase all

echo "Killing com.apple.CoreSimulator.CoreSimulatorService"
killall -9 com.apple.CoreSimulator.CoreSimulatorService
