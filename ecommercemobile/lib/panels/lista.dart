import 'package:ecommercemobile/logic/objects.dart';
import 'package:flutter/material.dart';
import 'dart:convert';
import '../logic/logic.dart';

class DLista extends StatefulWidget {
   @override
  _DListaState createState() => new _DListaState();
}

class _DListaState extends State<DLista> {

  _getCategories() {
    APICategories.getNoTopCategories().then((response) {
      setState(() {
        Iterable list = json.decode(response.body);
        noTopCategories = list.map((model) => Category.fromJson(model)).toList();
      });
    });
  }

  @override
  void initState(){
    super.initState();
    this._getCategories();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      backgroundColor: Colors.blueGrey.shade100,
      appBar: AppBar(
        title: Text("Categorías"),
        ),
      body: new Stack(
        children: <Widget>[
          new Transform.translate(
            offset: new Offset(0.0, 0.0),
            child: new ListView.builder(
              shrinkWrap: true,
              padding: const EdgeInsets.all(0.0),
              scrollDirection: Axis.vertical,
              primary: true,
              itemCount: noTopCategories.length,
              itemBuilder: (BuildContext content, int index) {
                return AwesomeListItem(
                    title: noTopCategories[index].name,
                    content: noTopCategories[index].parentCategory != null ? noTopCategories[index].parentCategory : "Sin categoría"
                    );
              },
            ),
          ),
        ],
      ),
    );
  }
}

class AwesomeListItem extends StatefulWidget {
  String title;
  String content;

  AwesomeListItem({this.title, this.content});

  @override
  _AwesomeListItemState createState() => new _AwesomeListItemState();
}

class _AwesomeListItemState extends State<AwesomeListItem> {
  @override
  Widget build(BuildContext context) {
    return new Row(
      children: <Widget>[
        new Container(width: 10.0),
        new Expanded(
          child: new Padding(
            padding:
                const EdgeInsets.symmetric(vertical: 40.0, horizontal: 20.0),
            child: new Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                new Text(
                  widget.title,
                  style: TextStyle(
                      color: Colors.black,
                      fontSize: 30.0,
                      fontWeight: FontWeight.bold),
                ),
                new Padding(
                  padding: const EdgeInsets.only(top: 16.0),
                  child: new Text(
                    widget.content,
                    style: TextStyle(
                        color: Colors.lightBlue,
                        fontSize: 18.0,
                        fontWeight: FontWeight.bold),
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
