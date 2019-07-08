import 'package:challenge/challengeApp.dart';
import 'package:flutter/material.dart';

import 'package:challenge/app_config.dart';


void main() {
  var configuredApp = new AppConfig(
    appName: 'Java Concrete Challenge',
    titleName: 'Challenge - Testing',
    apiBaseUrl: 'http://localhost:8080/', //Change the URL to the one where you have deployed the API.
    child: new ChallengeApp(),
  );

  runApp(configuredApp);
}

