import 'package:flutter/material.dart';
import 'dart:convert';
import '../logic/logic.dart';
import '../logic/objects.dart';

/*
 * Coupons
 */
class CouponsCarousel extends StatefulWidget {
  @override
  _CouponsCarouselState createState() => _CouponsCarouselState();
}

class _CouponsCarouselState extends State<CouponsCarousel> {
  PageController _pageController;
  int currentPage=0;

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
      backgroundColor: Colors.blueGrey.shade100,
      appBar: AppBar(
        title: Text("Cupones disponibles"),
      ),
      body: Center(
        child: Container(
          child: PageView.builder(
            onPageChanged: (value){
              setState((){
                currentPage=value;
              });
            },
            controller: _pageController,
            itemCount: coupons.length,
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
          child: SizedBox(
            height: Curves.easeOut.transform(value) * 200,
            width: Curves.easeOut.transform(value) * 150,
            child: child,
          ),

        );
      },
      child: Container(
        margin: const EdgeInsets.all(10.0),
        color: index % 2 == 0 ? Colors.lightBlue : Colors.lightGreen,
        child: Center(
          child: Text(coupons[index].description, style: TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),),
        ) 
      )
    );
  }
}

/*
 * Categories
 */
class CategoriesCarousel extends StatefulWidget {
  @override
  _CategoriesCarouselState createState() => _CategoriesCarouselState();
}

class _CategoriesCarouselState extends State<CategoriesCarousel> {
  PageController _pageController;
  int currentPage=0;

  _getCategories() {
    APICategories.getCategories().then((response) {
      setState(() {
        Iterable list = json.decode(response.body);
        categories = list.map((model) => Category.fromJson(model)).toList();
      });
    });
  }

  @override
  void initState(){
    super.initState();
    this._getCategories();
    _pageController = PageController(
      initialPage:currentPage, keepPage:false, viewportFraction:0.5,
    );    
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blueGrey.shade100,
      appBar: AppBar(
        title: Text("Top categorías"),
      ),
      body: Center(
        child: Container(
          child:PageView.builder(
            onPageChanged: (value){
              setState((){
                currentPage=value;
              });
            },
            controller: _pageController,
            itemCount: categories.length,
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
          child: SizedBox(
            height: Curves.easeOut.transform(value) * 200,
            width: Curves.easeOut.transform(value)*150,
            child: child,
          ),

        );
      },
      child: Container(
        margin: const EdgeInsets.all(10.0),
        color: index % 2 == 0 ? Colors.lightBlue : Colors.lightGreen,
        child: Column(
          children: <Widget>[
            Text(categories[index].name, style: TextStyle(fontSize: 30.0, fontWeight: FontWeight.bold),),
            categories[index].images.small != null ?
            Image.network(categories[index].images.small, fit: BoxFit.cover,) :
            Image.asset('assets/nodisponible.png', fit: BoxFit.cover,),
          ],
        ) 
      )
    );
  }
}

