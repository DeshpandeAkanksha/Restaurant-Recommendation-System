package mining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import au.com.bytecode.opencsv.CSVReader;

public class GenerateMaps {

	static Hashtable<String, Hashtable<String, String>> userMap = new Hashtable<String, Hashtable<String, String>>();
	static Hashtable<String, Hashtable<String, String>> businessMap = new Hashtable<String, Hashtable<String, String>>();
	static ArrayList<String> user = new ArrayList<String>();

	public static void generateMap(String path) {
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(path));
			String[] nextLine;
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
				if (!nextLine[7].equalsIgnoreCase("NULL")
						&& nextLine[7].length() == 1) {
					if (userMap.get(nextLine[3]) == null)
						userMap.put(nextLine[3],
								new Hashtable<String, String>());
					userMap.get(nextLine[3]).put(nextLine[6], nextLine[7]);
					if (businessMap.get(nextLine[6]) == null)
						businessMap.put(nextLine[6],
								new Hashtable<String, String>());
					businessMap.get(nextLine[6]).put(nextLine[3], nextLine[7]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
//	private static void printSortedList(List<SortedStars> sortedList) {
//		Collections.sort(sortedList);
//		// for(int i=(sortedList.size()-1); i>0; i--)
//		// System.out.println(sortedList.get(i).getId() + " --->  " +
//		// sortedList.get(i).getStar());
//		printdetails(sortedList);
//	}

	private static List<List<String>> printdetails(List<SortedStars> detailList) {

		Collections.sort(detailList);

		Set<String> set = new HashSet<>();

		for(SortedStars s: detailList) {

			set.add(s.getId());

		}

		List<String> finalList = new ArrayList<>(set);

		

		List<List<String>> retArr = new ArrayList<>();

		try {

			Map<String, String[]> bidMap = readInMemory();

			for(int i=(finalList.size()-1); i>0; i--){

				System.out.println("BID----" + finalList.get(i));

				String[] details = bidMap.get(finalList.get(i));

				List<String> j = new ArrayList<>();				

				j.add(details[2]);

				j.add(details[6] + details[7]);

				j.add(details[10]);



				retArr.add(j);

			}



		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return retArr;



	}
	private static Map<String, String[]> readInMemory() throws Exception {

		String csvFile = "/Users/akankshadeshpande/eclipse-workspace/Samplewebapp/resources/Restaurants.csv";
		BufferedReader br = null;
		String line = "";
		String csvsplit = ",";
		String[] result = null;
		Map<String, String[]> bidMap = new HashMap<>();
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				result = line.split(csvsplit);
				bidMap.put(result[5], result);
				// bidFile.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (br != null)
				br.close();
		}
		return bidMap;
	}

	public static List<List<String>> recommendBusiness(String userId) {
		List<SortedStars> sortedList = new ArrayList<SortedStars>();
		Hashtable<String, String> businessList = userMap.get(userId);
		String max = Collections.max(businessList.values());
		String key = null;
		Enumeration<String> enu = businessList.keys();
		while (enu.hasMoreElements()) { // business with highest stars
			key = enu.nextElement();
			if (businessList.get(key).equalsIgnoreCase(max)) {
				System.out.println("max value key for Business = " + key
						+ " -- value = " + max);
				System.out.println();
				Hashtable<String, String> usersList = businessMap.get(key); // users
																			// list
				String maxUser = Collections.max(usersList.values());
				String keyUser = null;
				Enumeration<String> enuUser = usersList.keys();
				int j = 0;
				while (enuUser.hasMoreElements()) { // users who reviewed this
													// restaurants
					System.out.println("User - " + j++);
					System.out.println();
					keyUser = enuUser.nextElement();
					if (usersList.get(keyUser).equalsIgnoreCase(maxUser)) {
						// recommend all the restaurants for this user
						user.add(keyUser);
						Hashtable<String, String> recoBusinessList = userMap
								.get(keyUser);
						String maxBusiness = Collections.max(recoBusinessList
								.values());
						String keyBusiness = null;
						Enumeration<String> enuBusiness = recoBusinessList
								.keys();
						int i = 0;
						while (enuBusiness.hasMoreElements()) {
							keyBusiness = enuBusiness.nextElement();
							if (recoBusinessList.get(keyBusiness) != null
									&& !keyBusiness.equalsIgnoreCase("#NAME?")) {
								try {
									SortedStars ss = new SortedStars(
											keyBusiness,
											recoBusinessList.get(keyBusiness));
									sortedList.add(ss);
								} catch (NoSuchElementException nsee) {
								}
							}
						}
					}
				}
				break;
			}
		}
		
		return printdetails(sortedList);

	}


}