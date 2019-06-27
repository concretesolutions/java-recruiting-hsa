//import 'package:flutter/material.dart';
import 'dart:async';
//import 'dart:convert';
import 'package:http/http.dart' as http;
import 'objects.dart';

const baseUrl = "http://10.90.52.146:8080/ecommerce";
List<Category> categories = new List<Category>();
List<Coupon> coupons = new List<Coupon>();

class APICoupons {
  static Future getCoupons() {
    var url = baseUrl + "/coupons";
    return http.get(url);
  }

  static Future getCurrentCoupons() {
    var url = baseUrl + "/coupons/currents";
    return http.get(url);
  }
}

class APICategories {
  static Future getCategories() {
    var url = baseUrl + "/categories";
    return http.get(url);
  }
}

/*
// Ignore
class EcommerceListScreen extends StatefulWidget {
  @override
  EcommerceListScreenState createState() => EcommerceListScreenState();
}

class EcommerceListScreenState extends State<EcommerceListScreen> {
  var coupons = new List<Coupon>();

  _getCoupons() {
    APICoupons.getCoupons().then((response) {
      setState(() {
        Iterable list = json.decode(response.body);
        coupons = list.map((model) => Coupon.fromJson(model)).toList();
      });
    });
  }

  _getCurrentCoupons() {
    APICoupons.getCurrentCoupons().then((response) {
      setState(() {
        Iterable list = json.decode(response.body);
        coupons = list.map((model) => Coupon.fromJson(model)).toList();
      });
    });
  }

  @override
  initState() {
    super.initState();
    //_getCoupons();
    _getCurrentCoupons();
  }

  dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Coupons List"),
        ),
        body: ListView.builder(
          itemCount: coupons.length,
          itemBuilder: (context, index) {
            return ListTile(title: Text(coupons[index].id));
          },
        ));
  }
}
*/