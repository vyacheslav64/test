package pckgUchet;

import java.text.SimpleDateFormat;

public class printer extends Ustroystvo{
	public boolean color;
	public boolean network;
	

	
	public void addPrinter(String[] com ) {
		for (int i=0;i<com.length; i++) {
			String comTypeAndValue[]=com[i].split(" ", 2);

			
			
			if (comTypeAndValue[0].equals("sku")){

			try {
		        this.sku = Integer.parseInt(comTypeAndValue[1].trim());
		    } catch (NumberFormatException e) {  
		        System.err.println("Неверный формат sku!");  
		    }
			}
			
			
			if (comTypeAndValue[0].equals("type")){
				this.type=comTypeAndValue[1].trim();
			}
			
			
			if (comTypeAndValue[0].equals("name")){
				this.name=comTypeAndValue[1];
			}
			
			
			if (comTypeAndValue[0].equals("date")){
				try {


                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    this.dateOfNew= format.parse(comTypeAndValue[1]);
			
					} catch (Exception e) {
						System.err.println("Неверный формат date!"); 
					}
			}
			
			
			if (comTypeAndValue[0].equals("color")){
				if (comTypeAndValue[1].equals("цветной ")){this.color=true;}
				if (comTypeAndValue[1].equals("ч/б ")){this.color=false;}
			}
			
			
			
			
			
			
			if (comTypeAndValue[0].equals("network")){
				if (comTypeAndValue[1].trim().equals("сетевой")){this.network=true;}
				if (comTypeAndValue[1].trim().equals("локальный")){this.network=false;}
			}
		}
	}

	
	
	public String PrinterToStr(){
		String str=new String();
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		str=String.valueOf(sku)+"--"+type+"--"+name+"--"+String.valueOf(format1.format(dateOfNew))+"--"+String.valueOf(color)+"--"+String.valueOf(network);
		return str;
	}
}
