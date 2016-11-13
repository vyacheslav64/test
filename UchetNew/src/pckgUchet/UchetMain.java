package pckgUchet;


import java.io.File;
import java.util.*;


public class UchetMain {

	public static void main(String[] args) {

		
		System.out.println("Hello World");
		
		String[] SkuAndType =new String[1000]; 
		for (int i=0; i<1000;i++) {SkuAndType[i]="empty";}
		

		Scanner forReadFile;
		try {
			forReadFile=new Scanner(new File("res//datab.txt"));
			while(forReadFile.hasNext()){

					
					String a=forReadFile.nextLine();

					String[] arr=a.split("--", 2);

					int skuA=Integer.parseInt(arr[0].trim());

					SkuAndType[skuA]=a;


			}
		}catch (Exception e) {}
		

		
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			String command;
			command = sc.nextLine();
			if (command.equals("exit")) {
				try{
				Formatter x=new Formatter("res//datab.txt");
				for (int i=0;i<1000;i++){
					if (!SkuAndType[i].equals("empty")){
						x.format(SkuAndType[i]+"\n");
					}
				}
				x.close();
				} catch(Exception e){};
				sc.close();
				break;
			}

			String[] commandArray=command.split("--");

			
			if (commandArray[0].equals("add ")) {
				switch (commandArray[2]) {
				case "type PRINTER ":
					printer p=new printer();
					p.addPrinter(commandArray);
					if (!SkuAndType[p.sku].equals("empty")) {System.out.println("SKU уже есть, перезаписываю");}
					SkuAndType[p.sku]=p.PrinterToStr();
					System.out.println(p.PrinterToStr());
					break;
				case "type SCANER ":
					scaner s=new scaner();
					s.addScaner(commandArray);
					if (!SkuAndType[s.sku].equals("empty")) {System.out.println("SKU уже есть, перезаписываю");}
					SkuAndType[s.sku]=s.ScanerToStr();
					System.out.println(s.ScanerToStr());
					break;
				case "type MONITOR ":
					monitor m=new monitor();
					m.addMonitor(commandArray);

					if (!SkuAndType[m.sku].equals("empty")) {System.out.println("SKU уже есть, перезаписываю");}
					SkuAndType[m.sku]=m.MoniToStr();

					break;
				default:
					System.out.println("I don't know this type");
					break;
				}
				}	
				if (command.equals("delete")) {
					System.out.println("”далить все? введите yes");
					Scanner scdel = new Scanner(System.in);
					String commandDel=scdel.nextLine();
					if (commandDel.equals("yes")) {
						for (int i=0; i<1000;i++) {
							SkuAndType[i]="empty";
							}
						scdel.close();
						}
				}
				
				if (commandArray[0].equals("delete ") && !commandArray[1].equals(null)) {
					String[] skuForDel =commandArray[1].split(" ");
					SkuAndType[Integer.parseInt(skuForDel[1].trim())]="empty";
				}
				
				if (command.equals("list")) {
					for (int i=0;i<1000;i++)
						if (!SkuAndType[i].equals("empty")){
							System.out.println(SkuAndType[i]);
						}
				}

		}
	}
}

