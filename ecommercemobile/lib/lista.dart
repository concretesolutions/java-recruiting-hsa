import 'package:flutter/material.dart';

class DLista extends StatefulWidget {
   @override
  _DListaState createState() => new _DListaState();
}

class _DListaState extends State<DLista> {
  var data = [
    {"title": "Titulo 1",      "content": "Contenido 1"    },    {"title": "Titulo 2",      "content": "Contenido 2"    },
    {"title": "Titulo 3",      "content": "Contenido 3"    },    {"title": "Titulo 4",      "content": "Contenido 4"    },
    {"title": "Titulo 5",      "content": "Contenido 5"    },    {"title": "Titulo 6",      "content": "Contenido 6"    },
    {"title": "Titulo 7",      "content": "Contenido 7"    },    {"title": "Titulo 8",      "content": "Contenido 8"    },
    {"title": "Titulo 4",      "content": "Contenido 4"    }   ];

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      backgroundColor: Colors.white,
      
      body: new Stack(
        children: <Widget>[
          new Transform.translate(
            offset: new Offset(0.0, MediaQuery.of(context).size.height * 0.1050),
            child: new ListView.builder(
              shrinkWrap: true,
              padding: const EdgeInsets.all(0.0),
              scrollDirection: Axis.vertical,
              primary: true,
              itemCount: data.length,
              itemBuilder: (BuildContext content, int index) {
                return AwesomeListItem(
                    title: data[index]["title"],
                    content: data[index]["content"]);
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
                      color: Colors.grey.shade800,
                      fontSize: 18.0,
                      fontWeight: FontWeight.bold),
                ),
                new Padding(
                  padding: const EdgeInsets.only(top: 16.0),
                  child: new Text(
                    widget.content,
                    style: TextStyle(
                        color: Colors.grey.shade500,
                        fontSize: 12.0,
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
