import 'package:flutter/material.dart';
import '../logic/logic.dart';
import 'dart:convert';

// Coupons
class CouponsCarousel extends StatefulWidget {
  @override
  _CouponsCarouselState createState() => _CouponsCarouselState();
}

class _CouponsCarouselState extends State<CouponsCarousel> {
  PageController _pageController;
  int currentPage=0;

  // Coupons list from API ECommerce
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
  void initState(){
    super.initState();
    this._getCurrentCoupons();
    _pageController = PageController(
      initialPage:currentPage, keepPage:false, viewportFraction:0.5,
    );    
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Container(
          child:PageView.builder(
            onPageChanged: (value){
              setState((){
                currentPage=value;
              });
            },
            controller: _pageController,
            itemBuilder: (context,index)=>animateItemBuilder(index),
            
          )
        ),
      ),
    );
  }  
  animateItemBuilder(int index){
    return AnimatedBuilder(
      animation: _pageController,
      builder:(context,child){
        double value =1;
        if(_pageController.position.haveDimensions){
          value = _pageController.page - index;
          value = (1- (value.abs()*0.5)).clamp(0.0, 1.0);
        }

        return Center(
          child:SizedBox(
            height: Curves.easeOut.transform(value) * 200,
            width: Curves.easeOut.transform(value) * 150,
            child: child,
          ),

        );
      },
      child: Container(
        margin: const EdgeInsets.all(10.0),
        color: index % 2 == 0 ? Colors.lightBlue : Colors.lightGreen,
        child: FlutterLogo(),
      )
    );
  }
}



class Carousel extends StatefulWidget {
  @override
  _CarouselState createState() => _CarouselState();
}

class _CarouselState extends State<Carousel> {
  PageController _pageController;
  int currentPage=0;

  @override
  void initState(){
    super.initState();
    _pageController = PageController(
    initialPage:currentPage, keepPage:false, viewportFraction:0.5,
    );    
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Container(
          child:PageView.builder(
            onPageChanged: (value){
              setState((){
                currentPage=value;
              });
            },
            controller: _pageController,
            itemBuilder: (context,index)=>animateItemBuilder(index),
            
          )
        ),
      ),
    );
  }  
  animateItemBuilder(int index){
    return AnimatedBuilder(
      animation: _pageController,
      builder:(context,child){
        double value =1;
        if(_pageController.position.haveDimensions){
          value = _pageController.page - index;
          value = (1- (value.abs()*0.5)).clamp(0.0, 1.0);
        }

        return Center(
          child:SizedBox(
            height: Curves.easeOut.transform(value) * 200,
            width: Curves.easeOut.transform(value)*150,
            child: child,
          ),

        );
      },
      child:Container(
        margin: const EdgeInsets.all(10.0),
        color: index % 2 == 0 ? Colors.lightBlue : Colors.lightGreen,
        child: FlutterLogo(),
      )
    );
  }
}

