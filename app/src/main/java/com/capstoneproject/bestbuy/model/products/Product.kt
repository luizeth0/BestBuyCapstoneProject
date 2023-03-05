package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("accessories")
    val accessories: List<Any?>? = null,
    @SerializedName("accessoriesImage")
    val accessoriesImage: Any? = null,
    @SerializedName("activationCharge")
    val activationCharge: String? = null,
    @SerializedName("active")
    val active: Boolean? = null,
    @SerializedName("activeUpdateDate")
    val activeUpdateDate: String? = null,
    @SerializedName("addToCartUrl")
    val addToCartUrl: String? = null,
    @SerializedName("affiliateAddToCartUrl")
    val affiliateAddToCartUrl: Any? = null,
    @SerializedName("affiliateUrl")
    val affiliateUrl: Any? = null,
    @SerializedName("albumLabel")
    val albumLabel: Any? = null,
    @SerializedName("albumTitle")
    val albumTitle: String? = null,
    @SerializedName("alternateCategories")
    val alternateCategories: List<Any?>? = null,
    @SerializedName("alternateViewsImage")
    val alternateViewsImage: Any? = null,
    @SerializedName("angleImage")
    val angleImage: Any? = null,
    @SerializedName("artistId")
    val artistId: Any? = null,
    @SerializedName("artistName")
    val artistName: Any? = null,
    @SerializedName("aspectRatio")
    val aspectRatio: Any? = null,
    @SerializedName("backViewImage")
    val backViewImage: Any? = null,
    @SerializedName("bestSellingRank")
    val bestSellingRank: Any? = null,
    @SerializedName("bundledIn")
    val bundledIn: List<Any?>? = null,
    @SerializedName("buybackPlans")
    val buybackPlans: List<Any?>? = null,
    @SerializedName("carrierModelNumber")
    val carrierModelNumber: Any? = null,
    @SerializedName("carrierPlan")
    val carrierPlan: Any? = null,
    @SerializedName("carrierPlans")
    val carrierPlans: List<Any?>? = null,
    @SerializedName("carriers")
    val carriers: List<Any?>? = null,
    @SerializedName("categoryPath")
    val categoryPath: List<CategoryPath?>? = null,
    @SerializedName("classId")
    val classId: Int? = null,
    @SerializedName("class")
    val classX: String? = null,
    @SerializedName("clearance")
    val clearance: Boolean? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("condition")
    val condition: String? = null,
    @SerializedName("contracts")
    val contracts: List<Any?>? = null,
    @SerializedName("crossSell")
    val crossSell: List<Any?>? = null,
    @SerializedName("customerReviewAverage")
    val customerReviewAverage: Double? = null,
    @SerializedName("customerReviewCount")
    val customerReviewCount: Int? = null,
    @SerializedName("customerTopRated")
    val customerTopRated: Boolean? = null,
    @SerializedName("department")
    val department: String? = null,
    @SerializedName("departmentId")
    val departmentId: Int? = null,
    @SerializedName("depth")
    val depth: String? = null,
    @SerializedName("description")
    val description: Any? = null,
    @SerializedName("devices")
    val devices: List<Any?>? = null,
    @SerializedName("digital")
    val digital: Boolean? = null,
    @SerializedName("dollarSavings")
    val dollarSavings: Int? = null,
    @SerializedName("earlyTerminationFees")
    val earlyTerminationFees: List<Any?>? = null,
    @SerializedName("energyGuideImage")
    val energyGuideImage: Any? = null,
    @SerializedName("esrbRating")
    val esrbRating: Any? = null,
    @SerializedName("familyIndividualCode")
    val familyIndividualCode: Any? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("freeShipping")
    val freeShipping: Boolean? = null,
    @SerializedName("freeShippingEligible")
    val freeShippingEligible: Boolean? = null,
    @SerializedName("frequentlyPurchasedWith")
    val frequentlyPurchasedWith: List<Any?>? = null,
    @SerializedName("friendsAndFamilyPickup")
    val friendsAndFamilyPickup: Boolean? = null,
    @SerializedName("fulfilledBy")
    val fulfilledBy: Any? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("headphoneJacks")
    val headphoneJacks: Boolean? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("homeDelivery")
    val homeDelivery: Boolean? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("images")
    val images: List<Image?>? = null,
    @SerializedName("inStoreAvailability")
    val inStoreAvailability: Boolean? = null,
    @SerializedName("inStoreAvailabilityText")
    val inStoreAvailabilityText: Any? = null,
    @SerializedName("inStoreAvailabilityUpdateDate")
    val inStoreAvailabilityUpdateDate: String? = null,
    @SerializedName("inStorePickup")
    val inStorePickup: Boolean? = null,
    @SerializedName("includedItemList")
    val includedItemList: List<IncludedItem?>? = null,
    @SerializedName("itemUpdateDate")
    val itemUpdateDate: String? = null,
    @SerializedName("largeFrontImage")
    val largeFrontImage: String? = null,
    @SerializedName("largeImage")
    val largeImage: String? = null,
    @SerializedName("leftViewImage")
    val leftViewImage: Any? = null,
    @SerializedName("lengthInMinutes")
    val lengthInMinutes: Int? = null,
    @SerializedName("linkShareAffiliateAddToCartUrl")
    val linkShareAffiliateAddToCartUrl: String? = null,
    @SerializedName("linkShareAffiliateUrl")
    val linkShareAffiliateUrl: String? = null,
    @SerializedName("listingId")
    val listingId: Any? = null,
    @SerializedName("lists")
    val lists: List<Any?>? = null,
    @SerializedName("longDescription")
    val longDescription: String? = null,
    @SerializedName("lowPriceGuarantee")
    val lowPriceGuarantee: Boolean? = null,
    @SerializedName("manufacturer")
    val manufacturer: String? = null,
    @SerializedName("marketplace")
    val marketplace: Any? = null,
    @SerializedName("mediaCount")
    val mediaCount: Any? = null,
    @SerializedName("mediumImage")
    val mediumImage: String? = null,
    @SerializedName("members")
    val members: List<Any?>? = null,
    @SerializedName("minutePrice")
    val minutePrice: String? = null,
    @SerializedName("mobileUrl")
    val mobileUrl: String? = null,
    @SerializedName("modelNumber")
    val modelNumber: String? = null,
    @SerializedName("monoStereo")
    val monoStereo: Any? = null,
    @SerializedName("monthlyRecurringCharge")
    val monthlyRecurringCharge: String? = null,
    @SerializedName("monthlyRecurringChargeGrandTotal")
    val monthlyRecurringChargeGrandTotal: String? = null,
    @SerializedName("mpaaRating")
    val mpaaRating: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("new")
    val new: Boolean? = null,
    @SerializedName("numberOfPlayers")
    val numberOfPlayers: Any? = null,
    @SerializedName("onSale")
    val onSale: Boolean? = null,
    @SerializedName("onlineAvailability")
    val onlineAvailability: Boolean? = null,
    @SerializedName("onlineAvailabilityText")
    val onlineAvailabilityText: Any? = null,
    @SerializedName("onlineAvailabilityUpdateDate")
    val onlineAvailabilityUpdateDate: String? = null,
    @SerializedName("orderable")
    val orderable: String? = null,
    @SerializedName("originalReleaseDate")
    val originalReleaseDate: Any? = null,
    @SerializedName("outletCenter")
    val outletCenter: Any? = null,
    @SerializedName("parentalAdvisory")
    val parentalAdvisory: Any? = null,
    @SerializedName("percentSavings")
    val percentSavings: String? = null,
    @SerializedName("planCategory")
    val planCategory: Any? = null,
    @SerializedName("planFeatures")
    val planFeatures: List<Any?>? = null,
    @SerializedName("planPrice")
    val planPrice: Any? = null,
    @SerializedName("planType")
    val planType: Any? = null,
    @SerializedName("platform")
    val platform: Any? = null,
    @SerializedName("plot")
    val plot: String? = null,
    @SerializedName("preowned")
    val preowned: Boolean? = null,
    @SerializedName("priceRestriction")
    val priceRestriction: Any? = null,
    @SerializedName("priceUpdateDate")
    val priceUpdateDate: String? = null,
    @SerializedName("priceWithPlan")
    val priceWithPlan: List<Any?>? = null,
    @SerializedName("productAspectRatio")
    val productAspectRatio: String? = null,
    @SerializedName("productFamilies")
    val productFamilies: List<Any?>? = null,
    @SerializedName("productId")
    val productId: Any? = null,
    @SerializedName("productTemplate")
    val productTemplate: String? = null,
    @SerializedName("productVariations")
    val productVariations: List<ProductVariation?>? = null,
    @SerializedName("proposition65WarningMessage")
    val proposition65WarningMessage: Any? = null,
    @SerializedName("proposition65WarningType")
    val proposition65WarningType: String? = null,
    @SerializedName("protectionPlanDetails")
    val protectionPlanDetails: List<Any?>? = null,
    @SerializedName("protectionPlanHighPrice")
    val protectionPlanHighPrice: String? = null,
    @SerializedName("protectionPlanLowPrice")
    val protectionPlanLowPrice: String? = null,
    @SerializedName("protectionPlanTerm")
    val protectionPlanTerm: String? = null,
    @SerializedName("protectionPlanType")
    val protectionPlanType: Any? = null,
    @SerializedName("protectionPlans")
    val protectionPlans: List<Any?>? = null,
    @SerializedName("quantityLimit")
    val quantityLimit: Int? = null,
    @SerializedName("regularPrice")
    val regularPrice: Double? = null,
    @SerializedName("relatedProducts")
    val relatedProducts: List<Any?>? = null,
    @SerializedName("releaseDate")
    val releaseDate: String? = null,
    @SerializedName("remoteControlImage")
    val remoteControlImage: Any? = null,
    @SerializedName("requiredParts")
    val requiredParts: List<Any?>? = null,
    @SerializedName("rightViewImage")
    val rightViewImage: Any? = null,
    @SerializedName("salePrice")
    val salePrice: Double? = null,
    @SerializedName("salesRankLongTerm")
    val salesRankLongTerm: Any? = null,
    @SerializedName("salesRankMediumTerm")
    val salesRankMediumTerm: Any? = null,
    @SerializedName("salesRankShortTerm")
    val salesRankShortTerm: Any? = null,
    @SerializedName("score")
    val score: Any? = null,
    @SerializedName("screenFormat")
    val screenFormat: String? = null,
    @SerializedName("secondaryMarket")
    val secondaryMarket: Any? = null,
    @SerializedName("sellerId")
    val sellerId: Any? = null,
    @SerializedName("shipping")
    val shipping: List<Shipping?>? = null,
    @SerializedName("shippingCost")
    val shippingCost: Double? = null,
    @SerializedName("shippingLevelsOfService")
    val shippingLevelsOfService: List<ShippingLevelsOfService?>? = null,
    @SerializedName("shippingRestrictions")
    val shippingRestrictions: Any? = null,
    @SerializedName("shippingWeight")
    val shippingWeight: Double? = null,
    @SerializedName("shortDescription")
    val shortDescription: Any? = null,
    @SerializedName("sku")
    val sku: Int? = null,
    @SerializedName("softwareAge")
    val softwareAge: Any? = null,
    @SerializedName("softwareGrade")
    val softwareGrade: Any? = null,
    @SerializedName("softwareNumberOfPlayers")
    val softwareNumberOfPlayers: Any? = null,
    @SerializedName("source")
    val source: Any? = null,
    @SerializedName("specialOrder")
    val specialOrder: Boolean? = null,
    @SerializedName("spin360Url")
    val spin360Url: Any? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("studio")
    val studio: String? = null,
    @SerializedName("studioLive")
    val studioLive: Any? = null,
    @SerializedName("subclass")
    val subclass: String? = null,
    @SerializedName("subclassId")
    val subclassId: Int? = null,
    @SerializedName("techSupportPlans")
    val techSupportPlans: List<Any?>? = null,
    @SerializedName("technologyCode")
    val technologyCode: Any? = null,
    @SerializedName("theatricalReleaseDate")
    val theatricalReleaseDate: String? = null,
    @SerializedName("thumbnailImage")
    val thumbnailImage: String? = null,
    @SerializedName("topViewImage")
    val topViewImage: Any? = null,
    @SerializedName("tradeInValue")
    val tradeInValue: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("upc")
    val upc: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("validFrom")
    val validFrom: Any? = null,
    @SerializedName("validUntil")
    val validUntil: Any? = null,
    @SerializedName("warrantyLabor")
    val warrantyLabor: String? = null,
    @SerializedName("warrantyParts")
    val warrantyParts: String? = null,
    @SerializedName("weight")
    val weight: String? = null,
    @SerializedName("width")
    val width: String? = null
)