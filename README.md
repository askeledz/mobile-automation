# cross-platform-mobile testing
An Appium (java) example project for cross platform testing of an Android and an iOS application


### Android Studio (SDK and AVD Manager)
--------------------
- install Android studio.
- https://developer.android.com/index.html
- Set PATH:
  - export ANDROID_HOME=/Users/<username>/Library/Android/sdk
  - export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
  - export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin
- To open the SDK Manager from Android Studio, click Tools > Android > SDK Manager.
### Create AVD
-------------
- Create AVD with Android Strudio.
   - https://developer.android.com/studio/run/managing-avds.html
- To open the AVD Manager from Android Studio, click Tools > Android > AVD Manager (Create Virtual device).
- Then you can check
  - #emulator -list-avds
    - (e.g. Andrej_Pixel_API_26)
- Go to Emulator folder:
  - #cd ~/Library/Android/sdk/tools
- Start AVD:
  - #emulator -avd Andrej_Pixel_API_26
  - You can start it from AVD Manager (play button)

### Appium install
--------------------
- Install appium:
  - #npm install -g appium
- Check version:
  - #appium -v
- Run Appium:
  - #appium
- You are ready for iOS and ANDROID test. Make sure you set DesiredCapabilities according to you iOS dvice or AVD. 

### Android-Inspector: How to get locators via UiAutomatorViewer
----------------------------------------------

- Once the android sdk path is set on the machine, open the terminal and type
   - $uiautomatorviewer


### iOS-Inspector:
*******************************
github location: https://github.com/mykola-mokhnach/Appium-iOS-Inspector

Clone the project and open html page which is inside. 
Please be aware that simulator and Appium should be up and running before.
HINT: Place the braekpoint where you want the execution to stop and run the test in debug mode. 
      So you will be able to inspect the exact page you want.

### Run XCode and start app with simulator
---------------------------------------
you are ready for iOS test.

#### Macaca Inspector if you need:
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

#### For real device:
---------
It can be used to inspect real devices same steps above apply only instead of using the simulator you would grab the UUID of the real device. This can be done with the following: run instruments -s devices in Terminal


#### CLEAR ALL SIMULATORS
---------
echo "Shutting down the simulator app"
osascript -e 'quit app "Simulator"'

echo "Making sure ALL simulators are shutdown"
xcrun simctl list | grep Booted | grep -e "[0-9A-F\-]\{36\}" -o | xargs xcrun simctl shutdown

echo "Erasing apps from all simulators and resetting back to clean state"
xcrun simctl erase all

echo "Killing com.apple.CoreSimulator.CoreSimulatorService"
killall -9 com.apple.CoreSimulator.CoreSimulatorService

### Reports
- /target/surefire-reports/index.html

### Jenkins Setup
- Install Jenkins:
  - $brew install jenkins
- Run Jenkins
  - $jenkins

NOTE: For very first start Jenkins needs to be activated. Copy password from console (should be on the screen) and activate Jenkins on Browser (localhost:8080) and continue installation from browser.

- Before start we need to setup Maven:
  - Manage Jenkins --> Global Tool Configuration and setup Maven as following:
    - Name: mavenname
    - Install Automatically = true
    - Install from Apache (Version 3.5.2)
    
- New job (item):
    - Name: projectname
    - Freestyle project
    - Config: 
      - Source Code Management: 
        - Git (e.g. projecturl.git ) and credentials
      - Build: 
        - Maven version: (e.g. mavenname)
        - Goals: clean test -am -DtestSuite=testnglocal.xml
        - Advanced: POM: pom.xml

### Set up Test Results Analyzer Plugin for Jenkins
- Manage Jenkins --> Manage Plugins (e.g search for "Test Results Analyzer Plugin")
- Install plugin and restart Jenkins.
- At Jenkins dashboard, select <your project> / Configure
- Under Post-build Actions tab, select Add post-build action and choose Publish JUnit test result report
- At Test report XMLs, enter the path to your .xml report file, the analyzer will find data here to create charts, in my    case, it's target/surefire-reports/*.xml, you can edit the path to handle more tests.
