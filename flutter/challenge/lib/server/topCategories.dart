import 'package:challenge/app_config.dart';
import 'package:challenge/model/categoryModel.dart';
import 'package:challenge/widget/listMap.dart';
import 'package:challenge/widget/restCarousel.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import 'dart:convert';

class TopCategories extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _TopCategoriesState();
}

class _TopCategoriesState extends State<StatefulWidget> {
  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: getData(),
        builder: (context, snapshot) {
          return snapshot.data != null
              ? showCarousel(snapshot.data)
              : Center(child: CircularProgressIndicator());
        });
  }

  //This method will go and check the API to bring the top categories.
  //Then, it will return the data to the FutureBuilder.
  Future<List<CategoryModel>> getData() async {
    List<CategoryModel> list;

    try {
      var config = AppConfig.of(context);

      Uri url = Uri.base.resolve(config.apiBaseUrl + '/categories/top/');
      var res = await http.get(url, headers: {"Accept": "application/json"});

      //Only for debugging.
      //print(res.body);

      if (res.statusCode == 200) {
        var data = json.decode(res.body);
        list =
            data.map<CategoryModel>((i) => CategoryModel.fromJson(i)).toList();
      }

      //Only for debugging.
      //print("List Size: ${list.length}");
    } on Exception catch (e) {
      print('error caught: $e');
    }
    return list;
  }

  //This method will return a customized Carousel.
  Widget showCarousel(List<CategoryModel> categories) {
    return new RestCarousel<CategoryModel>(
      data: categories,
      child: new ListMap<Widget>().map(
        categories,
        (index, i) {
          CategoryModel c = i;

          Image img = c.getImage() != null
              ? Image.network(c.getImage(), fit: BoxFit.cover, width: 1000.0)
              : Image.asset('lib/images/carousel/default.jpg',
                  fit: BoxFit.cover, width: 1000.0);

          return Container(
            margin: EdgeInsets.all(5.0),
            child: ClipRRect(
              borderRadius: BorderRadius.all(Radius.circular(5.0)),
              child: Stack(children: <Widget>[
                img,
                Positioned(
                  bottom: 0.0,
                  left: 0.0,
                  right: 0.0,
                  child: Container(
                    decoration: BoxDecoration(
                      gradient: LinearGradient(
                        colors: [
                          Color.fromARGB(200, 0, 0, 0),
                          Color.fromARGB(0, 0, 0, 0)
                        ],
                        begin: Alignment.bottomCenter,
                        end: Alignment.topCenter,
                      ),
                    ),
                    padding:
                        EdgeInsets.symmetric(vertical: 10.0, horizontal: 20.0),
                    child: Text(
                      '${c.id} (${c.name})',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
              ]),
            ),
          );
        },
      ).toList(),
    );
  }
}
