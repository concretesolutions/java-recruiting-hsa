class CouponModel {
  String id;
	String description;
	String seller;
	String image;
	String expiresAt; 

  CouponModel({
    this.id,
    this.description,
    this.seller,
    this.image,
    this.expiresAt
  });

  factory CouponModel.fromJson(Map<String, dynamic> json) {
    return CouponModel(
        id: json["id"],
        description: json["description"],
        seller: json["seller"],
        image: json["image"],
        expiresAt: json["expiresAt"]);
  }
}