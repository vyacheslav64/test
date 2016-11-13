package pckgUchet;

import java.text.SimpleDateFormat;

public class scaner extends Ustroystvo {
	public boolean color;
	public boolean networkWiFi;
	public boolean networkEthernet;

	
	public void addScaner(String[] com ) {
		for (int i=0;i<com.length; i++) {
			String comTypeAndValue[]=com[i].split(" ", 2);
			
			
			
			if (comTypeAndValue[0].equals("sku")){
				
			try {
		        this.sku = Integer.parseInt(comTypeAndValue[1].trim());
		    } catch (NumberFormatException e) {  
		        System.err.println("�������� ������ sku!");  
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
						System.err.println("�������� ������ date!"); 
					}
			}
			
			
			if (comTypeAndValue[0].equals("color")){
				if (comTypeAndValue[1].equals("������� ")){this.color=true;}
				if (comTypeAndValue[1].equals("�/� ")){this.color=false;}
			}
			
			
			
			
			
			
			if (comTypeAndValue[0].equals("network")){
				if (comTypeAndValue[1].trim().equals("-")){this.networkWiFi=false; this.networkEthernet=false;}
				if (comTypeAndValue[1].trim().equals("Ethernet")){this.networkWiFi=false; this.networkEthernet=true;}
				if (comTypeAndValue[1].trim().equals("WiFi")){this.networkWiFi=true; this.networkEthernet=false;}
				if (comTypeAndValue[1].trim().equals("Ethernet,Wifi") || comTypeAndValue[1].trim().equals("WiFi,Ethernet")){this.networkWiFi=true; this.networkEthernet=true;}
			}
		}
	}

	
	
	public String ScanerToStr(){
		String str=new String();
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		str=String.valueOf(sku)+"--"+type+"--"+name+"--"+String.valueOf(format1.format(dateOfNew))+"--"+String.valueOf(color)+"--"+String.valueOf(networkWiFi)+"--"+String.valueOf(networkEthernet);
		return str;
	}
}
