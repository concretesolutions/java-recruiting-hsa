import 'package:challenge/app_config.dart';
import 'package:challenge/model/categoryModel.dart';
import 'package:challenge/widget/listMap.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import 'dart:convert';

class OtherCategories extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _OtherCategoriesState();
}

class _OtherCategoriesState extends State<StatefulWidget> {
  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: getData(),
        builder: (context, snapshot) {
          return snapshot.data != null
              ? showTable(snapshot.data)
              : Center(child: CircularProgressIndicator());
        });
  }

  //This method will go and check the API to bring the top categories.
  //Then, it will return the data to the FutureBuilder.
  Future<List<CategoryModel>> getData() async {
    List<CategoryModel> list;

    try {
      var config = AppConfig.of(context);

      Uri url = Uri.base.resolve(config.apiBaseUrl + '/categories/notop/');
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

  Widget showTable(List<CategoryModel> categories) {

    Table tab = Table(
      border: TableBorder.all(color: Theme.of(context).accentColor),
      children: ListMap<TableRow>().map(categories, (index, i) {
        CategoryModel c = i;
        return TableRow(children: [
          TableCell(
            child: Padding(
              padding: EdgeInsets.only(left: 5, top: 3, bottom: 3),
              child: Text(
              "${c.name}",
              style: Theme.of(context).textTheme.title,
            ),
          )),
        ]);
      }),
    );

    return tab;
  }
}
