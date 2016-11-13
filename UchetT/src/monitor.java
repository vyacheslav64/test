import java.text.SimpleDateFormat;
public class monitor extends Ustroystvo{
	public int size;
	public boolean color;
	String kind;
	public void addMonitor(String[] com ) {
		for (int i=0;i<com.length; i++) {
			String comTypeAndValue[]=com[i].split(" ", 2);
			//switch (comTypeAndValue[0]) {
			
			
			if (comTypeAndValue[0].equals("sku")){
				//System.out.println(comTypeAndValue[1].trim());
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

                   // String sd = "03.10.2008";
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
			
			
			
			if (comTypeAndValue[0].equals("size")){
				//System.out.println(comTypeAndValue[1].trim()); это было нудно для теста
			try {
		        this.size = Integer.parseInt(comTypeAndValue[1].trim());
		    } catch (NumberFormatException e) {  
		        System.err.println("Неверный формат size!");  
		    }
			}
			
			
			
			if (comTypeAndValue[0].equals("kind")){
				if (comTypeAndValue[1].trim().equals("TUBE")){this.kind="TUBE";}
				if (comTypeAndValue[1].trim().equals("LCD")){this.kind="LCD";}
				if (comTypeAndValue[1].trim().equals("PROJECTOR")){this.kind="PROJECTOR";}
			}
		}
	}

	
	
	
	
public String MoniToStr(){
	String str=new String();
	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
	str=String.valueOf(sku)+"--"+type+"--"+name+"--"+String.valueOf(format1.format(dateOfNew))+"--"+String.valueOf(color)+"--"+String.valueOf(size)+"--"+kind;
	return str;
}
}