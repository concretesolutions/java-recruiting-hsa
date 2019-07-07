import 'package:flutter/material.dart';
import 'package:meta/meta.dart';

class AppConfig extends InheritedWidget {
  AppConfig({
    @required this.appName,
    @required this.titleName,
    @required this.apiBaseUrl,
    @required Widget child,
  }) : super(child: child);

  final String appName;
  final String titleName;
  final String apiBaseUrl;

  static AppConfig of(BuildContext context) {
    return context.inheritFromWidgetOfExactType(AppConfig);
  }

  @override
  bool updateShouldNotify(InheritedWidget oldWidget) => false;
}