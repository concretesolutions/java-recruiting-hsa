import 'package:challenge/app_config.dart';
import 'package:challenge/screen/homeScreen.dart';
import 'package:challenge/screen/splashScreen.dart';
import 'package:flutter/material.dart';

class ChallengeApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    var config = AppConfig.of(context);

    return MaterialApp(
      title: config.appName,
      theme: ThemeData(
        brightness: Brightness.dark,
        primarySwatch: Colors.purple,
      ),
      home: new SplashScreen(),
      routes: <String, WidgetBuilder>{
        '/HomeScreen': (BuildContext context) => new HomeScreen(title: config.titleName)
      },
    );
  }
}
