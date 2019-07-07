import 'package:challenge/server/otherCategories.dart';
import 'package:challenge/server/topCategories.dart';
import 'package:challenge/server/validCoupons.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  HomeScreen({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: ListView(
          padding: EdgeInsets.only(left: 15, right: 15),
          children: <Widget>[Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            _getSectionTitle("Top 5 Categories"),
            _getTop5Categories(),
            _getSectionTitle("Valid Coupons"),
            _getValidCoupons(),
            _getSectionTitle("Other Categories"),
            _getOtherCategories(),
          ],
        )]
        ),
      ),
    );
  }

  Padding _getSectionTitle(String title) {
    return Padding(
      padding: EdgeInsets.only(top: 20, bottom: 20),
      child: Text(
        '$title',
        style: TextStyle(
          fontSize: 30,
          fontWeight: FontWeight.bold,
        ),
        textAlign: TextAlign.left,
      ),
    );
  }

  TopCategories _getTop5Categories() {
    return new TopCategories();
  }

  ValidCoupons _getValidCoupons() {
    return new ValidCoupons();
  }

  OtherCategories _getOtherCategories(){
    return new OtherCategories();
  }
  
}
