import 'package:flutter/material.dart';
import '../panels/carousel.dart';
import '../panels/lista.dart';

class Contendora extends StatelessWidget{
  @override 
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.topRight,
      child: Column(
        children: <Widget>[
          Expanded(
            child: CategoriesCarousel(),
          ),
          Expanded(
            child: CouponsCarousel(),
          ),
          Expanded(
            child: DLista(),
          ),
      ],)
    );
  }
}