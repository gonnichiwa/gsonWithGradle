package javaToJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JavaToJsonAndPrint {
	public static void main(String[] args){

		// Albums 객체 1개 이용하여 json build
		buildAlbumsToJson();
	}

	/**
	 * result :
	 * buildAlbumsToJson()->{"title":"Free Music Archive - javaToJson.Albums","message":"","errors":[],"total":"11259","total_pages":2252,"page":1,"limit":"5"}
	 * */
	private static void buildAlbumsToJson() {
		Albums albums = new Albums();
		albums.title = "Free Music Archive - javaToJson.Albums";
		albums.message = "";
		albums.total = "11259";
		albums.total_pages = 2252;
		albums.page = 1;
		albums.limit = "5";

		DataSet dataSet = new DataSet();
		dataSet.album_id = "7596";
		dataSet.album_title = "Album 1";

		AlbumImages image = new AlbumImages();
		image.image_id = "1";

		dataSet.images.add(image);
		albums.dataset.add(dataSet);

		GsonBuilder gb = new GsonBuilder().setPrettyPrinting().serializeNulls();
		Gson gson = gb.create();

		System.out.println("buildAlbumsToJson()-below");
		System.out.println(gson.toJson(albums));
	}

}// JavaToJsonAndPrint
class Albums {
	public String title;
	public String message;
	public List<String> errors = new ArrayList<String>();
	public String total;
	public int total_pages;
	public int page;
	public String limit;
	public List<DataSet> dataset = new ArrayList<DataSet>();
}

class DataSet {
	public String album_id;
	public String album_title;
	// 아래 @SerializedName과 같이 building하는 json key의 이름을 바꿀 수 있다 (안쓰면 멤버변수명 그대로 build)
	@SerializedName("album_images")
	List<AlbumImages> images = new ArrayList<AlbumImages>();
}

class AlbumImages {
	public String image_id;
	public String image_name;
}