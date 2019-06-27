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

class Coupon {
  String id;
  String description;
  String seller;
  String imageUrl;
  String expiresAt;

  Coupon(String id, String description, String seller, String imageUrl, String expiresAt) {
    this.id = id;
    this.description = description;
    this.seller = seller;
    this.imageUrl = imageUrl;
    this.expiresAt = expiresAt;
  }

  Coupon.fromJson(Map json)
      : id = json['id'],
        description = json['description'],
        seller = json['seller'],
        imageUrl = json['imageUrl'],
        expiresAt = json['expiresAt'];

  Map toJson() {
    return {'id': id, 'description': description, 'seller': seller, 'imageUrl': imageUrl, 'expiresAt': expiresAt};
  }
}

class ImageTypes {
  String small;
  String medium;
  String large;

  ImageTypes(String small, String medium, String large) {
    this.small = small;
    this.medium = medium;
    this.large = large;
  }

  ImageTypes.fromJson(Map json)
      : small = json['small'],
        medium = json['medium'],
        large = json['large'];

  Map toJson() {
    return {'small': small, 'medium': medium, 'large': large};
  }
}

class Category {
  String id;
  String name;
  String parentCategory;
  int relevance;
  ImageTypes images;
  String iconImage;

  Category(String id, String name, String parentCategory, int relevance, ImageTypes images, String iconImage) {
    this.id = id;
    this.name = name;
    this.parentCategory = parentCategory;
    this.relevance = relevance;
    this.images = images;
    this.iconImage = iconImage;
  }

  Category.fromJson(Map json)
      : id = json['id'],
        name = json['name'],
        parentCategory = json['parentCategory'],
        relevance = json['relevance'],
        images = json['images'],
        iconImage = json['iconImage'];

  Map toJson() {
    return {'id': id, 'name': name, 'parentCategory': parentCategory, 'relevance': relevance, 'images': images, 'iconImage': iconImage};
  }

}

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
