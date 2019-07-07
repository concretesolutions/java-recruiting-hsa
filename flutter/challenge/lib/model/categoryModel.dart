class CategoryModel {
  String id;
  String name;
  int relevance;

  String iconImageUrl;
  String largeImageUrl;
  String mediumImageUrl;
  String smallImageUrl;

  List<CategoryModel> subcategories;

  CategoryModel(
      {this.id,
      this.name,
      this.relevance,
      this.iconImageUrl,
      this.largeImageUrl,
      this.mediumImageUrl,
      this.smallImageUrl,
      this.subcategories});

  factory CategoryModel.fromJson(Map<String, dynamic> json) {
    return CategoryModel(
        id: json["id"],
        name: json["name"],
        relevance: json["relevance"],
        iconImageUrl: json["iconImageUrl"],
        largeImageUrl: json["largeImageUrl"],
        mediumImageUrl: json["mediumImageUrl"],
        smallImageUrl: json["smallImageUrl"],
        subcategories: json["subcategories"] == null
            ? null
            : json["subcategories"]
                .map<CategoryModel>((i) => CategoryModel.fromJson(i))
                .toList());
  }

  String getImage() {
    String s = this.iconImageUrl ??
        this.smallImageUrl ??
        this.mediumImageUrl ??
        this.largeImageUrl;
    return s;
  }
}
