import 'package:challenge/challengeApp.dart';
import 'package:flutter/material.dart';

import 'package:challenge/app_config.dart';


void main() {
  var configuredApp = new AppConfig(
    appName: 'Java Concrete Challenge',
    titleName: 'Challenge - Testing',
    apiBaseUrl: 'http://concrete-tomcat.snowcorp.cl/challenge/',
    child: new ChallengeApp(),
  );

  runApp(configuredApp);
}

