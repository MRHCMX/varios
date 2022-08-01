package varios;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BuscaEnArray {
	public static void main(String[] args) {
		BuscaEnArray utils = new BuscaEnArray();
		String eligiblePediatric = "{\"eligiblePediatric\":[{\"age\":20,\"state\":[\"MS\",\"PR\"]},{\"age\":18,\"state\":[\"NE\",\"AL\"]}]}";
		int pediatricAge = 17;
		String sPediatric = "Pediatric";
		String sAdult = "Adult";
		
		//Calculate edge in years
		String sbirthDate = "1974-08-15";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate birthDate = LocalDate.parse(sbirthDate, fmt) ;
		
		int age = utils.calcEdge(birthDate);
		System.out.println("Edad: " + age);
		
		if (age <= pediatricAge)
		{
			System.out.println("Edad: ");
		}
		
		String[] arreglo = { "David", "StackOverflow", "StackOverflow en español" };
		String sVal = "David";
		
		if (utils.searchInArray(sVal, arreglo))
			System.out.println("Valor encontrado");
		else
			System.out.println("Valor no encontrado");
		
		
	}
	
	public boolean searchInArray(String sVal, String[] arreglo) 
	{
		String resultado = Arrays.stream(arreglo)
		                         .filter(s -> s.equals(sVal))
		                         .findFirst()
		                         .orElse(null);
		if (resultado != null) {
		    return true;
		} else {
			return false;
		}
	}
	
	public int calcEdge(LocalDate birthDate)
	{
		//Calculate edge in years
		int edge = 0;
		
		Period period = Period.between(birthDate, LocalDate.now());
		edge = period.getYears();
		
		return edge;
	}
	
	public String calcEdgeGroup(int age)
	{
		String edgeGroup = "noGroup";
		String ageGroupArr = "{\"ageGroups\":[{\"ageMin\":0,\"ageMax\":6,\"desc\":\"0-6\"},{\"ageMin\":7,\"ageMax\":11,\"desc\":\"7-11\"},{\"ageMin\":12\"ageMax\":17,\"desc\":\"12-18*\"},{\"ageMin\":18,\"ageMax\":188,\"desc\":\"18+\"}]}";
		
		//ObjectMapper objectMapper = new ObjectMapper();
		
		return edgeGroup;
	}
}
