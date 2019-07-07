import 'package:carousel_slider/carousel_slider.dart';
import 'package:challenge/widget/listMap.dart';
import 'package:flutter/material.dart';

class RestCarousel<T> extends StatefulWidget {
  final List child;
  final List<T> data;
  RestCarousel({Key key, @required this.data, @required this.child}) : super(key: key);

  @override
  State<RestCarousel> createState() => _RestCarousel<T>(data, child);
}

class _RestCarousel<T> extends State<RestCarousel> {
  //Data: List returned by JSON.
  List<T> _data;

  //ChildMap: List of Widget to show.
  List _childMap;

  _RestCarousel(this._data, this._childMap); 

  @override
  Widget build(BuildContext context) {
    int _current = 0;

    return Column(children: [
      CarouselSlider(
        items: _childMap,
        autoPlay: true,
        enlargeCenterPage: true,
        aspectRatio: 2.0,
        onPageChanged: (index) {
          setState(() {
            _current = index;
          });
        },
      ),
      Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: new ListMap<Widget>().map(
          _data,
          (index, url) {
            return Container(
              width: 8.0,
              height: 8.0,
              margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 2.0),
              decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: _current == index
                      ? Color.fromRGBO(0, 0, 0, 0.9)
                      : Color.fromRGBO(0, 0, 0, 0.4)),
            );
          },
        ),
      ),
    ]);
  }



}