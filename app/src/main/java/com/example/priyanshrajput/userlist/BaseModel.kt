import com.google.gson.annotations.SerializedName



	data class BaseModel (

		@SerializedName("id") val id : Int,
		@SerializedName("first_name") val first_name : String,
		@SerializedName("last_name") val last_name : String,
		@SerializedName("email") val email : String,
		@SerializedName("gender") val gender : String,
		@SerializedName("profile_image") val profile_image : String,
		@SerializedName("address") val address : String
)