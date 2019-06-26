import 'package:flutter/material.dart';
import './logic/logic.dart';

void main() => runApp(ECommerce());

class ECommerce extends StatelessWidget {
  @override
  build(context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'My Http App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: EcommerceListScreen(),
    );
  }
}
