import 'package:flutter/material.dart';
import './contenedor/contenedor.dart';
//import './logic/logic.dart';

/*
void main() => runApp(
  new MaterialApp(
    home: EcommerceListScreen(),
  )
);
*/


void main(){
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
     // title: 'E-Commerce ',
      home: Contendora(),
      
    );
  }
}
