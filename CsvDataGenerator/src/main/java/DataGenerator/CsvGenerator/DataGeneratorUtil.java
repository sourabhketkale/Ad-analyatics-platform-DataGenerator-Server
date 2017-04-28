package DataGenerator.CsvGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import DataGenerator.pojo.CampiagnData;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author Sourabh Ketkale
 *
 */
public class DataGeneratorUtil{
	
	
	private final String filePath = "//home//k2//data//campaignData.csv";
	
	/**
	 * 
	 * @method: pick a random ad-type from an array
	 * */
	public static int getRandomAdType(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
	/**
	 * @method: Pick random number between a range of numbers for a field
	 * 
	 * */
	public static int getRandomDemoNumberBetweenARange(int Max, int Min){
		
		return Min + (int)(Math.random() * ((Max - Min) + 1));

	}
	/**
	 * 
	 * @method: Pick random Gender
	 * */
	public static String getRandomGender(String[] genderArray){
		
		return genderArray[new Random().nextInt(genderArray.length)];
		
	}
	/**
	 * 
	 * @method: Pick a random City  
	 * */
	public static String getRandomCity(String[] city ){
		
		return city[new Random().nextInt(city.length)];
	}
	/**
	 * @author Sourabh Ketkale
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @metod: write-append next reocrd to the existing csv 
	 * */
	public void csvImplementations(CampiagnData campaignDataObject) throws JsonGenerationException, JsonMappingException, IOException{
			
		 CSVWriter writer  = new CSVWriter(new FileWriter(filePath, true));
		 String[] record = (campaignDataObject.getCampaignId()+
				 			","+campaignDataObject.getAdType()+
				 			","+campaignDataObject.getAdCost()+
				 			","+campaignDataObject.getAdCpm()+
				 			","+campaignDataObject.getAdViews()+
				 			","+campaignDataObject.getAdImpressions()+
				 			","+campaignDataObject.getAdClicks()+
				 			","+campaignDataObject.getAdBudget()+
				 			","+campaignDataObject.getDemographicsAgeMax()+
				 			","+campaignDataObject.getDemographicsAgeMin()+
				 			","+campaignDataObject.getDemographicsGender()+
				 			","+campaignDataObject.getDemographicsCity()).toString().split(",");
		 
		 writer.writeNext(record);
		 writer.close();
        
	}
	
	
	/**
	 * 
	 * @method: Generate random mock data for each data field in the pojo
	 * */
	public void generateDataMock() throws IOException{
        
        int AdType[] = {1,2,3,4,5,6,7,8,9,10};
        int upperLimitMaxAge = 90;
        int lowerLimitMaxAge = 50;
        int uppperLimitMinAge= 49;
        int lowerLimitMinAge = 9;
        String[] gender = {"M", "F"};
        String[] city = {"San Francisco","San Jose","San Diego","New York","Austin","Boston","Delhi","Mumbai","London","Palo Alto","Redwood City","Menlo Park","Monte Carlo","Amsterdam","Purito Rico","honolulu","Pune","Berlin","Sevilla","Helsinki","Istanbul","Alaska City","Seattle","Dublin"};
        int campaignId = 1001;
        while(true){
        	CampiagnData campiagnData = new CampiagnData();
        	
        	campiagnData.setCampaignId(Math.incrementExact(campaignId));
        	campaignId += 1;
        	campiagnData.setAdType(DataGeneratorUtil.getRandomAdType(AdType));
        	campiagnData.setAdCost( DataGeneratorUtil.getRandomDemoNumberBetweenARange(1000, 0));
        	campiagnData.setAdClicks( DataGeneratorUtil.getRandomDemoNumberBetweenARange(10000, 0));//
        	campiagnData.setAdBudget(DataGeneratorUtil.getRandomDemoNumberBetweenARange(10000, 0));//
        	campiagnData.setAdImpressions(DataGeneratorUtil.getRandomDemoNumberBetweenARange(100000, 0));//
        	campiagnData.setDemographicsAgeMax(DataGeneratorUtil.getRandomDemoNumberBetweenARange(upperLimitMaxAge, lowerLimitMaxAge));
        	campiagnData.setDemographicsAgeMin(DataGeneratorUtil.getRandomDemoNumberBetweenARange(uppperLimitMinAge, lowerLimitMinAge));
        	campiagnData.setDemographicsGender(DataGeneratorUtil.getRandomGender(gender));
        	campiagnData.setAdViews( DataGeneratorUtil.getRandomDemoNumberBetweenARange(10000, 0));
        	campiagnData.setAdCpm( DataGeneratorUtil.getRandomDemoNumberBetweenARange(10, 0));
        	campiagnData.setDemographicsCity(DataGeneratorUtil.getRandomCity(city));
        	DataGeneratorUtil generatorUtil = new DataGeneratorUtil();
        	generatorUtil.csvImplementations(campiagnData);
        	
        }
        
       
    }

    public static void main( String[] args ) throws IOException{
        
    	DataGeneratorUtil dataGeneratorUtil = new DataGeneratorUtil();
    	dataGeneratorUtil.generateDataMock();
    	
    }
}
