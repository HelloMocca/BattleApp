#BattleApp
BattleApp serves information of Starcraft League in Korea Republic of, written in Android SDK / Java. This Android Application Project developed as Android Studio IDE.
See more information and fork at https://github.com/HelloMocca/BattleApp.git

#App Screen Shot
![App Splash](http://hellomocca.github.io/projects/battleapp/splash.png)
![App Main](http://hellomocca.github.io/projects/battleapp/shot_01.png)
![Player Search](http://hellomocca.github.io/projects/battleapp/shot_02.png)
![Player Information](http://hellomocca.github.io/projects/battleapp/shot_03.png)
![Matching Simulation](http://hellomocca.github.io/projects/battleapp/shot_04.png)

##Support Android SDK Version
minSdkVersion: 16
targetVersion: 22


##Version History
__[Latest Version] 0.7.1__
* Follows BugFix
  * The Activity restart when searching player first time.
  * app OOM when scrolling league's gamelist(LeagueArchiveActivity)
* Splash Activity added
  * Splash Activity started when onCreate MainActivity.
  * Splash Activity checks internet connection status.
  * If internet has disconnected, Splash Activity shows the Alert Dialog.
  * Splash Activity's no-History attribute is true.
* BitmapDecoder
  * BitmapDecode control Bitmap Resource to resizing.
  * decodeBitmapFromResource get resource Id, width size and height size then return the efficiency resized Bitmap object.
* NetworkManager
  * NetworkManager contains connection check method and alert dialog method.
* Published 28 August, 2015

__0.6.1__
* Remove unabled activities and layout
* Show winner namd as #FFBB00 color at game list
* Exist Bug
  * The Activity restart when searching player first time.
  * app OOM when scrolling league's gamelist(LeagueArchiveActivity)
* Published 27 August, 2015

__0.5.1__
* Add Volley Library for HTTP Request.
* Add Gson Library for parsing JSON data.
* MainActivity Modifed
  * Remove unable menu Button
  * Remove Live Game status dashboard
  * Change Button Design
* PlayerInfoActivity
  * Add BarChart View to show the player's game record.
* LeagueListActivity
  * League List data has provided from BattleApp Server API.
  * App shows the playlist when user selects the league.
* MatchingActivity
  * App calculate the match result using 5 facts( total record, vs.each other, recent 5games, vs.opposing race, ).
* Manifest
  * All activity's launchmode changed to singleTop
* Exist Bug
  * The Activity restart when searching player first time.
* Published 27 August, 2015

__0.4.3__
* Change ListView to CustomListView using PlayerListAdapter
  * PlayerListAdapter(Context, ArrayList<Player>)
* Published 18 August, 2015

__0.4.2__
* Chart draw using animation effect
  * see animationDraw method in BarChart class
* Modify Button to ImageButton (@ MainActivity)
* Published 17 August, 2015

__0.4.1__
* Remove Title Bar
* Create Dummy Views (not connected to Network yet)
  * MatchingActivity
  * MatchingResultFragment
  * PlayerListFragment
* Create Parcelable class "Player" for transfer Player Information
* Create customView "BarChart"
  * Using Canvas
  * Drawing diversing chart of Matching Result as FieldData
* Create class FieldData
  * FieldData contains FieldName and Columns(String Array)
* Published 11 August, 2015

__0.3.1__
* Implement activity change from MainActivity to others
* Create Dummy Views (not connected to Network yet)
  * ListView of PlayerActivity
  * View of PlayerInfoActivity
  * ListView of LeagueListActivity
  * ListView of LeagueArchiveActivity
* Implement getViews and setViewEvent to each Activities
  * getViews: Initialization Views(ListView, EditText, Button ...)
  * setViewEvent: Setting click event on Buttons or Items of ListView
* Published 6 August, 2015

__0.2.1__
* Define All Layout of Activities
* Add Fragments Layout and Fragment Subclass for Matching Activity
  * PlayerListFragment
  * MatchingResultFragment
* Published 28 July, 2015

__0.1.1__
* Implement Button onClickLister to startActivity (MainActivity -> OtherActivities)
* Modify MainActivity's export attribute to "true"
* Modify MaxRecent value 3 to 1 (The BattleApp must be 'One' task)
* Published 27 July, 2015

__0.0.1__
* Initialize the BattleApp Project
* Add Activities
  * MainActivity
  * ScheduleActivity
  * LeagueActivity
  * PlayerActivity
  * PlayerInfoActivity
  * LeagueListActivity
  * LeagueArchiveActivity
  * MatchingActivity
* Add access Internet Permission
* Initialize Activity transaction methods
* Published 24 July, 2015

