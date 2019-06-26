import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;

const baseUrl = "http://192.168.0.15:8080/ecommerce";

class APICoupons {
  static Future getCoupons() {
    var url = baseUrl + "/coupons";
    return http.get(url);
  }
}

class APICategories {
  static Future getCategories() {
    var url = baseUrl + "/categories";
    return http.get(url);
  }
}

class Coupon {
  String id;
  String description;

  Coupon(String id, String description) {
    this.id = id;
    this.description = description;
  }

  Coupon.fromJson(Map json)
      : id = json['id'],
        description = json['description'];

  Map toJson() {
    return {'id': id, 'description': description};
  }
}

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

  @override
  initState() {
    super.initState();
    _getCoupons();
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
