import 'package:flutter/material.dart';
import '../carousel/carousel.dart';
import '../lista.dart';
//import '../logic/logic.dart';

class Contendora extends StatelessWidget{
  @override 
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.topRight,
      child: Column(children: <Widget>[
        Expanded(
          child: Carousel(),
        ),
        Expanded(
          child: CouponsCarousel(),
        ),
        Expanded(
          child: new DLista(),
        ),
      ],)
    );
  }
}