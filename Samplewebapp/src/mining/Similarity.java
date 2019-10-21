package mining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Similarity {
	private List<String[]> bidFile = new ArrayList<String[]>();
	private static final long serialVersionUID = 1L;

	public void readInMemory() throws Exception {

		String csvFile = "/Users/akankshadeshpande/eclipse-workspace/Samplewebapp/resources/Restaurants.csv";
		BufferedReader br = null;
		String line = "";
		String csvsplit = ",";
		String[] result = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				result = line.split(csvsplit);
				bidFile.add(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (br != null)
				br.close();
		}
	}

	public List<List<String>> cosim(String city, String bid) throws Exception {
		readInMemory();
		String[] test = null;
		String thiscity = city;
		String thisbid = bid;
		Float num, denom, temp, temp2, result = null;
		bidFile.remove(0); // Removes Headers
		
		for(String[] line :bidFile){
			if(line[6].contains(thiscity) && line[5].contains(thisbid)){
				test = line;
				break;
			}	
		
		}
		System.out.println(" test --> " + test[1] + test[2] + test[3]);
		List<Cosine> list = new ArrayList<Cosine>();
		List<List<String>> retArr = new ArrayList<>();
		for (String[] line : bidFile) {
			if (line[6].contains(thiscity)) {
				Integer rc = Integer.parseInt(line[1]);
				Float star = Float.parseFloat(line[10]);
				Integer trc = Integer.parseInt(test[1]);
				Float tstar = Float.parseFloat(test[10]);
				num = (rc * trc) + (star * tstar);
				temp = (float) (Math.pow(rc, 2) + Math.pow(star, 2));
				temp2 = (float) (Math.pow(trc, 2) + Math.pow(tstar, 2));
				denom = (float) (Math.sqrt(temp) * Math.sqrt(temp2));
				result = num / denom;
				Cosine obj = new Cosine(line, result);
				list.add(obj);

			}
		}
		Collections.sort(list,
				Collections.reverseOrder(new Comparator<Cosine>() {
					@Override
					public int compare(Cosine c1, Cosine c2) {
						return c1.getResult().compareTo(c2.getResult());
					}

				}));

		int i = 0;
		for (Cosine c : list) {
			i++;
			if (i > 20)
				break;
			List<String> j = new ArrayList<>();
			j.add(c.getLine()[2]);
			j.add(c.getLine()[6]);
			j.add(c.getLine()[10]);
			retArr.add(j);
			
			System.out.println(c.getLine()[2] + c.getLine()[6] + c.getResult());
			// return c.getLine()[2];
			// pw.println(c.getLine()[2] + c.getLine()[6] + c.getResult());
		}
		return retArr;
	}

}
