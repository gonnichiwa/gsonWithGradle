package malangdayExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class MalangdayJsonToJavaExample {
	public static void main(String[] args){
		String jsonString =
				"[" +
					"{" +
						"'week' : 1," +
						"'ddayRangeStart' : 999999," +
						"'ddayRangeEnd' : 274," +
						"'imgAndMentionList' : " +
							"[" +
								"{'filename' : 'week1_img0.gif'}," +
								"{'filename' : 'week1_img1.gif'}" +
							"]" +
					"},"+
					"{" +
						"'week' : 2," +
						"'ddayRangeStart' : 273," +
						"'ddayRangeEnd' : 267," +
						"'imgAndMentionList' : " +
							"[" +
								"{'filename' : 'week2_img0.gif'}," +
								"{'filename' : 'week2_img1.gif'}" +
							"]" +
					"}"+
				"]";

		Gson gson = new Gson();
		WeekAndDayMention[] wamArr = gson.fromJson(jsonString, WeekAndDayMention[].class);
		List<WeekAndDayMention> list = Arrays.asList(wamArr);

		for(WeekAndDayMention wam : list){
			System.out.println("["+wam.week+","+wam.ddayRangeStart+","+wam.ddayRangeEnd+","+ wam.imageAndMentionList +"]");
		}
	}
}

class WeekAndDayMention {
	int week;
	int ddayRangeStart;
	int ddayRangeEnd;
	List<ImageAndMention> imageAndMentionList;

	class ImageAndMention {
		String filename;

		@Override
		public String toString() {
			return this.filename;
		}
	}
}

